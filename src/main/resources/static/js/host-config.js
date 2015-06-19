define(function() {
    var host = 'http://localhost:8080';
    return {
        getNetoUrl: function() {
            return host + '/neto';
        },
        getExpensesUrl: function() {
            return host + '/expenses';
        },
        getJpyUrl: function() {
            return host + '/jpy';
        }
    }
});