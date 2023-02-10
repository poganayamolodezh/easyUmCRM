package controllers;

import db.DBServices;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="StudentsListController", urlPatterns = "/studentsList")

public class StudentsListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        DBServices dbServices = new DBServices();

        //������� ����� getAllActiveStudents(), ����� ������� ���� �������� ��������� �� sql
        List<Student> students = dbServices.getAllActiveStudents();

        //��������� ����������� ������� �� sql request (������)
        req.setAttribute("allActiveStudents", students);

        //        resp.getWriter().println("Hello world!");
        req.getRequestDispatcher("WEB-INF/studentsList.jsp").forward(req, resp);
    }
}
