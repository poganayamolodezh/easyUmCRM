
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name = "description" content="Описание страницы для поисковиков не более 160 символов">
  <meta name="keywords" content="Ключевые слова или фразы для поисковых систем, пишуться через запятую">

  <link rel="icon" type="image/png" href="..//resources/img/favicon.png">

  <meta property="og:title" content="EasyUm CRM">
  <meta property="og:description" content="Описание страницы слайда выпадающая в поисковых страницах не более 160 символов">
  <meta property="og:type" content="article">
  <meta property="og:image" content="https://it.easyum.ru/wp-content/uploads/2018/11/home_top_img.png">
  <meta property="og:site_name" content="EasyUm CRM">
  <title>CreateTerm</title>
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;700&display=swap" rel="stylesheet">

  <link rel="stylesheet" href="..//resources/css/css_page_10.css">
</head>
<body>
<header id="header" class="header">
  <div class="container">
    <!-- <img src="img/square_pattern 1.png" class="picture"></img>
    <img src="img/square_blur 1.png" class="pict"> -->
    <nav class = "nav">
      <!-- Вставляем лого -->
      <img src="..//resources/img/logo.png" alt="EasyUm IT курсы">


      <!-- Пункты меню -->
      <ul class="menu">
        <li>
          <a href="/index.jsp" class="menu__item menu__item__active reg1">На главную</a>
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
  </div>
</header>

    <h1>Система управления студентами и их успеваемостью
    </h1>

    <h2>Для создания семестра заполните следующие данные и нажмите кнопку «Создать»</h2>

  </div>

  <div class = "table23">
    <form action="/term-create" method="post">
    <p class = "text1">	Длительность (в неделях)</p>
<%--    <a href="#" class="btn">--%>
<%--      24--%>
<%--    </a>--%>
      <input type="number" class = "btn" placeholder="24" name="duration">

      <div class="b1 mt30">
        <p>
          Дисциплины в семестре:
        </p>
      </div>
      <div class="b2 mt30 textdis">
        <select name="selectDisciplines" class="select-discipline"  multiple required >
          <c:forEach items="${disciplines}" var = "d">
            <option value="${d.id}">${d.discipline}</option>
          </c:forEach>
        </select>
      </div>
  </div>

  <div class = "table235">

<%--    <a href="#" class="btn2">--%>
<%--      Создать--%>
<%--    </a>--%>
    <input type="submit" value="Создать" class="btn2">

  </div>
</form>


</body>
</html>