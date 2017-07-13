<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Welcome to OpenShift</title>

<link rel="stylesheet" type="text/css" href="../css/main.css">
<!-- CSS goes in the document HEAD or added to your external stylesheet -->
<style type="text/css">
</style>

<link rel="stylesheet" href="../css/jquery.toast.css">
<link href="../css/jBox.css" rel="stylesheet">

<script type="text/javascript" src="../js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="../js/md5.js"></script>
<script type="text/javascript" src="../js/jquery.toast.js"></script>
<script src="../js/jBox.js"></script>

<script>
$(function() {
	$("#envia").click(function() {
	  var llave = $("#key").val();
	  var msj =$("#msj").val();
	  if (llave.trim().length == 0 || msj.trim().length == 0) {
		  alert("Cosas vacias");
		  return;
	  }
      $.ajax({
  	     url: "../app/mensaje/" + llave + msj,
  	     method: "POST",
    	})
    	.done(function(data) {
    		showGrowl(data.message, "Parse.com", data.code);
    	})
    	.fail(function() {
    		showGrowl("Algo salio mal", "Parse.com", data.code);
  	  });
	});
	
	function showGrowl(sText, sHeading, sType) {
		sIcon = "info";
		sBgColor = "#424242";
		if (sType != 0) {
			sIcon = "error";
			sBgColor = "#B40431";
		}
		
	    $.toast({
		    text: sText,
		    heading: sHeading, 
		    icon: sIcon, 
		    showHideTransition: 'plain', 
		    allowToastClose: true, 
		    hideAfter: 5000, 
		    stack: 5, 
		    position: 'bottom-right',
		    bgColor: sBgColor,
		    textColor: '#FFFFFF',
		    
		    textAlign: 'left',  
	    });
		/*
	    new jBox("SAS", {
    	    content: "ASDADS",
    	    animation: "tada",
    	    audio: "../js/audio/bling3",
    	    volume: 100,
    	    attributes: {y: 'bottom'},
    	    color: 'green'
    	});
		*/
	}
	/*
	$("#mgrowl").click(function() {
    	new jBox('Notice', {
    	    content: 'Hurray! A notice!',
    	    animation: "tada",
    	    audio: "../js/audio/bling3",
    	    volume: 100,
    	    attributes: {y: 'bottom'},
    	    color: 'green',
    	    theme: 'NoticeBorder'
    	});
	});
	*/
});	
</script>
</head>
<body>
  <div id="header" class="fixed" style="display: block; top: 0px; ">
    <div class="inner">
      123
    </div>
    <div id="dbActive" class="dbActive">    
      <a href="../index.html">Index Page</a>
    </div>
    
    <div id="dbActive" class="dbActive">    
    </div>
    <div class="shadow" style="display:block;"><span></span></div>
  </div>
  <nav>
    <div class="fakeshadow"></div>
  </nav>  
  <div class="container"><br/><br/><br/>
      <section class='col-xs-12 col-sm-6 col-md-6'>
        <section>
          <table class="lista">
            <tr>
              <td>
                <input type="text" id="key" name="key" value=""/>          
              </td>
            </tr>
            <tr>
              <td>
                <textarea rows="10" cols="30" id="msj" name="msj"></textarea>          
              </td>
            </tr>
            <tr>
              <td>
                <input type="button" id="envia" name="envia" value="Envia"/>
                <!--<input type="button" id="mgrowl" name="mgrowl" value="Growl"/>-->
              </td>
            </tr>
          </table>
        </section>
      </section>

  </div>
</body>
</html>
