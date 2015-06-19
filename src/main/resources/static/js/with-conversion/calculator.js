define(['jquery', 'hostConfig'], function($, hostConfig) {
    var setJpy = function(eur) {
        $.get(hostConfig.getJpyUrl(), {
            eur:eur
        }).done(function(jpy) {
            $('#jpy').html(jpy);
        })
        .fail(logError);
    };

    var setNeto = function(bruto, persons) {
        $.get(hostConfig.getNetoUrl(), {
            bruto: bruto,
            persons: persons
        }).done(function(neto) {
            var fixedNeto = neto.toFixed(2);
            $('#neto').html(fixedNeto);
            setJpy(fixedNeto);
        }).fail(logError);
    };

    var setExpenses = function(bruto) {
        $.get(hostConfig.getExpensesUrl(), {
            bruto: bruto
        }).done(function(expenses) {
            $('#expenses').html(expenses.toFixed(2));
        }).fail(logError);
    };

    var logError = function(error) {
        console.error(error);
    }

    return {
        toNeto: function(bruto, persons) {
            setNeto(bruto, persons);
            setExpenses(bruto);
        }
    };
});
