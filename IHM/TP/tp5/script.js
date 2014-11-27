$(document).ready(function(){
    dhms = 3600000;
    dmms = 60000;

    tdm = 60;
    dms = tdm * dmms;

    currentTime = Date.now();
    previousTime = Date.now();

    cd = $("#chrono");
    
    displaycd();
	tictac = setInterval(compteAreboure, 1000); // actualisation affichage toutes les secondes sans animation
});

function compteAreboure()
{
    currentTime = Date.now();
    var elapsedTime = currentTime - previousTime;
    
    dms -= elapsedTime;
    
    displaycd();
    
    previousTime = currentTime;
}

function displaycd() {
	var tmp = dms;
	var minutes=0, secondes=0, heures=0;
	if (tmp > dhms ){
		heures = Math.floor(tmp/dhms);
		tmp = tmp%dhms;
	}else{
		heures = 0;
	}
	if (tmp > dmms ){
		minutes = tmp/dmms>>0;
		tmp = tmp%dmms;
	}else{
		minutes = 0;
	}
	secondes = tmp/1000>>0;
	if (heures<10) {heures = "0" + heures}
	if (minutes<10) {minutes = "0" + minutes}
	if (secondes<10) {secondes = "0" + secondes}
	cd.html("<p>"+heures+" : "+minutes+" : "+secondes+"</p>");
}