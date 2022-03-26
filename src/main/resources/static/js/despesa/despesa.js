
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

	$(document).ready(function(){
		// Load the Visualization API and the corechart package.
        google.charts.load('current', {'packages':['corechart']});

        // Set a callback to run when the Google Visualization API is loaded.
        google.charts.setOnLoadCallback(drawChart);

        // Callback that creates and populates a data table,
        // instantiates the pie chart, passes in the data and
        // draws it.
        function drawChart() {
			
            // Create the data table.
            var data = new google.visualization.DataTable();
            data.addColumn('string', 'Topping');
            data.addColumn('number', 'Slices');
            data.addRows(chartAmountCarteiraData[0]);
            // Set chart options
            var options = {'title':'Porcentagem gastos do mês por Carteira',
                'width':600,
                'height':500};

            // Instantiate and draw our chart, passing in some options.
            var chart = new google.visualization.PieChart(document.getElementById('chart_amount_carteira_div'));
            chart.draw(data, options);
        }	
	});
	
	$(document).ready(function(){
		// Load the Visualization API and the corechart package.
        google.charts.load('current', {'packages':['corechart']});

        // Set a callback to run when the Google Visualization API is loaded.
        google.charts.setOnLoadCallback(drawChart);

        // Callback that creates and populates a data table,
        // instantiates the pie chart, passes in the data and
        // draws it.
        function drawChart() {
			
            // Create the data table.
            var data = new google.visualization.DataTable();
            data.addColumn('string', 'Topping');
            data.addColumn('number', 'Slices');
            data.addRows(chartAmountCategoriaData[0]);
            // Set chart options
            var options = {'title':'Porcentagem gastos do mês por Categoria',
                'width':600,
                'height':500};

            // Instantiate and draw our chart, passing in some options.
            var chart = new google.visualization.PieChart(document.getElementById('chart_amount_categoria_div'));
            chart.draw(data, options);
        }	
	});
    
}) (jQuery);