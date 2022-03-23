
(function($) {

    $(document).ready(function() {
        $('#despesaModal').on('show.bs.modal', function (event) {
            var button = $(event.relatedTarget); // Button that triggered the modal
            console.log(button.data('object-id'));
            
            $.get("/operacao/despesaModal?id="+button.data('object-id'), function (data) {
                $('#despesaModal').find('.modal-body').html(data);
                })
            });
    });

	$.extend( true, $.fn.dataTable.defaults, {
	    "searching": false,
	    "ordering": false
	} );

    $(document).ready(function() {
        $('#example').DataTable();
    } );
    
}) (jQuery);