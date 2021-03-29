var timeView;
var onOff = new Array(0, 0, 0, 0);

window.onload = function () {

}

function batButtonClick(num) {
    var ButtonImg = document.getElementsByClassName("barImg");
    if (onOff[num] == 0) {
        ButtonImg[num].src = ButtonImg[num].src.replace("off", "on");
        onOff[num] = 1;
    } else{
        ButtonImg[num].src = ButtonImg[num].src.replace("on", "off");
        onOff[num] = 0;
    }
}