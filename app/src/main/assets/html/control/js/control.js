var nowList;
var ClassList1 = new Array("vegatable", "fruit", "drink", "meat", "df", "snack", "other");
var ClassList2 = new Array("bxDown", "bxMid", "bxUp", "doorIn", "freeze1", "freeze2");

function clickMenu1(num) {
    var menu1List = new Array("保鲜底层", "保鲜中层", "保鲜上层", "保鲜门内侧", "冷冻室1", "冷冻室2");
    var menu2List = new Array("蔬菜", "水果", "酒水", "肉类", "淀粉类", "零食", "其他");
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
    var menu2Elemtd = document.getElementsByClassName("menutd");
    if (num == 2) {
        document.getElementById("menu2Out").style.display = "none";
        nowList = 2;
    } else {
        document.getElementById("menu2Out").style.display = "";
    }
    if (num == 1) {
        nowList = ClassList2;
        var menu2Elem = document.getElementsByClassName("menu2Elem");
        for (var i = 0; i < menu2Elem.length; i++) {
            menu2Elem[i].innerText = menu1List[i];
        }
        menu2Elemtd[menu2Elemtd.length - 1].style.display = "none";
        clickMenu2(0);
    }
    if (num == 0) {
        nowList = ClassList1;
        var menu2Elem = document.getElementsByClassName("menu2Elem");

        for (var i = 0; i < menu2Elem.length; i++) {
            menu2Elem[i].innerText = menu2List[i];
        }
        menu2Elemtd[menu2Elemtd.length - 1].style.display = "";
        clickMenu2(0);
    }

}

function clickMenu2(num) {
    var menu2Elem = document.getElementsByClassName("menu2Elem");
    menu2Elem[num].style.color = "#1296db";
    menu2Elem[num].style.borderBottom = "solid 1px #1296db";
    menu2Elem[num].style.fontWeight = "bold";
    for (var i = 0; i < menu2Elem.length; i++) {
        if (i != num) {
            menu2Elem[i].style.color = "black";
            menu2Elem[i].style.borderBottom = "none";
            menu2Elem[i].style.fontWeight = "normal";
        }
    }
    changeShow(num);
}

window.onload = function () {
    var obj = document.getElementsByClassName("menu2")[0];
    var menu2Elemtd = document.getElementsByClassName("menutd");
    var tdLength = obj.clientWidth / 4;
    obj.style.width = tdLength * menu2Elemtd.length + "px";
    for (var i = 0; i < menu2Elemtd.length; i++) {
        menu2Elemtd[i].style.width = (tdLength / menu2Elemtd.length) + "px";
    }
    nowList = ClassList1;
    changeShow(0);
}


function changeShow(classVar) {
    if (nowList == ClassList1) {
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
    if (nowList == ClassList2) {
        for (var i = 0; i < ClassList2.length; i++) {
            var Elems = document.getElementsByClassName(ClassList2[i]);
            for (var j = 0; j < Elems.length; j++) {
                if (i != classVar) {
                    Elems[j].style.display = "none";
                } else {
                    Elems[j].style.display = "";
                }
            }
        }
    }

}