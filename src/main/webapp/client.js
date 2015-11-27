/**
 * 
 */

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
	    //document.getElementById("demo").innerHTML = xhttp.responseText;
		console.log("response " + xhttp.responseText);
	  }
	};
	xhttp.open("GET", "AjaxServlet?op=reload", true);
	xhttp.send();	
}

i = 0;
function poll_loop() {    
    poll();
    setTimeout(function() { i++; if (i < 10) { poll_loop(); } }, 3000);
};

poll_loop();