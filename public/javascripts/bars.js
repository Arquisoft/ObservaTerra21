/* Dibujar gráfico de barras utilizando librería D3.js  */
function bars(pathJson,width) {

var alturaBarra = 20, 
	despX = 40;

var x = d3.scale.linear().range([ 0, width - despX ]);

// Selecciona elemento de la página con el gráfico
var grafico = d3.select(".chart")
				.attr("width", width);

d3.json(pathJson, drawBars);

function drawBars(error, data) {
	console.log("Before loading data...");
	if (error) {
		console.log("Error loading data!" + error)
	} else {
		console.log("Data loaded ok with " + data.length + " entries");
		console.log(data);

	x.domain([ 0, despX + d3.max(data, function(d) { return d.observationValue; }) ]);
	grafico.attr("width", width)
	grafico.attr("height", alturaBarra * data.length);

	// Crea un grupo por cada país desplazado a la posición
	// que le corresponda
	var bar = grafico.selectAll("g").data(data).enter().append("g").attr(
			"transform",
			function(d, i) {
				return "translate(" + 3 * despX + "," + i * alturaBarra + ")";
			});

	// Escribe el código del país
	bar.append("text")
	   .attr("class", "countryName")
	   .attr("x", -5)
	   .attr("y",alturaBarra / 2)
	   .attr("dy", ".35em")
	   .text(function(d) {
		   console.log(d.area.nombre);
			return d.area.nombre;
		});
	

	// Dibuja rectángulo con dimensión proporcional a valor
	bar.append("rect")
	   .attr("width", function(d) {	
		   console.log(d.observationValue);
		   return x(d.observationValue);  
		   })
	   .attr("height", alturaBarra - 1);

	// Escribe texto con valor
	bar.append("text")
	   .attr("x", function(d) { return x(d.observationValue) + 2 * despX; })
	   .attr("y", alturaBarra / 2)
	   .attr("dy", ".35em")
	   .text(function(d) { return d.observationValue + "ñoj" ;});
	}
 }
}