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
        //Нужно по id получить студента для модификации
        //Кладем полученную id на переменную
        String id = req.getParameter("hiddenModify");

        //Получить
        DBServices services = new DBServices();
        Student student = services.getStudentById(id);

        //Cтудента из SQL перенаправить в запросе на student_Modify.jsp
        req.setAttribute("student", student);
        req.getRequestDispatcher("WEB-INF/Student_Modify.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Нужно из запроса получить данные формы по созданию студента
        String id = req.getParameter("id");
        String surname = req.getParameter("surname");
        String name = req.getParameter("name");
        String group= req.getParameter("group");
        String dateFromUser= req.getParameter("date");

        //Создаем объект подключения к БД
        DBServices dbServices = new DBServices();

        //Формат даты
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
        //Перенаправляем клиента на studentsList.jsp
        resp.sendRedirect("/studentsList");
    }
}
