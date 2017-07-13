<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <title>Swagger - Restful Services</title>
    <link rel="stylesheet" type="text/css" href="../css/main.css">
    <link href='css/fonts.css' rel='stylesheet' type='text/css'/>
    <link href='css/hightlight.default.css' media='screen' rel='stylesheet' type='text/css'/>
    <link href='css/screen.css' media='screen' rel='stylesheet' type='text/css'/>
    <!-- <script src='../js/project.properties.js' type='text/javascript'></script> -->
    <script src='lib/jquery-1.8.0.min.js' type='text/javascript'></script>
    <script src='lib/jquery.slideto.min.js' type='text/javascript'></script>
    <script src='lib/jquery.wiggle.min.js' type='text/javascript'></script>
    <script src='lib/jquery.ba-bbq.min.js' type='text/javascript'></script>
    <script src='lib/handlebars-1.0.rc.1.js' type='text/javascript'></script>
    <script src='lib/underscore-min.js' type='text/javascript'></script>
    <script src='lib/backbone-min.js' type='text/javascript'></script>
    <script src='lib/swagger.js' type='text/javascript'></script>
    <script src='swagger-ui.js' type='text/javascript'></script>
    <script src='lib/highlight.7.3.pack.js' type='text/javascript'></script>	
    <style type="text/css">
        .swagger-ui-wrap {
            max-width: 960px;
            margin-left: auto;
            margin-right: auto;
        }

        .icon-btn {
            cursor: pointer;
        }

        #message-bar {
            min-height: 30px;
            text-align: center;
            padding-top: 10px;
        }

        .message-success {
            color: #89BF04;
        }

        .message-fail {
            color: #cc0000;
        }
    </style>

    <script type="text/javascript">
        $(function () {
            window.swaggerUi = new SwaggerUi({
                discoveryUrl:"<%=basePath%>app/api-docs.json",
                apiKey:"special-key",
                dom_id:"swagger-ui-container",
                supportHeaderParams: false,
                supportedSubmitMethods: ['get', 'post', 'put'],
                onComplete: function(swaggerApi, swaggerUi){
                	if(console) {
                        console.log("Loaded SwaggerUI")
                        console.log(swaggerApi);
                        console.log(swaggerUi);
                    }
                  $('pre code').each(function(i, e) {hljs.highlightBlock(e)});
                  
				  $(".operation-params tr").each(function() {
				     $(this).find("td:eq(1)").remove();
				  });
				  $("#menuOptions").find("label").each(function() {
				  	var objLookAt = $(this).html();
				  	var ul = $("#" + objLookAt + "_endpoint_list");
					var li = ul.children(".endpoint");
					var liGArr = new Array(); var iGCount = 0;
					var liPArr = new Array(); var iPCount = 0;
					var liDArr = new Array(); var iDCount = 0;
					var liUArr = new Array(); var iUCount = 0;
					li.detach().each(function() {
				  		var _htmlTmp = $(this).html();
				  		if (_htmlTmp.indexOf("get operation") > -1) {
				  			liGArr[iGCount++] = $(this);
				  		}else if (_htmlTmp.indexOf("post operation") > -1) {
				  			liPArr[iPCount++] = $(this);
				  		}else if (_htmlTmp.indexOf("delete operation") > -1) {
				  			liDArr[iDCount++] = $(this);
				  		}else if (_htmlTmp.indexOf("put operation") > -1) {
				  			liUArr[iUCount++] = $(this);
				  		}
					});
					for (var i=0; i<liGArr.length; i++) {
						ul.append(liGArr[i]);
					}
					for (var i=0; i<liPArr.length; i++) {
						ul.append(liPArr[i]);
					}
					for (var i=0; i<liDArr.length; i++) {
						ul.append(liDArr[i]);
					}
					for (var i=0; i<liUArr.length; i++) {
						ul.append(liUArr[i]);
					}					
				  });
				  $("#menuOptions").find("a").each(function() {
				  	$(this).click(function() {
				  		var prov = $(this).text().substring(1);
				  		var actObj = $("#resource_" + prov);
				  		if (! actObj.hasClass("active")) {
				  			Docs.toggleEndpointListForResource(prov);
				  		}
				  	});
				  });
				  try {
					$("#menuOptions").append("<br/><span style='font-size: 13px;margin-left: 7px;'>Build: " + buildversion + "</span><br/><span style='font-size: 13px;margin-left: 7px;'>Time: " + buildtime + "</span>");
		          } catch(err) {
		        	//Handle errors here
		          }		
		          $('#endpointListTogger_tienda-rest-controller').click();
		          $('ul .options').find("li").each(function() {
		        	  var _htmlTmp = $(this).html();
		        	  if (_htmlTmp.indexOf("Raw") > -1 ) {
		        		  $(this).hide();
		        	  }
		          });
		          $('#resources').find('.snippet-link').each(function() {
		        	  console.log(1);
		          });
                },
                onFailure: function(data) {
                	if(console) {
                        console.log("Unable to Load SwaggerUI");
                        console.log(data);
                    }
                },
                docExpansion: "none"
            });

            window.swaggerUi.load();		    
        });

       
        
    </script>
    <style>
      div.floating-menu {position:fixed;background:#fff4c8;border:1px solid #ffcc00;width:190px;top:100px; left:20px; z-index:100;}
      div.floating-menu a, div.floating-menu h3 {display:block;margin:0 0.5em;}
    </style>    
</head>

<body>
  <div id="header" class="fixed" style="display: block; top: 0px; ">
    <div class="inner swagger-ui-wrap" style="font-size: 15px;">
      <a id="logo" href="#">API Information</a>
    </div>
    <div id="dbActive" class="dbActive">    
      <a href="../index.html">Index Page</a>
    </div>
    <div class="shadow" style="display:block;"><span></span></div>
  </div>
  <nav>
    <div class="fakeshadow"></div>
  </nav>  
  <div class="container" style="margin-left: -210px;">
    <div class="floating-menu" style="display:none;">
    <h3>APIs</h3>
    <div id='menuOptions'>
      <a href="../index.html">Index Page</a><br/>
    </div>
    <br/>
    </div>
    
    <div id="message-bar" class="swagger-ui-wrap" style="display:none;">
        &nbsp;
    </div>
    
    <div id="swagger-ui-container" class="swagger-ui-wrap">
    
    </div>
  </div>
  
</body>

</html>


