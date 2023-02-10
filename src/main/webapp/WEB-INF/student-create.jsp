
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name = "description" content="Описание страницы для поисковиков не более 160 символов">
<meta name="keywords" content="Ключевые слова или фразы для поисковых систем, пишуться через запятую">

<link rel="icon" type="image/png" href="../resources/img/favicon_easyUm.png">

<meta property="og:title" content="EasyUm CRM">
<meta property="og:description" content="Описание страницы слайда выпадающая в поисковых страницах не более 160 символов">
<meta property="og:type" content="article">
<meta property="og:image" content="https://it.easyum.ru/wp-content/uploads/2018/11/home_top_img.png">
<meta property="og:site_name" content="EasyUm CRM">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>page_3</title>
    <!-- подключение шрифтов -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="../resources/css/css_createStudent.css">

<%--    Подключаем JS   --%>
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
                    <a href="/" class="menu__item menu__item__active reg1">На главную</a>
                </li>

                <li>
                    <a href="#" class="menu__item menu__item__active reg2">Назад</a>
                </li>

                <li>
                    <a href="#" class="menu__item menu__item__active reg3">LogOut</a>
                </li>
            </ul>
        </nav>
        <h1>Система управления студентами и их успеваемостью
        </h1>

        <h2>Для создания студента, введите новые значения и нажмите кнопку "Создать"</h2>
    </div>


    <div>
        <form action="student-create" method="post" accept-charset="US-ASCII">
            <div class="container buttons">
            <input type="text" class="btn" placeholder="Фамилия" name = "surname">
            <input type="text"  class="btn" placeholder="Имя" name = "name">
            </div>
        <div class="container button3">
            <input type="text" class="btn" placeholder="Группа" name = "group">
            <input type="text" class="btn" placeholder="Дата поступления" name = "date" id="datepicker">
            <%--Из-за формата дат часто возникают ошибки записи в БД для корректной работы необходимо
            Подключить js и использовать библиотеки Jquery--%>

        </div>

        <div class="container buttons2">
            <input type="submit" value="Создать" class="btn w300"/>
        </div>
        </form>
    </div>




</header>

</body>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script>
    $( function() {
        $( "#datepicker" ).datepicker({
            showOtherMonths: true,
            selectOtherMonths: true
        });
    } );
</script>
</html>
