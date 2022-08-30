/**
 * 
 */

/*SPI DATOS*/
$(document).ready(function(){
	
	$('.table .editModal1').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href,function(spidatos,status){
			$('.editar #idspi').val(spidatos.idspi);
			$('.editar #nombre1').val(spidatos.nombre);
			$('.editar #idzona1').val(spidatos.idzona.idzona);
			$('.editar #idinstitucion1').val(spidatos.idinstitucion.idinstitucion);
			$('.editar #direccion1').val(spidatos.direccion);
			$('.editar #telefono1').val(spidatos.telefono);
			$('.editar #numerodeoficina1').val(spidatos.numerodeoficina);
			$('.editar #convenio1').val(spidatos.convenio);
			$('.editar #daservicioa1').val(spidatos.daservicioa);
			$('.editar #observaciones1').val(spidatos.observaciones);
			$('.editar #fechafinconvenio1').val(spidatos.fechafinconvenio.substr(0,10));
			$('.editar #archivo3').val(spidatos.archivo);
				
		});
		
		$('.editar #editarModal1').modal();
	});
});


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
		document.getElementById('idspinombre').innerHTML=registrospi.idspi.nombre;
		$('.editar #idinstitucion1').val(registrospi.idinstitucion.idinstitucion);
		$('.editar #estado1').val(registrospi.estado);
		$('.editar #cantidad2').val(registrospi.cantidad);
		$('.editar #cantidadrequerida2').val(registrospi.cantidadrequerida);
		$('.editar #holguradecantidad2').val(registrospi.holguradecantidad);
		$('.editar #prioridad1').val(registrospi.prioridad);
		$('.editar #accionrealizada1').val(registrospi.accionrealizada);
		$('.editar #periodo1').val(registrospi.periodo);
		document.getElementById('periodoano').innerHTML=registrospi.periodo;
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
			$('.editar #idspi1').val(rrhh.idspi.idspi);
			$('.editar #idzona11').val(rrhh.idzona.idzona);
			$('.editar #idspi11').val(rrhh.idspi.idspi);
			$('.editar #cargo1').val(rrhh.cargo);
			$('.editar #idmodalidad1').val(rrhh.idmodalidad.idmodalidad);
			$('.editar #idunidad1').val(rrhh.idunidad.idunidad);
			$('.editar #estado1').val(rrhh.estado);
			$('.editar #telefono1').val(rrhh.telefono);
			$('.editar #email1').val(rrhh.email);
			$('.editar #direccion1').val(rrhh.direccion);
																	
		});
		
		$('.editar #editarModal3').modal();
	});
});

/*ZONA*/
$(document).ready(function(){
	
	$('.table .editModal4').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href,function(zona,status){
			$('.editar #idzona').val(zona.idzona);
			$('.editar #zonanombre').val(zona.nombre);
																	
		});
		
		$('.editar #editarModal4').modal();
	});
});

/*INSTITUCION*/
$(document).ready(function(){
	
	$('.table .editModal5').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href,function(institucion,status){
			$('.editar #idinstitucion').val(institucion.idinstitucion);
			$('.editar #institucionnombre').val(institucion.nombre);
																	
		});
		
		$('.editar #editarModal5').modal();
	});
});

/*BIENES/SERVICIOS*/
$(document).ready(function(){
	
	$('.table .editModal6').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href,function(activo,status){
			$('.editar #idactivo').val(activo.idactivo);
			$('.editar #activonombre').val(activo.nombre);
			$('.editar #activotipo').val(activo.idtipo.idtipo);
			$('.editar #descripcion').val(activo.descripcion);
																	
		});
		
		$('.editar #editarModal6').modal();
	});
});

/*TIPO*/
$(document).ready(function(){
	
	$('.table .editModal7').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href,function(tipo,status){
			$('.editar #idtipo').val(tipo.idtipo);
			$('.editar #tiponombre').val(tipo.nombre);
			$('.editar #descripciont').val(tipo.descripcion);
																	
		});
		
		$('.editar #editarModal7').modal();
	});
});

/*UNIDAD*/
$(document).ready(function(){
	
	$('.table .editModal8').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href,function(unidad,status){
			$('.editar #idunidad').val(unidad.idunidad);
			$('.editar #unidadnombre').val(unidad.nombre);
																	
		});
		
		$('.editar #editarModal8').modal();
	});
});

/*MODALIDAD*/
$(document).ready(function(){
	
	$('.table .editModal9').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href,function(modalidad,status){
			$('.editar #idmodalidad').val(modalidad.idmodalidad);
			$('.editar #modalidadnombre').val(modalidad.nombre);
																	
		});
		
		$('.editar #editarModal9').modal();
	});
});




