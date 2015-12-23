
function poll(){
    var xhttp;
    if (window.XMLHttpRequest) {
        xhttp = new XMLHttpRequest();
    } else {
        // code for IE6, IE5
        xhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }   
    xhttp.onreadystatechange = function() {
	  if (xhttp.readyState == 4 && xhttp.status == 200) {
	    document.getElementById("text").innerHTML = xhttp.responseText;
	    payload = xhttp.responseText;
		console.log(payload);
		newColor = payload.substr(payload.length-7);
		document.getElementById("demo").style.backgroundColor = newColor;
		setTimeout(poll, 3000);
	  }
	};
	xhttp.open("GET", "AjaxServlet?op=reload", true);
	xhttp.send();	
}
setTimeout(poll, 5000);