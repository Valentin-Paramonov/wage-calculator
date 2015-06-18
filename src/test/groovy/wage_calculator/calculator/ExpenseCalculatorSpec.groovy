package wage_calculator.calculator

import spock.lang.Specification
import spock.lang.Unroll


class ExpenseCalculatorSpec extends Specification {
    @Unroll
    def "When bruto is #bruto, expenses should be #expenses"() {
        expect:
            ExpenseCalculator.calculateFor(bruto) == expenses
        where:
            bruto  || expenses
            42.0   || 52.27
            75.0   || 93.05
            666.0  || 823.47
            1300.0 || 1607.03
            3333.0 || 4119.61
    }
}
