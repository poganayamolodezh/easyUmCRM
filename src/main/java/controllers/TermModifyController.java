package controllers;

import db.DBServices;
import entity.Discipline;
import entity.Term;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TermModifyController", urlPatterns = "/term-modify")
public class TermModifyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Сохраним id полученную от формы куда она пришла куда она пришла из функции js
        String id = req.getParameter("hiddenModifyTerm");

        //Получить по id семестр из SQL
        DBServices services = new DBServices();
        Term term =services.getTermById(id);

        //Получить список дисциплин из выбранного семестра
        List <Discipline> disciplineList = services.getAllActiveDisciplines();

        //Перенаправляем запрос на modify_term.jsp, но добавив атрибуты для наполнения страницы
        req.setAttribute("term", term);
        req.setAttribute("disciplineList", disciplineList);
        req.getRequestDispatcher("WEB-INF/modify_term.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String id = req.getParameter("id");

    }
}
