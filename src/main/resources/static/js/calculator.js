define(function() {
    var MIN = 75.00;
    return {
        toNeto: function(bruto) {
            if (bruto < MIN) {
                return NaN;
            }
            bruto = bruto.toFixed(2);
            var social = 0.1005 * bruto;
            var iin = ((bruto - social - 75) * 0.23).toFixed(2);
            return (bruto - social - iin).toFixed(2);
        }
    };
});