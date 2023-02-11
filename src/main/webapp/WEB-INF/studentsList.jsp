
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name = "description" content="Описание страницы для поисковиков не более 160 символов">
  <meta name="keywords" content="Ключевые слова или фразы для поисковых систем, пишуться через запятую">


  <!-- favicon 16x16 32x32 64x64 формат png -->
  <link rel="icon" type="image/png" href="../resources/img/favicon_easyUm.png">


  <!-- OG метки (Open Graf) миниатюра сайта для соц сетей и мессенджеров, пример: https://auto.ru/cars/used/sale/ram/1500/1117314846-ddc10bf3/?from=searchline -->
  <meta property="og:title" content="EasyUm CRM">
  <meta property="og:description" content="Описание страницы слайда выпадающая в поисковых страницах не более 160 символов">
  <meta property="og:type" content="article">
  <meta property="og:image" content="https://it.easyum.ru/wp-content/uploads/2018/11/home_top_img.png">
  <meta property="og:site_name" content="EasyUm CRM">

  <title>StudentList</title>

  <!-- подключение шрифтов -->
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;700&display=swap" rel="stylesheet">

  <!-- подключаем css -->
  <link rel="stylesheet" href="../resources/css/StudentsList.css">

</head>
<body>
<header id="header" class="header">
  <div class="container">
    <img src="../resources/img/square_pattern%201.png" class="picture"></img>
    <img src="../resources/img/square_blur%201.png" class="pict">
    <nav class = "nav">
      <!-- Вставляем лого -->
      <img src="../resources/img/logo.png" alt="EasyUm IT курсы">

      <!-- Пункты меню -->
      <ul class="menu">
        <li>
          <a href="/index.jsp" class="menu__item menu__item__active">На главную</a>
        </li>

        <li>
          <a href="#" class="menu__item menu__item__active">LogOut</a>
        </li>
      </ul>
    </nav>
    <h1>Система управления студентами и их успеваемостью
    </h1>
  </div>
  <!-- Делаем кнопки -->
  <div class="container buttons">
    <div>
      <a href="#" class="btn">
        Посмотреть успеваемость выбранных студентов
      </a>
<%--      <a href="#" class="btn">Модифицировать</a>--%>
      <input type="submit" value="Модифицировать" class= "btn" onclick="modifyStudent()">

    </div>
    <div>
      <a href="/student-create"  class="btn">Создать студента</a>
<%--      <a href="#" class="btn">Удалить студента</a>--%>
      <input type="submit" value="Удалить студента" class="btn" onclick="deleteStudents()">
    </div>

  </div>
</header>
<section id="section" class="section">
  <div class="container">
    <h2>Список студентов</h2>

    <!-- Таблица -->
    <table class = "table">
      <!-- Заголовочная строка -->
      <thead>
      <tr>
        <th class="td"></th>
        <th class="td">Фамилия</th>
        <th class="td">Имя</th>
        <th class="td">Группа</th>
        <th class="td">Дата поступления</th>
      </tr>
      </thead>

      <tbody>
      <c:forEach items="${allActiveStudents}" var="student">
      <tr>
        <td class="td-ch">
          <input type="checkbox" class = "check__item" value="${student.id}" name="idStudent">
        </td>
        <td class="td">${student.surname}</td>
        <td class="td">${student.name}</td>
        <td class="td">${student.group}</td>

        <td class="td"><f:formatDate value="${student.date}" pattern="dd/MM/yyyy"/> </td>
      </tr>
      </c:forEach>

      </tbody>

    </table>
  </div>
</section>
<footer id="footer" class="footer">
  <div class="container">

  </div>
</footer>

<%--Форма для удаления студентов--%>
<form action="/student-delete" method="post" id="formDelete">
  <input type="hidden" value="" name="hiddenDelete" id="hiddenDelete">
</form>
<%--Форма для модификации студента--%>
<form action="/student-modify" method="get" id="formModify">
  <input type="hidden" value="" name="hiddenModify" id="hiddenModify">
</form>
</body>
<%--Подключаем JS--%>
<script src="../resources/js/Functions.js"></script>
</html>


