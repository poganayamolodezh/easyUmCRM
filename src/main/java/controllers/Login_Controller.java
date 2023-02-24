package controllers;

import db.DBServices;
import entity.Role;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Login_Controller", urlPatterns = "/login")
public class Login_Controller extends HttpServlet {
    @Override

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DBServices dbServices = new DBServices();
        List<Role> role = dbServices.getAllActiveRoles();
        req.setAttribute("getAllActiveRoles",role);
        req.getRequestDispatcher("WEB-INF/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String role = req.getParameter("role");
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        //Проверка на пустой логин и пароль
        if (login == null || login.equals("")|| password == null || password.equals("")){
            req.setAttribute("Error", 2);
            DBServices dbServices = new DBServices();
            List<Role> roles = dbServices.getAllActiveRoles();
            req.setAttribute("getAllActiveRoles",roles);
            req.getRequestDispatcher("WEB-INF/login.jsp").forward(req,resp);
            return;
        }

        DBServices services = new DBServices();

        if(services.canLogin(login,password,role)){
            //Если логин найден
            req.getSession().setAttribute("isLogin", true);
            req.getSession().setAttribute("role", role);
            req.getSession().setAttribute("login", login);

            resp.sendRedirect("/");

        }
        else {
            //Если логин не найден
            req.setAttribute("Error", 1);
            List<Role> roles = services.getAllActiveRoles();
            req.setAttribute("getAllActiveRoles",roles);
            req.getRequestDispatcher("WEB-INF/login.jsp").forward(req,resp);

        }

    }

}