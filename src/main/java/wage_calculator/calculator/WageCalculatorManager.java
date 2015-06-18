package wage_calculator.calculator;

import java.math.BigDecimal;

import static wage_calculator.calculator.BigDecimalUtils.*;
import static wage_calculator.calculator.WageCalculator.RELIEF_PER_PERSON;
import static wage_calculator.calculator.WageCalculator.TAX_FREE_MIN;

final class WageCalculatorManager {
    static BigDecimal toNetoWithRelief(BigDecimal bruto, int persons) {
        BigDecimal personCount = decimal(persons, 0);
        Assert.isGreaterThanZero(personCount);
        Assert.isGreaterThanZero(bruto);
        BigDecimal relief = personCount.multiply(RELIEF_PER_PERSON);
        if (le(bruto, TAX_FREE_MIN.add(relief))) {
            return toFixed(bruto, 2);
        }
        return WageCalculator.netoFromBruto(bruto, persons);
    }
}
