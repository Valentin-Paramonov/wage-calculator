define(['jquery', 'hostConfig'], function($, hostConfig) {
    return {
        toNeto: function(bruto) {
            $.get(hostConfig.getNetoUrl(), {
                bruto: bruto
            }).done(function(neto) {
                $('#neto').html(neto.toFixed(2));
            }).fail(function(error) {
                console.error(error);
            });
        }
    };
});