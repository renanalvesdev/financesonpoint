$('form').on('submit', function(e) {
    var v = $(".mascara").maskMoney('unmasked')[0];
	console.log('desmascarado' + v);
    $(".mascara").val(v);
})