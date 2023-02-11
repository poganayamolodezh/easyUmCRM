function deleteStudents() {
    //Получить массив input со всеми атрибутами, которые у нас выбраны галочкой cheked
    var checkedCheckBoxes = document.querySelectorAll("input[name=idStudent]:checked");

    //Проверка на наличие выбранных студентов
    if(checkedCheckBoxes.length == 0){
        alert("Select students");
        return;
    }

    //Формируем переменную String в которой перечисляем id через пробел: 5 6 7 8
    var ids = "";
    for(var i=0; i<checkedCheckBoxes.length; i++){
        ids = ids + checkedCheckBoxes[i].value + " "
    }

    //Заполним value="" у input formDelete
    document.getElementById("hiddenDelete").value = ids;
    //Нажать кнопку
    document.getElementById("formDelete").submit();

}

function modifyStudent(){
    //Получить массив input со всеми атрибутами, которые у нас выбраны галочкой cheked
    var checkedCheckBoxes = document.querySelectorAll("input[name=idStudent]:checked");

    //Проверка на наличие выбранных студентов
    if(checkedCheckBoxes.length == 0){
        alert("Select one student");
        return;
    }
    //Проверка что выбрано не более одного флажка
    if(checkedCheckBoxes.length > 1){
        alert("Select only one student");
        return;
    }

    //Заполним value="" у input formModify
    document.getElementById("hiddenModify").value = checkedCheckBoxes[0].value;
    //Нажать кнопку
    document.getElementById("formModify").submit();
}