define(['jquery'], function($) {
    var host = 'http://localhost:8080';
    return {
        toNeto: function(bruto) {
            $.get(host + '/neto', {
                bruto: bruto
            }).done(function(neto) {
                $('#neto').html(neto);
            }).fail(function(error) {
                console.error(error.message);
            });
        }
    };
});