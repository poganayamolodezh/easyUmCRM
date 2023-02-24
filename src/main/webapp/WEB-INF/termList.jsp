
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

    <link rel="icon" type="image/png" href="../resources/img/favicon.png">

    <meta property="og:title" content="EasyUm CRM">
    <meta property="og:description" content="Описание страницы слайда выпадающая в поисковых страницах не более 160 символов">
    <meta property="og:type" content="article">
    <meta property="og:image" content="https://it.easyum.ru/wp-content/uploads/2018/11/home_top_img.png">
    <meta property="og:site_name" content="EasyUm CRM">
    <title>Page_09</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;700&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="../resources/css/main_css_09.css">
</head>

<body>
<header id="header" class="header">
    <div class="container">
        <!-- <img src="#" class="picture"></img>
        <img src="#" class="pict"></img> -->
        <nav class = "nav">
            <!-- Вставляем лого -->
            <img src="../resources/img/logo.png" alt="EasyUm IT курсы">


            <!-- Пункты меню -->
            <ul class="menu">
                <li>
                    <a href="/" class="menu__item menu__item__active reg1">На главную</a>
                </li>

                <li>
                    <c:choose>
                        <c:when test="${isLogin eq true}">
                            <a href="/logout" class="menu__item menu__item__active reg3">LogOut</a>
                        </c:when>
                        <c:otherwise>
                            <a href="/login" class="menu__item menu__item__active reg3">LogIn</a>
                        </c:otherwise>
                    </c:choose>
                </li>
            </ul>
        </nav>
        <h1>Система управления студентами и их успеваемостью
        </h1>

        <form action="/termList" method="get">
        <div style="float:left;" class="content">
            <p class="text">	Выбрать семестр:</p>
            <p class="spisok">
                <select name="idSelectedTerm" id="selectID">
                    <c:forEach items="${terms}" var = "t">
                        <c:choose>
                            <c:when test="${t.id eq selectedTerm.id}">
                                <option selected value="${t.id}">${t.term}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${t.id}">${t.term}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    </select>
            </p>
            <p class = "knp">
<%--                <a href="#" class="btn2">--%>
<%--                    выбрать--%>
<%--                </a>--%>
                <input type="submit" value="Выбрать" class="btn2">
            </p>
            <p class = "text0">Длительность семестра: ${selectedTerm.duration}</p>

            <h2>Список дисциплин семестра</h2>
        </div>
    </form>




        <div style="float:left;"></div>
        <table class = "table">
            <!-- Заголовочная строка -->
            <thead>

            <tr>
                <th class="td">Наименование дисциплины</th>

            </tr>
            </thead>
            <tbody>

            <c:forEach items="${disciplines}" var="d">
            <tr>
                <td class="td">${d.discipline}</td>
            </tr>
            </c:forEach>


            </tbody>

    <div style="float:right;">
        <div class="container buttons">
            <a href="#" class="btn">
                создать семестр...
            </a>
            <a href="#" class="btn">Модифицировать текущий семестр...</a>
            <a href="#" class="btn">удалить  текущий семестр</a>
        </div>
    </div>

</body>
</html>
