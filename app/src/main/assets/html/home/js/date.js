var nowList;
var ClassList1 = new Array("outDate", "closeDate", "tips");

function clickMenu1(num) {
    var menu1Elem = document.getElementsByClassName("menu1Elem");
    menu1Elem[num].style.color = "#1296db";
    menu1Elem[num].style.borderBottom = "solid 1px #1296db";
    menu1Elem[num].style.fontWeight = "bold";
    for (var i = 0; i < 3; i++) {
        if (i != num) {
            menu1Elem[i].style.color = "black";
            menu1Elem[i].style.borderBottom = "none";
            menu1Elem[i].style.fontWeight = "normal";
        }
    }
    changeShow(num);

}


window.onload = function () {
    var t = getQueryVariable("id");
    if (t != false) {
        clickMenu1(t);
        return;
    }
    changeShow(0);
}


function changeShow(classVar) {
    for (var i = 0; i < ClassList1.length; i++) {
        var Elems = document.getElementsByClassName(ClassList1[i]);
        for (var j = 0; j < Elems.length; j++) {
            if (i != classVar) {
                Elems[j].style.display = "none";
            } else {
                Elems[j].style.display = "";
            }
        }
    }
}


function getQueryVariable(variable) {
    var query = window.location.search.substring(1);
    var vars = query.split("&");
    for (var i = 0; i < vars.length; i++) {
        var pair = vars[i].split("=");
        if (pair[0] == variable) {
            return pair[1];
        }
    }
    return (false);
}