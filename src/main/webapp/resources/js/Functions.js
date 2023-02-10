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