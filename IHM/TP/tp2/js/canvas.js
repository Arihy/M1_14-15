$(document).ready(function(){
    var canvas = document.getElementById('myCanvas');
    if(canvas.getContext)
	{
        var ctx = canvas.getContext('2d');
        ctx.clearRect(0, 0, canvas.width, canvas.height);
        drawRectangle(ctx, 20, 10, 300, 50, "gray");

        drawTriangle(ctx, 0, 0, 100, 0, 100, 100, "black");
        drawTriangle(ctx, 15, 5, 90, 5, 90, 80, "gray");
        
        var gradient = ctx.createLinearGradient(150, 0, 150, 60);
        gradient.addColorStop(0,"black");
        gradient.addColorStop(1,"#e3e3e3");
        drawTriangle(ctx, 150, 0, 100, 70, 200, 70, gradient);
        
        gradient = ctx.createLinearGradient(250, 0, 100, 100);
        gradient.addColorStop(0,"#362e2e");
        gradient.addColorStop(0.5,"#e8e8e8");
        gradient.addColorStop(1,"#3b3b3b");
        drawTriangle(ctx, 150, 20, 120, 60, 180, 60, gradient);

        gradient = ctx.createLinearGradient(0, 0, canvas.width, 0);
        gradient.addColorStop(0,"#9d0a1b");
        gradient.addColorStop(0.5,"#00f");
        gradient.addColorStop(1.0,"#9d0a1b");
        drawText(ctx, "Hello Cannelle", 100, 100, gradient);
        
        var img = new Image();
        img.src = "img/canvas.jpg";
        img.onload= function(){
            drawImage(ctx, img, 130, 120, 200, 200);
        }
        
        drawLine(ctx, 20, 100, 20, 370, "#d4d4d4");
        drawLine(ctx, 20, 370, 150, 370, "#d4d4d4");
    }
});

function drawRectangle(ctx, x, y, w, h, color)
{
    console.log('begin rect');
    ctx.fillStyle = color;
    ctx.fillRect(x, y, w, h);
    ctx.fill();
    console.log('end rect');
}

function drawTriangle(ctx, x1, y1, x2, y2, x3, y3, color)
{
	console.log('begin triangle');
    ctx.beginPath();
    ctx.fillStyle = color;
    ctx.moveTo(x1, y1);
    ctx.lineTo(x2, y2);
    ctx.lineTo(x3, y3);
    ctx.fill();
    console.log('end triangle');
}

function drawLine(ctx, x1, y1, x2, y2, color)
{
    ctx.strokeStyle = color;
    ctx.lineWidth = 2;
    ctx.beginPath();
    ctx.moveTo(x1, y1);
    ctx.lineTo(x2, y2);
    ctx.stroke();
}

function drawText(ctx, text, x, y, color)
{
    ctx.font="30px Verdana";
    ctx.fillStyle = color;
    ctx.fillText(text, x, y);
    ctx.fill();
}

function drawImage(ctx, img, x, y, w, h)
{
    ctx.drawImage(img, x, y, w, h);
}