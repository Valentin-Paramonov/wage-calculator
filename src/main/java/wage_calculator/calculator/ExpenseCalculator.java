package wage_calculator.calculator;

import java.math.BigDecimal;

import static wage_calculator.calculator.BigDecimalUtils.decimal;
import static wage_calculator.calculator.BigDecimalUtils.toFixed;

final class ExpenseCalculator {
    static final BigDecimal EXPENSE_FACTOR = decimal(1.2359, 4);
    static final BigDecimal DOCUMENT_FEE = decimal(0.36, 2);

    static BigDecimal calculateFor(BigDecimal bruto) {
        Assert.isGreaterThanZero(bruto);
        return toFixed(toFixed(bruto, 2).multiply(EXPENSE_FACTOR)
                                        .add(DOCUMENT_FEE), 2);
    }
}
