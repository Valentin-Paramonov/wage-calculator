define(['jquery'], function($) {
    var host = 'http://localhost:8080';
    return {
        toNeto: function(bruto, persons) {
            $.get(host + '/neto', {
                bruto: bruto,
                persons: persons
            }).done(function(neto) {
                $('#neto').val(neto);
            }).fail(function(error) {
                console.error(error.message);
            });
        }
    };
});