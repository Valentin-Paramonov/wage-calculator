package wage_calculator.calculator;

import java.math.BigDecimal;

import static wage_calculator.BigDecimalUtils.decimal;
import static wage_calculator.BigDecimalUtils.toFixed;

final class WageCalculator {
    static final BigDecimal TAX_FREE_MIN = decimal(75, 2);
    static final BigDecimal SOCIAL_TAX = decimal(0.1005, 4);
    static final BigDecimal IIN_TAX = decimal(0.23, 2);
    static final BigDecimal RELIEF_PER_PERSON = decimal(165, 2);

    static BigDecimal netoFromBruto(BigDecimal bruto, int persons) {
        BigDecimal fixedBruto = toFixed(bruto, 2);
        BigDecimal social = toFixed(fixedBruto.multiply(SOCIAL_TAX), 2);
        BigDecimal relief = decimal(persons, 0).multiply(RELIEF_PER_PERSON);
        BigDecimal iin = toFixed(fixedBruto.subtract(social)
                                           .subtract(TAX_FREE_MIN)
                                           .subtract(relief)
                                           .multiply(IIN_TAX), 2);
        return fixedBruto.subtract(social).subtract(iin);
    }
}
