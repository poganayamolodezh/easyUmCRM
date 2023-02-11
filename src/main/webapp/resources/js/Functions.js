function deleteStudents() {
    //�������� ������ input �� ����� ����������, ������� � ��� ������� �������� cheked
    var checkedCheckBoxes = document.querySelectorAll("input[name=idStudent]:checked");

    //�������� �� ������� ��������� ���������
    if(checkedCheckBoxes.length == 0){
        alert("Select students");
        return;
    }

    //��������� ���������� String � ������� ����������� id ����� ������: 5 6 7 8
    var ids = "";
    for(var i=0; i<checkedCheckBoxes.length; i++){
        ids = ids + checkedCheckBoxes[i].value + " "
    }

    //�������� value="" � input formDelete
    document.getElementById("hiddenDelete").value = ids;
    //������ ������
    document.getElementById("formDelete").submit();

}

function modifyStudent(){
    //�������� ������ input �� ����� ����������, ������� � ��� ������� �������� cheked
    var checkedCheckBoxes = document.querySelectorAll("input[name=idStudent]:checked");

    //�������� �� ������� ��������� ���������
    if(checkedCheckBoxes.length == 0){
        alert("Select one student");
        return;
    }
    //�������� ��� ������� �� ����� ������ ������
    if(checkedCheckBoxes.length > 1){
        alert("Select only one student");
        return;
    }

    //�������� value="" � input formModify
    document.getElementById("hiddenModify").value = checkedCheckBoxes[0].value;
    //������ ������
    document.getElementById("formModify").submit();
}