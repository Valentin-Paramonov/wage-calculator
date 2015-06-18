package wage_calculator.calculator;

import java.math.BigDecimal;

import static wage_calculator.calculator.BigDecimalUtils.decimal;
import static wage_calculator.calculator.BigDecimalUtils.lt;

final class Assert {
    static void isGreaterThanZero(BigDecimal decimal) {
        if (lt(decimal, decimal(0, 2))) {
            throw new IllegalArgumentException();
        }
    }
}
