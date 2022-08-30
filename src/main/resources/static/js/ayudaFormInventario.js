
$(document).ready(function(){
	document.getElementById("idequiper").value = document.getElementById("idequipervalor").value;
	
});
/////////////////////////////////////////////////////////////////
$(document).ready(function(){
	document.getElementById("archivos1").value = document.getElementById("vacio").value;
		
});



///////////////////////////////////////////////////////////////////
$(document).ready(function(){
	$("#idced").change(function(){	
		var cedula = $(this).val();
		$('#filtrarformequipo').attr('action', $('#baseURLequipo').val() + cedula);
		
	});
});
///////////////////////////////////////////////////////////////////

$(document).ready(function(){
	$("#idced1").change(function(){	
		var cedula1 = $(this).val();
		$('#filtrarformperiferico').attr('action', $('#baseURLperiferico').val() + cedula1);
	});
});


////////////////////////////////////////////////
//Validaciones de Bootstrap 
(function () {
  'use strict'

  // Fetch all the forms we want to apply custom Bootstrap validation styles to
  var forms = document.querySelectorAll('.needs-validation')

  // Loop over them and prevent submission
  Array.prototype.slice.call(forms)
    .forEach(function (form) {
      form.addEventListener('submit', function (event) {
        if (!form.checkValidity()) {
          event.preventDefault()
          event.stopPropagation()
        }

        form.classList.add('was-validated')
      }, false)
    })
})();

//Cerrar alertas
window.setTimeout(function() {
  $(".alert").fadeTo(500, 0).slideUp(500, function(){
      $(this).remove(); 
  });
}, 3000);


//////////////////////////////////////////////////////////////////////////////

//Validación peso maximo del archivo
const MAXIMO_TAMANIO_BYTES = 6000000; // 1MB = 1 millón de bytes

//Obtener referencia al elemento
const $miArchivo = document.querySelector("#archivos");

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
 