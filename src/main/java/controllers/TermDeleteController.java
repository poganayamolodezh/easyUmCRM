package controllers;

import db.DBServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TermDeleteController", urlPatterns = "/term-delete")
public class TermDeleteController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBServices services = new DBServices();
        String idsToDelete = req.getParameter("hiddenDelete");

        //��������� id-�����
        String[] ids = idsToDelete.split(" ");

        //������� �� ������ ��������
        for(String id: ids){
            services.deleteStudent(id);
        }

        //����� ��������������� ������������ �� /studentList.jsp
        resp.sendRedirect("/termList");
    }
}
