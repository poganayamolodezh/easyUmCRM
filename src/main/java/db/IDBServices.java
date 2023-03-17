package db;

import entity.*;

import java.sql.Date;
import java.util.List;

public interface IDBServices {
    //тип + имя метода + (параметры если есть);
    //=================================Дисциплины=========================

    //Метод по получению списка активных дисциплин
   List<Discipline> getAllActiveDisciplines();

    //Создать дисциплину
    void createDiscipline(String discipline);

    //Получить дисциплину по id
    Discipline getDisciplineById(String id);

    //Модифицировать дисциплину
   void modifyDiscipline (String id, String newDiscipline);

   //Удалить выбранную дисциплину
   void deleteDiscipline(String id);

   //Удалить несколько дисциплин


    //=================================Студенты=========================

    //Получить список студентов
    List<Student> getAllActiveStudents();

    //Создать студента
    void createStudent (String surname, String name, String group, String date);

    //Получить студента по id
    Student getStudentById(String id);

    //Модифицировать студента
    void modifyStudent (String id, String newSurname, String newName, String newGroup, String newDate);

    //Удалить студента
    void deleteStudent (String id);

    //Удалить несколько студентов

    // =======================Семестры===================

    //Получить список семестров
    List<Term> getAllActiveTerms();

    //Получить список дисициплин по выбранному семестру
    List<Discipline> getDisciplinesByTerm(String idTerm);

    //Создать семестр
    void createTerm (String duration, String [] idsDisciplines);

    //Получить семестр по id
    Term getTermById(String id);

    //Модифицировать семестр
    void modifyTerm(String id, String newDuration, String newIdsDisciplines);

    //Удалить семестр
    void deleteTerm(String id);


    //============== Прочие страницы ===================
    //Получить все оценки по студенту по семестру
    List<Mark> getMarks(String idStudent, String idTerm);

    //Получить все роли
    List<Role> getAllActiveRoles();

    //Проверка доступа
    boolean canLogin(String login, String password, String idRole);


}
