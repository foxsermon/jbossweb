<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Welcome to OpenShift</title>

<link rel="stylesheet" type="text/css" href="css/main.css">
<!-- CSS goes in the document HEAD or added to your external stylesheet -->
<style type="text/css">
</style>
<script>
var ambiente = '${ambiente}';
</script>
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="js/zingchart/zingchart.min.js"></script>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript" src="js/llamadas.js"></script>
</head>
<body>
  <div id="header" class="fixed" style="display: block; top: 0px; ">
    <div class="inner">
      123
    </div>
    <div id="dbActive" class="dbActive">    
    </div>
    <div class="shadow" style="display:block;"><span></span></div>
  </div>
  <nav>
    <div class="fakeshadow"></div>
  </nav>  
  <div class="container">
    <div class="row">
      <section class='col-xs-12 col-sm-6 col-md-6'>
        <section>
          <table class="lista">
            <tr>
              <td>
                <h2>&nbsp;</h2>
                <p><a href="infoExtra.html">Info Extra</a></p>          
              </td>
              <td>
                <h2>&nbsp;</h2>
                <p><a href="docs/indexApiDoc.jsp">Restful API's</a></p>          
              </td>
              <td>
                <h2>&nbsp;</h2>
                <p><a href="app/lanzaError">Lanza Error - Takipi</a></p>          
              </td>
              <td>
                <h2>&nbsp;</h2>
                <p><a href="jsp/parseMensaje.jsp">Parse Mensaje</a></p>          
              </td>
            </tr>
          </table>
        </section>
      </section>
    </div>
    <div id="ping">Info</div>
    <div id="datos">Datos</div>
    <table>
        <tr><td><div id='todos2Div'></div></td><td width="30px;"></td>
        <td><div id="piechart_3d" style="width: 450px; height: 215px;"></div></td></tr>
    </table>    
    
    
  </div>
</body>
</html>
