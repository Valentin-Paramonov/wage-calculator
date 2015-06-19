package wage_calculator.exchange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class ExchangeController {
    private final EurToJpyConverter eurToJpy;

    @Autowired
    private ExchangeController(EurToJpyConverter eurToJpy) {
        this.eurToJpy = eurToJpy;
    }

    @RequestMapping("/jpy")
    public BigDecimal eurToJpy(BigDecimal eur) {
        return eurToJpy.convert(eur);
    }
}
