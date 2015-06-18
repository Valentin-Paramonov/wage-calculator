define(['jquery', 'hostConfig'], function($, hostConfig) {
    return {
        toNeto: function(bruto, persons) {
            $.get(hostConfig.getNetoUrl(), {
                bruto: bruto,
                persons: persons
            }).done(function(neto) {
                $('#neto').html(neto.toFixed(2));
            }).fail(function(error) {
                console.error('Got response code: ' + error.statusCode());
            });
        }
    };
});