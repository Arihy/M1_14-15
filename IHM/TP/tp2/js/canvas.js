$(document).ready(function(){
	drawRectangle(20, 10, 300, 50, "gray");

	drawTriangle(0, 0, 100, 0, 100, 100, "black");
	drawTriangle(15, 5, 90, 5, 90, 80, "gray");
});

function drawRectangle(x, y, w, h, color)
{
	var canvas = document.getElementById('myCanvas');
	if(canvas.getContext)
	{
		console.log('begin rect');
		var ctx = canvas.getContext('2d');
		ctx.fillStyle = color;
		ctx.fillRect(x, y, w, h);
		ctx.fill();
		console.log('end rect');
	}
}

function drawTriangle(x1, y1, x2, y2, x3, y3, color)
{
	var canvas = document.getElementById('myCanvas');
	if(canvas.getContext)
	{
		console.log('begin triangle');
		var ctx = canvas.getContext('2d');
		ctx.beginPath();
		ctx.fillStyle = color;
		ctx.moveTo(x1, y1);
		ctx.lineTo(x2, y2);
		ctx.lineTo(x3, y3);
		ctx.fill();
		console.log('end triangle');
	}
}

function drawLine()
{
}

function drawText(text)
{
}

function drawImage()
{
}