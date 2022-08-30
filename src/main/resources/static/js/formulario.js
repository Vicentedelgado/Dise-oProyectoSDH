/**
 * FORMULARIO JS
 */


/*Cambio de color según prioridad en formulario*/
$(function() {
	$("table td:nth-child(7):contains(Baja)")
	.parents("tr")
    .css("background-color", "#78cf8c");
	
	$("table td:nth-child(7):contains(Media)")
	.parents("tr")
    .css("background-color", "#fff2cc");
	
	$("table td:nth-child(7):contains(Alta)")
	.parents("tr")
    .css("background-color", "#f8cecc");
});

//////////////////////////////////////////////////////////////////////////////////
//función select dinámico página formulario
$('#spiporzonaformulario').change(
        function() {
            $.getJSON("https://spidatasdh.herokuapp.com/views/DataSpi/Formulario/Elegirspi", {
           /* $.getJSON("http://192.168.61.28:8080/views/DataSpi/Formulario/Elegirspi", {*/
                idzona : $(this).val(),
                ajax : 'true'
            }, function(data) {
                var html = '<option value="">Seleccionar un SPI...</option>';
                var len = data.length;
                for ( var i = 0; i < len; i++) {
                    html += '<option value="' + data[i].idspi + '">'
                            + data[i].nombre + '</option>';
                }
                html += '</option>';
                $('#idspi').html(html);
        });
    });

//función obtener value spi para filtrado en página formulario
$(document).ready(function(){
	$("#idspi").change(function(){
		var spiValue = $(this).children('option:selected').val();
		$('#filtrarform').attr('action', $('#baseURL').val() + spiValue);
	});
});
/////////////////////////////////////////////////////////////////////////////

//función select dinámico página formulario por tipo
$('#filtrarportipo').change(
        function() {
            $.getJSON("https://spidatasdh.herokuapp.com/views/DataSpi/RegistroDelSpi/Elegiractivo", {
            /*$.getJSON("http://192.168.61.28:8080/views/DataSpi/RegistroDelSpi/Elegiractivo", {*/
                idtipo : $(this).val(),
                ajax : 'true'
            }, function(data) {
                var html = '<option value="">Seleccionar un bien/servicio...</option>';
                var len = data.length;
                for ( var i = 0; i < len; i++) {
                    html += '<option value="' + data[i].idactivo + '">'
                            + data[i].nombre + '</option>';
                }
                html += '</option>';
                $('#idactivo').html(html);
        });
});


///////////////////////////////////////////////////////////////////////////////

/*cambio de valores para la ventana modal editar y guardar en formulario */


/*REGISTRO DEL SPI*/
$(document).ready(function(){
	
$('.table .editModal2').on('click',function(event){
	event.preventDefault();
	var href = $(this).attr('href');
	$.get(href,function(registrospi,status){
		$('.editar #idregistro').val(registrospi.idregistro);
		$('.editar #idactivo1').val(registrospi.idactivo.idactivo);
		document.getElementById('idactivonombre').innerHTML=registrospi.idactivo.nombre;
		$('.editar #idspi1').val(registrospi.idspi.idspi);
		$('.editar #idinstitucion1').val(registrospi.idinstitucion.idinstitucion);
		$('.editar #estado1').val(registrospi.estado);
		$('.editar #cantidad').val(registrospi.cantidad);
		$('.editar #cantidadrequerida').val(registrospi.cantidadrequerida);
		$('.editar #holguradecantidad').val(registrospi.holguradecantidad);
		$('.editar #prioridad1').val(registrospi.prioridad);
		$('.editar #accionrealizada1').val(registrospi.accionrealizada);
		$('.editar #periodo1').val(registrospi.periodo);
		document.getElementById('periodonombre').innerHTML=registrospi.periodo;
		$('.editar #fechaaccion1').val(registrospi.fechaaccion.substr(0,10));
		$('.editar #observaciones1').val(registrospi.observaciones);
		$('.editar #archivo3').val(registrospi.archivo);
	});
	
	$('.editar #editarModal2').modal();
});
});

/*RRHH*/
$(document).ready(function(){
	
	$('.table .editModal3').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href,function(rrhh,status){
			$('.editar #idusuario').val(rrhh.idusuario);
			$('.editar #nombres1').val(rrhh.nombres);
			$('.editar #apellidos1').val(rrhh.apellidos);
			$('.editar #cargo1').val(rrhh.cargo);
			$('.editar #cedula1').val(rrhh.cedula);
			$('.editar #idzona1').val(rrhh.idzona.idzona);
			$('.editar #idspi11').val(rrhh.idspi.idspi);
			$('.editar #cargo1').val(rrhh.cargo);
			$('.editar #idmodalidad1').val(rrhh.idmodalidad.idmodalidad);
			$('.editar #idunidad1').val(rrhh.idunidad.idunidad);
			$('.editar #estado2').val(rrhh.estado);
			$('.editar #telefono1').val(rrhh.telefono);
			$('.editar #email1').val(rrhh.email);
			$('.editar #direccion1').val(rrhh.direccion);
																	
		});
		
		$('.editar #editarModal3').modal();
	});
});

$('#saveModal').on('show.bs.modal', function (event) {
    $("#saveModal input").val('');
    $("#archivo2").val('vacio_sdh.pdf');
    $("#saveModal select").val("");
    $("#saveModal textarea").val('');
    $("#saveModal small").val('');
    $("#spi").val(document.getElementById("spi1").value);
    $("#Guardar").val("Guardar");
});

$('#saveModalActivo').on('show.bs.modal', function (event) {
	$("#saveModalActivo input").val('');
	$("#saveModalActivo select").val("");
	$("#saveModalActivo textarea").val('');
	$("#spi31").val('N');
	$("#spi32").val('N');
	$("#spi33").val('1');
	$("#spi34").val('1');
	$("#spi35").val('1');
	$("#spi36").val('0000');
    $("#spi3").val(document.getElementById("spi1").value);
    $("#Guardaractivo").val("Guardar");
});

$('#saveModalInstitucion').on('show.bs.modal', function (event) {
	$("#saveModalInstitucion input").val('');
	$("#spi41").val('N');
	$("#spi42").val('N');
	$("#spi43").val('1');
	$("#spi44").val('1');
	$("#spi45").val('1');
	$("#spi46").val('0000');
    $("#spi4").val(document.getElementById("spi1").value);
    $("#GuardarInstitucion").val("Guardar");
});

$('#saveModalRRHH').on('show.bs.modal', function (event) {
	$("#saveModalRRHH input").val('');
	$("#saveModalRRHH select").val("");
	$("#saveModalRRHH textarea").val('');
	$("#idzona2").val(document.getElementById("zona1").value);
    $("#idspi12").val(document.getElementById("spi1").value);
    $("#estado3").val("Activo");
    $("#Guardarrrhh").val("Guardar");
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


