package db;

import constants.Constants;
import entity.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBServices implements IDBServices{
    @Override
    public List<Discipline> getAllActiveDisciplines() {
        List<Discipline> disciplines = new ArrayList<>();
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");

            //������� ���� � ����� ��, ����� � ������
            //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/crm_easyum_33","root","Qwasqwas23");
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB, Constants.LOGIN_TO_DB, Constants.PASSWORD_TO_DB);
            //Statement
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM crm_easyum_33.discipline");

            //��������� List<Discipline> disciplines
            while (rs.next()) {
                //������� ������ ������
                Discipline discipline = new Discipline();

                //������� �������� ������� id �� SQL
                discipline.setId(rs.getInt("id"));

                //������� �������� ������� discipline �� SQL
                discipline.setDiscipline(rs.getString("discipline"));

                //��������� � ������ ����� while ������ discipline � ��������� disciplines
                disciplines.add(discipline);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return disciplines;
    }

    @Override
    public void createDiscipline(String discipline) {

    }

    @Override
    public Discipline getDisciplineById(String id) {
        return null;
    }

    @Override
    public void modifyDiscipline(String id, String newDiscipline) {

    }

    @Override
    public void deleteDiscipline(String id) {

    }

    @Override
    public List<Student> getAllActiveStudents() {
        List<Student> students = new ArrayList<>();
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");

            //������� ���� � ����� ��, ����� � ������
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB, Constants.LOGIN_TO_DB, Constants.PASSWORD_TO_DB);

            //Statement
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM crm_easyum_33.student where status = '1'");

            //��������� List<Discipline> disciplines
            while (rs.next()) {
                //������� ������ ������
                Student student = new Student();

                //������� �������� ������� id �� SQL
                student.setId(rs.getInt("id"));

                //������� �������� ������� surname �� SQL
                student.setSurname(rs.getString("surname"));

                //������� �������� ������� name �� SQL
                student.setName(rs.getString("name"));

                //������� �������� ������� group �� SQL
                student.setGroup(rs.getString("group"));

                //������� �������� ������� date �� SQL
                student.setDate(rs.getDate("date"));

                //��������� � ������ ����� while ������ discipline � ��������� disciplines
                students.add(student);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public void createStudent(String surname, String name, String group, String date) {
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");

            //������� ���� � ����� ��, ����� � ������
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB, Constants.LOGIN_TO_DB, Constants.PASSWORD_TO_DB);

            //Statement
            Statement stmt = conn.createStatement();
            stmt.execute("INSERT INTO `crm_easyum_33`.`student` (`surname`, `name`, `group`, `date`) VALUES ('"+surname+"', '"+name+"', '"+group+"', '"+date+"');\n");




        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Student getStudentById(String id) {
        return null;
    }

    @Override
    public void modifyStudent(String id, String newSurname, String newName, String newGroup, String newDate) {

    }

    @Override
    public void deleteStudent(String id) {
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");

            //������� ���� � ����� ��, ����� � ������
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB, Constants.LOGIN_TO_DB, Constants.PASSWORD_TO_DB);

            //Statement
            Statement stmt = conn.createStatement();

            stmt.execute("UPDATE `crm_easyum_33`.`student` SET `status` = '0' WHERE (`id` = '"+id+"');\n");




        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Term> getAllActiveTerms() {
        return null;
    }

    @Override
    public List<Discipline> getDisciplinesByTerm(String idTerm) {
        return null;
    }

    @Override
    public void createTerm(String duration, String idsDisciplines) {

    }

    @Override
    public Term getTermById(String id) {
        return null;
    }

    @Override
    public void modifyTerm(String id, String newDuration, String newIdsDisciplines) {

    }

    @Override
    public void deleteTerm(String id) {

    }

    @Override
    public List<Mark> getMarks(String idStudent, String idTerm) {
        return null;
    }

    @Override
    public List<Role> getAllActiveRoles() {
        return null;
    }

    @Override
    public boolean canLogin(String login, String password, String idRole) {
        return false;
    }
}
