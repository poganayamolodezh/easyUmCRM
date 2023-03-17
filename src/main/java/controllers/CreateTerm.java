package controllers;

import db.DBServices;
import entity.Discipline;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CreateTerm", urlPatterns = "/term-create")
public class CreateTerm extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBServices services = new DBServices();
        List<Discipline> disciplines = services.getAllActiveDisciplines();
        req.setAttribute("disciplines", disciplines);

        req.getRequestDispatcher("WEB-INF/create_term.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String duration = req.getParameter("duration");
        String[] selectDisciplines = req.getParameterValues("selectDisciplines");

        DBServices services = new DBServices();
        services.createTerm(duration,selectDisciplines);

        resp.sendRedirect("/termList");
    }
}
