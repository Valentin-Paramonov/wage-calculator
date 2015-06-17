package wage_calculator.calculator;

import java.math.BigDecimal;

import static wage_calculator.calculator.BigDecimalUtils.*;
import static wage_calculator.calculator.WageCalculator.RELIEF_PER_PERSON;
import static wage_calculator.calculator.WageCalculator.TAX_FREE_MIN;

final class WageCalculatorManager {
    static BigDecimal toNetoWithRelief(BigDecimal bruto, int persons) {
        BigDecimal personCount = decimal(persons, 0);
        assertThatIsGreaterThanZero(personCount);
        assertThatIsGreaterThanZero(bruto);
        BigDecimal relief = personCount.multiply(RELIEF_PER_PERSON);
        if (le(bruto, TAX_FREE_MIN.add(relief))) {
            return toFixed(bruto, 2);
        }
        return WageCalculator.netoFromBruto(bruto, persons);
    }

    private static void assertThatIsGreaterThanZero(BigDecimal bruto) {
        if (lt(bruto, decimal(0, 2))) {
            throw new IllegalArgumentException();
        }
    }
}
