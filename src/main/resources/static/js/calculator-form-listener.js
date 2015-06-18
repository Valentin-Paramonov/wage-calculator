require(['jquery', 'calculator'], function($, calculator) {
    var persons = 0;
    var bruto = 0;

    var toNumber = function(input) {
        var number = Number(input);
        if (isNaN(number)) {
            throw new Error(input + ' is not a number!');
        }
        return number;
    };

    var recalculateNetto = function(brutoInput) {
        $('#neto').html(calculator.toNeto(bruto, persons) || '');
    };

    $('#bruto').keyup(function(event) {
        event.preventDefault();
        var brutoInput = $(this).val();
        try {
            bruto = toNumber(brutoInput);
            recalculateNetto();
        } catch(err) {
            console.error(err.message);
        }
    });

    $('#persons').keyup(function(event) {
        event.preventDefault();
        var personsInput = $(this).val();
        try {
            persons = toNumber(personsInput);
            recalculateNetto();
        } catch(err) {
            console.error(err.message);
        }
    });
});