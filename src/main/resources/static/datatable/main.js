//Código para Datables

//$('#example').DataTable(); //Para inicializar datatables de la manera más simple
//Formulario
//Generales
$(document).ready(function() {    
    $('table.display').DataTable({
    	"scrollX": true,
    	"scrollCollapse": true,
    //para cambiar el lenguaje a español
        "language": {
                "lengthMenu": "Mostrar _MENU_ Registros",
                "zeroRecords": "No se encontraron resultados",
                "info": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
                "infoEmpty": "Registros del 0 al 0 de un total de 0 registros",
                "infoFiltered": "(filtrado de un total de _MAX_ registros)",
                "sSearch": "Buscar:",
                "oPaginate": {
                    "sFirst": "Primero",
                    "sLast":"Último",
                    "sNext":"Siguiente",
                    "sPrevious": "Anterior"
			     },
			     "sProcessing":"Procesando...",
            },
	    "fixedColumns":   {
	        leftColumns: 4
	    }    	
    });     
});

$(document).ready(function() {
    var table = $('#table.display').DataTable( {
        scrollX:        true,
        scrollCollapse: true,
        paging:         true,
        fixedColumns:   {
            leftColumns: 2
        }
    } );
} );