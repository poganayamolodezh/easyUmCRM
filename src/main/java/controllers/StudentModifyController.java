package controllers;

import db.DBServices;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
}
