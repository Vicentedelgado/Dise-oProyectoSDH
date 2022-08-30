/**
 * GENERALES JS
 */

/*Cambio de color según prioridad en tabal general de bienes*/
$(function() {
	$("table td:nth-child(12):contains(Baja)")
		.parents("tr")
	    .css("background-color", "#d5e8d4");
	 
		 $("table td:nth-child(12):contains(Media)")
	    .parents("tr")
	    .css("background-color", "#fff2cc");
	 
		 $("table td:nth-child(12):contains(Alta)")
	    .parents("tr")
	    .css("background-color", "#f8cecc");
});
//////////////////////////////////////////////////REGISTRO DEL SPI///////////////////////////
//función select dinámico página registro del spi por tipo
$('#filtrarportipo').change(
        function() {
            $.getJSON("http://localhost:9898/views/DataSpi/RegistroDelSpi/Elegiractivo", {
            /*$.getJSON("http://192.168.61.28:8080/views/DataSpi/RegistroDelSpi/Elegiractivo", {*/
                idtipo : $(this).val(),
                ajax : 'true'
            }, function(data) {
                var html = '<option value="">Seleccionar un bien/servicio.. </option>';
                var len = data.length;
                for ( var i = 0; i < len; i++) {
                    html += '<option value="' + data[i].idactivo + '">'
                            + data[i].nombre + '</option>';
                }
                html += '</option>';
                $('#idactivo').html(html);
        });
});


//función select dinámico página rrhh 1 modal save
$('#spiporzona').change(
        function() {
            $.getJSON("http://localhost:9898/views/DataSpi/RegistroDelSpi/Elegirspi", {
            /*$.getJSON("http://192.168.61.28:8080/views/DataSpi/RegistroDelSpi/Elegirspi", {*/
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
                $('#spiid').html(html);
        });
});

//función obtener value spi para filtrado en página general modal save

///////////////////////////////////////////////////RRHH//////////////////////////////

//función select dinámico página rrhh 2 modal edit
$('#idzona1').change(
        function() {
            $.getJSON("//localhost:9898/views/DataSpi/RRHH/Elegirspi", {
            /*$.getJSON("//192.168.61.28:8080/views/DataSpi/RRHH/Elegirspi", {*/
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

//función select dinámico página rrhh filtrar 
$('#idzonafiltrar').change(
      function() {
          $.getJSON("//localhost:9898/views/DataSpi/RRHH/Elegirspi", {
          /*$.getJSON("//192.168.61.28:8080/views/DataSpi/RRHH/Elegirspi", {*/
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
              $('#idspifiltrar').html(html);
      });
});

//función obtener value spi para filtrado en página RRHH por SPI
$(document).ready(function(){
	$("#idspifiltrar").change(function(){
		var spiValue = $(this).children('option:selected').val();
		$('#filtrarform').attr('action', $('#baseURL').val() + spiValue);
	});
});


/////////////////////////////////////////////////////////////////////COMPARTIDO//////////////////////////
//limpiar form guardar
$('#saveModal').on('show.bs.modal', function (event) {
    $("#saveModal input").val('');
    $("#archivo2").val('vacio_sdh.pdf');
    $("#saveModal select").val("");
    $("#saveModal textarea").val('');
    $("#saveModal small").val('');
    $("#Guardar").val("Guardar");
});

$('#saveModalRRHHporSpi').on('show.bs.modal', function (event) {
    $("#saveModalRRHHporSpi input").val('');
    $("#saveModalRRHHporSpi select").val("");
    $("#saveModalRRHHporSpi textarea").val('');
    $("#saveModalRRHHporSpi small").val('');
    $("#idzona14").val(document.getElementById("idzona13").value);
    $("#idspi14").val(document.getElementById("idspi13").value);
    $("#Guardar").val("Guardar");
});

$('#saveModalActivo').on('show.bs.modal', function (event) {
	$("#saveModalActivo input").val('');
	$("#saveModalActivo select").val("");
	$("#saveModalActivo textarea").val('');
    $("#Guardaractivo").val("Guardar");
});

$('#saveModalInstitucion').on('show.bs.modal', function (event) {
	$("#saveModalInstitucion input").val('');
    $("#GuardarInstitucion").val("Guardar");
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

//Cerrar alertas
window.setTimeout(function() {
    $(".alert").fadeTo(500, 0).slideUp(500, function(){
        $(this).remove(); 
    });
}, 3000);



//Validación peso maximo del archivo
const MAXIMO_TAMANIO_BYTES = 6000000; // 1MB = 1 millón de bytes

//Obtener referencia al elemento
const $miArchivo = document.querySelector("#archivo");
const $miArchivo1 = document.querySelector("#archivo1");

$miArchivo.addEventListener("change", function () {
	// si no hay archivos, regresamos
	if (this.files.length <= 0) return;

	// Validamos el primer archivo únicamente
	const archivo = this.files[0];
	if (archivo.size > MAXIMO_TAMANIO_BYTES) {
		const tamanioEnMb = MAXIMO_TAMANIO_BYTES / 1000000;
		alert(`El tamaño máximo del Verificable es de ${tamanioEnMb} MB`);
		// Limpiar
		$miArchivo.value = "";
	} else {
		// Validación pasada. Envía el formulario o haz lo que tengas que hacer
	}
});

$miArchivo1.addEventListener("change", function () {
	// si no hay archivos, regresamos
	if (this.files.length <= 0) return;

	// Validamos el primer archivo únicamente
	const archivo = this.files[0];
	if (archivo.size > MAXIMO_TAMANIO_BYTES) {
		const tamanioEnMb = MAXIMO_TAMANIO_BYTES / 1000000;
		alert(`El tamaño máximo del Verificable es de ${tamanioEnMb} MB`);
		// Limpiar
		$miArchivo1.value = "";
	} else {
		// Validación pasada. Envía el formulario o haz lo que tengas que hacer
	}
});


