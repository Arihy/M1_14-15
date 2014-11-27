$(document).ready(function(){
    var canvas = document.getElementById('myCanvas');
    if(canvas.getContext)
	{
        var ctx = canvas.getContext('2d');
        ctx.clearRect(0, 0, canvas.width, canvas.height);
        
    }
});