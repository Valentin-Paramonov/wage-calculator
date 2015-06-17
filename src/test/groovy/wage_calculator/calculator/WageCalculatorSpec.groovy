package wage_calculator.calculator

import spock.lang.Specification
import spock.lang.Unroll

class WageCalculatorSpec extends Specification {
    @Unroll
    def "When bruto is #bruto, neto should be #neto"() {
        expect:
            WageCalculator.toNeto(bruto) == neto
        where:
            bruto  || neto
            42.0   || 42.0
            75.0   || 75.00
            666.0  || 478.53
            1300.0 || 917.65
            3333.0 || 2325.73
    }
}
