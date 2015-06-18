define(['jquery', 'hostConfig'], function($, hostConfig) {
    var setNeto = function(bruto, persons) {
        $.get(hostConfig.getNetoUrl(), {
            bruto: bruto,
            persons: persons
        }).done(function(neto) {
            $('#neto').html(neto.toFixed(2));
        }).fail(function(error) {
            console.error(error);
        });
    };

    var setExpenses = function(bruto) {
        $.get(hostConfig.getExpensesUrl(), {
            bruto: bruto
        }).done(function(expenses) {
            $('#expenses').html(expenses.toFixed(2));
        }).fail(function(error) {
            console.error(error);
        });
    };

    return {
        toNeto: function(bruto, persons) {
            setNeto(bruto, persons);
            setExpenses(bruto);
        }
    };
});
