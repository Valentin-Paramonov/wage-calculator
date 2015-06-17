package wage_calculator.calculator;

import java.math.BigDecimal;

import static wage_calculator.calculator.BigDecimalUtils.*;

class WageCalculator {
    static final BigDecimal TAX_FREE_MIN = decimal(75, 2);
    static final BigDecimal SOCIAL_TAX = decimal(0.1005, 4);
    static final BigDecimal IIN_TAX = decimal(0.23, 2);

    static BigDecimal toNeto(BigDecimal bruto) {
        if (lt(bruto, decimal(0, 2))) {
            throw new IllegalArgumentException();
        }
        if (le(bruto, TAX_FREE_MIN)) {
            return toFixed(bruto, 2);
        }
        return netoFromBruto(bruto);
    }

    private static BigDecimal netoFromBruto(BigDecimal bruto) {
        BigDecimal fixedBruto = toFixed(bruto, 2);
        BigDecimal social = toFixed(fixedBruto.multiply(SOCIAL_TAX), 2);
        BigDecimal iin = toFixed(fixedBruto.subtract(social).subtract(TAX_FREE_MIN).multiply(IIN_TAX), 2);
        return fixedBruto.subtract(social).subtract(iin);
    }
}
