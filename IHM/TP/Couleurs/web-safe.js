$(document).ready(function(){
	for(var r = 0; r < 256; r += 51)
	{
		for(var g = 0; g < 256; g += 51)
		{
			for(var b = 0; b < 256; b += 51)
			{
				$("#container").append("<div class='content' id=content"+r+g+b+"></div>");
				$("#content"+r+g+b).append("<div class='color' id=color"+r+g+b+"></div>");
				$("#color"+r+g+b).css("background", "rgb("+r+","+g+","+b+")");
				$("#content"+r+g+b).append("<span> rgb "+r+" "+g+" "+b+" </span>");
			}
		}
	}
});