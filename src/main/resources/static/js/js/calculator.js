define(function() {
    var TAX_FREE_MIN = 75.00;
    var SOCIAL_TAX = 0.1005;
    var IIN_TAX = 0.23;

    var toNeto = function(bruto) {
        bruto = bruto.toFixed(2);
        var social = (SOCIAL_TAX * bruto).toFixed(2);
        var iin = ((bruto - social - TAX_FREE_MIN) * IIN_TAX).toFixed(2);
        return (bruto - social - iin).toFixed(2);
    };

    return {
        toNeto: function(bruto) {
            if (bruto < 0) {
                return NaN;
            }
            if (bruto <= TAX_FREE_MIN) {
                return bruto.toFixed(2);
            }
            return toNeto(bruto);
        }
    };
});