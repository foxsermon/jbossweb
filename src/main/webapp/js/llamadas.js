
google.load("visualization", "1", {packages:["corechart"]});
google.setOnLoadCallback(renderTable);

function pingStatus() {
    $.ajax({
    	  url: "app/ping",
    	})
    	 .done(function(data) {
           $('#ping').html('<p>Time : ' + data.time + '</p>');
           $('#ping').append('<p>Active : ' + data.dbStatus+ '</p>');
           $('#dbActive').html('DB Active :)');
    	})
    	 .fail(function() {
    	   $('#ping').html('<p>Fallo :S </p>');
    	   $('#dbActive').html('DB Fallo :(');
    	});
}

function usuarios() {
	$.ajax({
		url: "app/usuarios",
	  })
	  .done(function(data){
		  $('#datos').html();
		  var _html = '';
		  _html += '<table class="hovertable" style="width:60%">';
		  _html += '<tr><th>Usuario</th><th>Nombre</th><th>Email</th><th>Offers</th></tr>';
		  $.each(data, function(i, item) {
			  _html += '<tr onmouseover="this.style.backgroundColor=\'#ffff66\';" onmouseout="this.style.backgroundColor=\'#d4e3e5\';">';
			  _html += '<td>' + item.username + '</td><td>' + item.name + '</td><td>' + item.email + '</td><td>' + item.offers.length + '</td></tr>';
		  });
		  $('#datos').html(_html);
		  _html += '</table>';
	  })
	  .fail(function(){
		$('#datos').html('<p>Fallo datos :S </p>');
	});	
}

function renderTable() {
    var zerosCount = [0, 0, 0, 0, 0, 0];
    var urlTienda = "http://" + ambiente + ":7613/tienda/retrieve.json";
    $.get(urlTienda, function(data, status){
        $.each(data, function() {
            //var timestamp = Date.parse(this['time'].substr(0, 10) + "T" + this['time'].substr(11, 8));
            var dt = new Date(this['time']);
            var valor = parseInt(this['op']);
            switch (valor) {
                case 0:
                   zerosCount[0]++;
                  break; 
                case 1:
                  zerosCount[1]++;
                  break; 
                case 2:
                  zerosCount[2]++;
                  break; 
                case 3:
                  zerosCount[3]++;
                  break; 
                case 4:
                  zerosCount[4]++;
                  break; 
                case 5:
                  zerosCount[5]++;
                  break;                   
            }
        });
        var data = google.visualization.arrayToDataTable([
          ['Operacion', 'Llamadas'],
          ['app/usuarios',     zerosCount[0]],
          ['app/ping',      zerosCount[1]],
          ['app/usuario',  zerosCount[2]],
          ['Pendiente - 3', zerosCount[3]],
          ['Pendiente - 4',    zerosCount[4]],
          ['Pendiente - 5',    zerosCount[5]]
        ]);

        var options = {
          title: 'Operaciones realizadas hasta hoy',
          is3D: true,
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
        chart.draw(data, options);
        var todos2Data={
                "background-color":"#ecf2f6",
                        "height":"27%",
                        "width":"83%",
                "graphset":[
                    {
                        "type":"bar",
                        "background-color":"#fff",
                        "border-color":"#dae5ec",
                        "border-width":"1px",
                        "width":"95%",
                        "x":"2%",
                        "y":"2%",
                        "title":{
                            "margin-top":"7px",
                            "margin-left":"9px",
                            "font-family":"Arial",
                            "text":"Operaciones realizadas hasta hoy",
                            "background-color":"none",
                            "shadow":0,
                            "text-align":"left",
                            "font-size":"13px",
                            "font-weight":"bold",
                            "font-color":"#707d94"
                        },
                        "scale-y":{
                            "max-ticks":4,
                            "max-items":4,
                            "line-color":"none",
                            "tick":{
                                "visible":false
                            },
                            "item":{
                                "font-color":"#8391a5",
                                "font-family":"Arial",
                                "font-size":"10px",
                                "padding-right":"5px"
                            },
                            "label":{
                                "text":"Cantidad (#)",
                                "font-size":"9px"
                            },                        
                            "guide":{
                                "rules":[
                                    {
                                 "rule":"%i == 0",
                                 "line-width":0
                                    },
                                    {
                                        "rule":"%i > 0",
                                       "line-style":"solid",
                                        "line-width":"1px",
                                        "line-color":"#d2dae2",
                                         "alpha":0.4 
                                    }
                                
                                ]
                            }
                        },
                        "scale-x":{
                            "items-overlap":true,
                            "max-items":10,
                            "values":["0","1","2","3","4","5"],
                            "offset-y":"1px",
                            "line-color":"#d2dae2",
                            "item":{
                                "font-color":"#8391a5",
                                "font-family":"Arial",
                                "font-size":"11px",
                                "padding-top":"2px"
                            },
                            "tick":{
                                "visible":false,
                                "line-color":"#d2dae2"
                            },
                            "label":{
                                "text":"Operaciones (ID)",
                                "font-size":"9px"
                            },                        
                            "guide":{
                                "visible":false
                            }
                        },
                        "plotarea":{
                            "margin":"45px 20px 38px 45px"
                        },
                        "plot":{
                            "bar-width":"33px",
                            "exact":true,
                            "hover-state":{
                                "visible":false
                            },
                            "animation":{
                                "effect":"ANIMATION_SLIDE_BOTTOM"
                            },
                            "tooltip":{
                                "font-color":"#fff",
                                "font-family":"Arial",
                                "font-size":"11px",
                                "border-radius":"6px",
                                "shadow":false,
                                "padding":"5px 10px"
                            }
                        },
                        "series":[
                            {
                                "values":[zerosCount[0], zerosCount[1], zerosCount[2], zerosCount[3], zerosCount[4], zerosCount[5]],
                                "styles":[
                                    {"background-color":"#4dbac0"},
                                    {"background-color":"#25a6f7"},
                                    {"background-color":"#ad6bae"},
                                    {"background-color":"#707d94"},
                                    {"background-color":"#f3950d"},
                                    {"background-color":"#4e74c0"}
                                ]
                            }
                        ]
                    }
                ]
            };


            zingchart.render({
              id:'todos2Div',
              height:800,
              width:600,
              data:todos2Data
            });    
    });    
}

$(document).ready(function(){
    pingStatus();
    usuarios();
    var DELAY = 1000;
    setTimeout(renderTable, DELAY * 60 * 5);
    //renderTable();    
});

var intPing=setInterval("pingStatus()", 1000 * 60 * 60);
