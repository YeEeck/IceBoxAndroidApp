function clicked() {
    var text = document.getElementById("input1");
    var table = document.getElementById("table1");
    if (text.value == "") return;
    table.innerHTML = table.innerHTML + '<tr><td><div class="chatMessage" style="width: ' + (text.value.length / 2 + 2.3) + 'em;">' + text.value + '</div></td></tr>';
    text.value = "";
    window.scrollBy(0, 1000);
}