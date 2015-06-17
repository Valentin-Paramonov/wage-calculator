require(['jquery', 'calculator'], function($, calculator) {
    var toNumber = function(input) {
        var number = Number(input);
        if (isNaN(number)) {
            throw new Error(input + ' is not a number!');
        }
        return number;
    };

    var recalculateNetto = function(brutoInput) {
        try {
            var bruto = toNumber(brutoInput);
            $('#neto').val(calculator.toNeto(bruto) || '');
        } catch(err) {
            console.error(err.message);
        }
    };

    $('#bruto').keyup(function(event) {
        event.preventDefault();
        var brutoInput = $(this).val();
        recalculateNetto(brutoInput);
    });
});