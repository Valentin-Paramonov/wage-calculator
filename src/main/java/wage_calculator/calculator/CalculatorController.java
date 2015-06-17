package wage_calculator.calculator;

import org.eclipse.jetty.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;

@RestController
public class CalculatorController {
    @RequestMapping("/neto")
    public BigDecimal toNeto(@RequestParam BigDecimal bruto,
                             @RequestParam(required = false, defaultValue = "0") Integer persons,
                             HttpServletResponse response) {
        try {
            return WageCalculatorManager.toNetoWithRelief(bruto, persons);
        } catch (IllegalArgumentException iea) {
            response.setStatus(HttpStatus.BAD_REQUEST_400);
            return null;
        }
    }
}
