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

            //Указать путь к схеме БД, логин и пароль
            //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/crm_easyum_33","root","Qwasqwas23");
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB, Constants.LOGIN_TO_DB, Constants.PASSWORD_TO_DB);
            //Statement
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM crm_easyum_33.discipline");

            //Наполнить List<Discipline> disciplines
            while (rs.next()) {
                //Создать пустой объект
                Discipline discipline = new Discipline();

                //Достать значение колонки id из SQL
                discipline.setId(rs.getInt("id"));

                //Достать значение колонки discipline из SQL
                discipline.setDiscipline(rs.getString("discipline"));

                //Добавляем в каждом цикле while объект discipline в коллекцию disciplines
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

            //Указать путь к схеме БД, логин и пароль
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB, Constants.LOGIN_TO_DB, Constants.PASSWORD_TO_DB);

            //Statement
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM crm_easyum_33.student where status = '1'");

            //Наполнить List<Discipline> disciplines
            while (rs.next()) {
                //Создать пустой объект
                Student student = new Student();

                //Достать значение колонки id из SQL
                student.setId(rs.getInt("id"));

                //Достать значение колонки surname из SQL
                student.setSurname(rs.getString("surname"));

                //Достать значение колонки name из SQL
                student.setName(rs.getString("name"));

                //Достать значение колонки group из SQL
                student.setGroup(rs.getString("group"));

                //Достать значение колонки date из SQL
                student.setDate(rs.getDate("date"));

                //Добавляем в каждом цикле while объект discipline в коллекцию disciplines
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

            //Указать путь к схеме БД, логин и пароль
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
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Указать путь к схеме БД, логин и пароль
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB, Constants.LOGIN_TO_DB, Constants.PASSWORD_TO_DB);

            //Statement
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM crm_easyum_33.student where status = '1' and id ="+id+"");

            //Наполнить List<Discipline> disciplines
            while (rs.next()) {
                //Создать пустой объект
                Student student = new Student();

                //Достать значение колонки id из SQL
                student.setId(rs.getInt("id"));

                //Достать значение колонки surname из SQL
                student.setSurname(rs.getString("surname"));

                //Достать значение колонки name из SQL
                student.setName(rs.getString("name"));

                //Достать значение колонки group из SQL
                student.setGroup(rs.getString("group"));

                //Достать значение колонки date из SQL
                student.setDate(rs.getDate("date"));

                //Возвращаем студента
                return student;
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void modifyStudent(String id, String newSurname, String newName, String newGroup, String newDate) {
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Указать путь к схеме БД, логин и пароль
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB, Constants.LOGIN_TO_DB, Constants.PASSWORD_TO_DB);

            //Statement
            Statement stmt = conn.createStatement();
            stmt.execute("UPDATE `crm_easyum_33`.`student` SET `surname` = '"+newSurname+"', `name` = '"+newName+"', `group` = '"+newGroup+"', `date` = '"+newDate+"' WHERE (`id` = '"+id+"');");




        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void deleteStudent(String id) {
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Указать путь к схеме БД, логин и пароль
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
        List<Term> terms = new ArrayList<>();
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Указать путь к схеме БД, логин и пароль
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB, Constants.LOGIN_TO_DB, Constants.PASSWORD_TO_DB);

            //Statement
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM crm_easyum_33.term where status = '1'");

            //Наполнить List<Discipline> disciplines
            while (rs.next()) {
                //Создать пустой объект
                Term term = new Term();

                //Достать значение колонки id из SQL
                term.setId(rs.getInt("id"));

                //Достать значение колонки term из SQL
                term.setTerm(rs.getString("term"));

                //Достать значение колонки duration из SQL
                term.setDuration(rs.getString("duration"));
                terms.add(term);


            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return terms;
    }

    @Override
    public List<Discipline> getDisciplinesByTerm(String idTerm) {
        List<Discipline> disciplines = new ArrayList<>();
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Указать путь к схеме БД, логин и пароль
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB, Constants.LOGIN_TO_DB, Constants.PASSWORD_TO_DB);

            //Statement
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM crm_easyum_33.term_discipline as td\n" +
                    "left join discipline as d on td.id_discipline = d.id\n" +
                    "where d.status = '1' and td.id_term = "+idTerm+"");

            //Наполнить List<Discipline> disciplines
            while (rs.next()) {
                //Создать пустой объект
                Discipline discipline = new Discipline();
                //Достать значение колонки id из SQL
                discipline.setId(rs.getInt("id_discipline"));
                //Достать значение колонки discipline из SQL
                discipline.setDiscipline(rs.getString("discipline"));
                disciplines.add(discipline);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return disciplines;
    }

    @Override
    public void createTerm(String duration, String idsDisciplines) {

    }

    @Override
    public Term getTermById(String id) {

        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Указать путь к схеме БД, логин и пароль
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB, Constants.LOGIN_TO_DB, Constants.PASSWORD_TO_DB);

            //Statement
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM crm_easyum_33.term where status = '1' and id = "+id+"");

            //Наполнить List<Discipline> disciplines
            while (rs.next()) {
                //Создать пустой объект
                Term term = new Term();

                //Достать значение колонки id из SQL
                term.setId(rs.getInt("id"));

                //Достать значение колонки term из SQL
                term.setTerm(rs.getString("term"));

                //Достать значение колонки duration из SQL
                term.setDuration(rs.getString("duration"));
                return term;


            }


        } catch (Exception e) {
            e.printStackTrace();
        }
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
        List<Role> roles = new ArrayList<>();
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Указать путь к схеме БД, логин и пароль
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB, Constants.LOGIN_TO_DB, Constants.PASSWORD_TO_DB);

            //Statement
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM crm_easyum_33.role;");

            //Наполнить List<Discipline> disciplines
            while (rs.next()) {
                //Создать пустой объект
                Role role = new Role();

                //Достать значение колонки id из SQL
                role.setId(rs.getInt("id"));

                //Достать значение колонки surname из SQL
                role.setRole(rs.getString("role"));


                //Добавляем в каждом цикле while объект discipline в коллекцию disciplines
                roles.add(role);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return roles;
    }


    @Override
    public boolean canLogin(String login, String password, String idRole) {
        //1 Проверка: логин и пароль в user есть
        //2 Проверка: есть ли у логина такая роль
        //Две проверки одним запросом
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Указать путь к схеме БД, логин и пароль
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB, Constants.LOGIN_TO_DB, Constants.PASSWORD_TO_DB);

            //Statement
            Statement stmt = conn.createStatement();

          ResultSet rs =  stmt.executeQuery("SELECT * FROM crm_easyum_33.role_user as ur\n" +
                  "left join user as u on ur.id_user = u.id\n" +
                  "where u.login = '"+login+"' and u.password = '"+password+"' and ur.id_role ="+idRole+"");

            while (rs.next()){
                return true;
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


        return false;
    }
}
