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

@WebServlet(name = "TermController", urlPatterns = "/termList")
public class TermController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Получим из БД все семестры для страницы
        DBServices services = new DBServices();
        List<Term> terms = services.getAllActiveTerms();
        req.setAttribute("terms", terms);

        //Определим нажал ли кнопку Выбрать пользователь
        String idSelectedTerm = req.getParameter("idSelectedTerm");
        if(idSelectedTerm == null){
            if(terms.size()!=0){
            //Открытие страницы семестры
            Term selectedTerm = terms.get(0);
            req.setAttribute("selectedTerm", selectedTerm);
            //Добавим в атрибуты дисциплины этого семестра
            List<Discipline> disciplines = services.getDisciplinesByTerm(selectedTerm.getId()+"");
            req.setAttribute("disciplines", disciplines);
            }
        }else{
            //Нажата кнопка выбрать на странице семестры
            //Если idSelectedTerm != null, то вытягиваем его из базы
            Term selectedTerm = services.getTermById(idSelectedTerm);
            req.setAttribute("selectedTerm", selectedTerm);

            List<Discipline> disciplines = services.getDisciplinesByTerm(selectedTerm.getId()+"");
            req.setAttribute("disciplines", disciplines);
        }
        req.getRequestDispatcher("WEB-INF/termList.jsp").forward(req, resp);
    }
}
