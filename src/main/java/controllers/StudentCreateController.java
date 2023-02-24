package controllers;

import db.DBServices;

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

@WebServlet(name = "StudentCreateController", urlPatterns = "/student-create")

public class StudentCreateController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/student-create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Код 300 - ошибка перенаправления на другой сервер
        //Код 404 - TomCat не нашел сервлет (контроллер) по указанному в req url
        //Код 405 - TomCat нашел контроллер, но нет метода doGet или doPost
        //Код 500 - Сервер получил ошибку или исключительную ситуацию и не знал, что ответить на фронт


        //Нужно из запроса получить данные формы по созданию студента
        String surname = req.getParameter("surname");
        String name = req.getParameter("name");
        String group= req.getParameter("group");
        String date= req.getParameter("date");

        if(surname == null || surname.equals("")||
                name ==null|| name.equals("")||
                group == null || group.equals("")||
                date == null || date.equals("")){
            req.setAttribute("Error",1);
            req.getRequestDispatcher("WEB-INF/student-create.jsp").forward(req, resp);
            return;

        }

        //Создаем объект подключения к БД
        DBServices dbServices = new DBServices();

        //Формат даты
            //String to Date
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date dateFromUser;
        try {
            dateFromUser = format.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        //Date to String
        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateToBd = formatter.format(dateFromUser);
        dbServices.createStudent(surname,name,group,dateToBd);
        //Перенаправляем клиента на studentsList.jsp
        resp.sendRedirect("/studentsList");
    }
}
