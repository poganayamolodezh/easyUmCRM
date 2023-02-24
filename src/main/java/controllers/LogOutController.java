package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="LogOutController", urlPatterns = "/logout")
public class LogOutController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Нужно уничтожить сессию
        req.getSession().invalidate();

        //Перенаправляем на логирование
        resp.sendRedirect("/login");
    }
}
