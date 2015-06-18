define(['jquery', 'hostConfig'], function($, hostConfig) {
    var host = hostConfig.getUrl();
    return {
        toNeto: function(bruto, persons) {
            $.get(host + '/neto', {
                bruto: bruto,
                persons: persons
            }).done(function(neto) {
                $('#neto').html(neto.toFixed(2));
            }).fail(function(error) {
                console.error(error.message);
            });
        }
    };
});