package controllers;

import db.DBServices;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@WebServlet(name="StudentModifyController", urlPatterns = "/student-modify")
public class StudentModifyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //����� �� id �������� �������� ��� �����������
        //������ ���������� id �� ����������
        String id = req.getParameter("hiddenModify");

        //��������
        DBServices services = new DBServices();
        Student student = services.getStudentById(id);

        //C������� �� SQL ������������� � ������� �� student_Modify.jsp
        req.setAttribute("student", student);
        req.getRequestDispatcher("WEB-INF/Student_Modify.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //����� �� ������� �������� ������ ����� �� �������� ��������
        String id = req.getParameter("id");
        String surname = req.getParameter("surname");
        String name = req.getParameter("name");
        String group= req.getParameter("group");
        String dateFromUser= req.getParameter("date");

        //������� ������ ����������� � ��
        DBServices dbServices = new DBServices();

        //������ ����
        //String to Date
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date date;
        try {
            date = format.parse(dateFromUser);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        //Date to String
        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateToBd = formatter.format(date);
        dbServices.modifyStudent(id,surname,name,group,dateToBd);
        //�������������� ������� �� studentsList.jsp
        resp.sendRedirect("/studentsList");
    }
}
