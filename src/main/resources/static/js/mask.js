
$(function(){
   $(".mascara").maskMoney({
      prefix: 'R$ ',
      allowNegative: true,
      thousands: '.',
      decimal: ','
   });
});
