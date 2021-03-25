var tg;
var dg;
var zg;
var kal;
var tgv;
var dgv;
var zgv;
var kalv;

function inputChange(bool1) {
    var input = document.getElementById("page");
    if (bool1 == 1) {
        input.value = parseInt(input.value) + 1;
    } else {
        if (input.value > 1) {
            input.value = input.value - 1;
        }
    }
    tg.innerText = (input.value * tgv).toFixed(2);
    dg.innerText = (input.value * dgv).toFixed(2);
    zg.innerText = (input.value * zgv).toFixed(2);
    kal.innerText = (input.value * kalv).toFixed(1);
}

function changed(){
    var input = document.getElementById("page");
    tg.innerText = (input.value * tgv).toFixed(2);
    dg.innerText = (input.value * dgv).toFixed(2);
    zg.innerText = (input.value * zgv).toFixed(2);
    kal.innerText = (input.value * kalv).toFixed(1);
}

window.onload = function () {
    tg = document.getElementById("tg");
    dg = document.getElementById("dg");
    zg = document.getElementById("zg");
    kal = document.getElementById("kal");
    tgv = tg.innerText;
    dgv = dg.innerText;
    zgv = zg.innerText;
    kalv = kal.innerText;
}