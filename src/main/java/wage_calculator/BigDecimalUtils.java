package wage_calculator;

import java.math.BigDecimal;

public final class BigDecimalUtils {
    public static BigDecimal decimal(double val, int scale) {
        return toFixed(new BigDecimal(val), scale);
    }

    public static BigDecimal toFixed(BigDecimal decimal, int scale) {
        return decimal.setScale(scale, BigDecimal.ROUND_HALF_EVEN);
    }

    public static boolean lt(BigDecimal a, BigDecimal b) {
        return a.compareTo(b) < 0;
    }

    public static boolean le(BigDecimal a, BigDecimal b) {
        return a.compareTo(b) <= 0;
    }
}
