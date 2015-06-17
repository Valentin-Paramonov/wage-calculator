package wage_calculator.calculator

import spock.lang.Specification
import spock.lang.Unroll

class WageCalculatorSpec extends Specification {
    @Unroll
    def "When bruto is #bruto and the number of persons is #persons, neto should be #neto"() {
        expect:
            WageCalculatorManager.toNetoWithRelief(bruto, persons) == neto
        where:
            bruto  || persons || neto
            42.0   || 0       || 42.0
            75.0   || 0       || 75.00
            666.0  || 0       || 478.53
            1300.0 || 0       || 917.65
            3333.0 || 0       || 2325.73
            2000.0 || 1       || 1440.43
            2000.0 || 3       || 1516.33
    }
}
