
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

    <link rel="icon" type="image/png" href="resources/img/favicon_easyUm.png">

    <meta property="og:title" content="EasyUm CRM">
    <meta property="og:description" content="Описание страницы слайда выпадающая в поисковых страницах не более 160 символов">
    <meta property="og:type" content="article">
    <meta property="og:image" content="https://it.easyum.ru/wp-content/uploads/2018/11/home_top_img.png">
    <meta property="og:site_name" content="EasyUm CRM">
    <title>Page_05</title>
    <!-- подключение шрифтов -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;700&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="resources/css/css_page5.css">
</head>
<body>
<header  id="header" class="header">
    <div class="container">

        <nav class = "nav">
            <!-- Вставляем лого -->
            <img src="resources/img/logo.png" alt="EasyUm IT курсы">


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
            <div class="sqr"></div>
        </nav>
        <h1>Система управления студентами и их успеваемостью
        </h1>

    </div>
    <div class="container"><ul class="text">
        <li>
            <a href="/studentsList" class="text menu__item__active2">Студенты</a>
        </li>

        <li>
            <a href="#" class="text menu__item__active2">Дисциплины</a>
        </li>

        <li>
            <a href="/termList" class="text menu__item__active2">Семестры</a>
        </li>
    </ul></div>
</header>
</body>
</html>
