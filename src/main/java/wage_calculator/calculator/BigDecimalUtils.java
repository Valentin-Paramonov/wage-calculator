package wage_calculator.calculator;

import java.math.BigDecimal;

final class BigDecimalUtils {
    static BigDecimal decimal(double val, int scale) {
        return toFixed(new BigDecimal(val), scale);
    }

    static BigDecimal toFixed(BigDecimal decimal, int scale) {
        return decimal.setScale(scale, BigDecimal.ROUND_HALF_EVEN);
    }

    static boolean lt(BigDecimal a, BigDecimal b) {
        return a.compareTo(b) < 0;
    }

    static boolean le(BigDecimal a, BigDecimal b) {
        return a.compareTo(b) <= 0;
    }
}
