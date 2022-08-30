/**
 * GENERALES CONSULTA JS
 */

/*Cambio de color según prioridad en tabal general de bienes*/
$(function() {
	$("table td:nth-child(11):contains(Baja)")
		.parents("tr")
	    .css("background-color", "#d5e8d4");
	 
		 $("table td:nth-child(11):contains(Media)")
	    .parents("tr")
	    .css("background-color", "#fff2cc");
	 
		 $("table td:nth-child(11):contains(Alta)")
	    .parents("tr")
	    .css("background-color", "#f8cecc");
});

//función select dinámico página rrhh 2 modal edit
$('#idzona1').change(
      function() {
          $.getJSON("//localhost:9898/views/Consulta/RRHH/Elegirspi", {
          /*$.getJSON("//192.168.61.28:8080/views/Consulta/RRHH/Elegirspi", {*/
              idzona : $(this).val(),
              ajax : 'true'
          }, function(data) {
              var html = '<option value="">Seleccionar un SPI.. </option>';
              var len = data.length;
              for ( var i = 0; i < len; i++) {
                  html += '<option value="' + data[i].idspi + '">'
                          + data[i].nombre + '</option>';
              }
              html += '</option>';
              $('#idspi1').html(html);
      });
});

//función obtener value spi para filtrado en página formulario
$(document).ready(function(){
	$("#idspi1").change(function(){
		var spiValue = $(this).children('option:selected').val();
		$('#filtrarform').attr('action', $('#baseURL').val() + spiValue);
	});
});

//Validaciones de Bootstrap 
(function() {
	  'use strict';
	  window.addEventListener('load', function() {
	    // Fetch all the forms we want to apply custom Bootstrap validation styles to
	    var forms = document.getElementsByClassName('needs-validation');
	    // Loop over them and prevent submission
	    var validation = Array.prototype.filter.call(forms, function(form) {
	      form.addEventListener('submit', function(event) {
	        if (form.checkValidity() === false) {
	          event.preventDefault();
	          event.stopPropagation();
	        }
	        form.classList.add('was-validated');
	      }, false);
	    });
	  }, false);
	})();