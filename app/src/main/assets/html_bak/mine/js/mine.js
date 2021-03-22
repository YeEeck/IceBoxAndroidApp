var timeView;

window.onload = function() {
	timeView = document.getElementById("time");
	console.log(timeView.innerText)
	updateTime();
	setInterval(updateTime,1000);
}

function updateTime() {
	var d = new Date(),
		str = "";
	str += d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();
	timeView.innerText = str;
}
