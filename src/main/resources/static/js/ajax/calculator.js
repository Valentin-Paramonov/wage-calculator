define(['jquery', 'hostConfig'], function($, hostConfig) {
    var host = hostConfig.getUrl();
    return {
        toNeto: function(bruto) {
            $.get(host + '/neto', {
                bruto: bruto
            }).done(function(neto) {
                $('#neto').html(neto.toFixed(2));
            }).fail(function(error) {
                console.error(error.message);
            });
        }
    };
});