define(['jquery'], function($) {
    var host = 'http://localhost:8080';
    return {
        toNeto: function(bruto, persons) {
            $.get(host + '/neto', {
                bruto: bruto,
                persons: persons
            }).done(function(neto) {
                $('#neto').html(neto);
            }).fail(function(error) {
                console.error(error.message);
            });
        }
    };
});