package wage_calculator.templates;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TemplateController {
    @RequestMapping("/js-calculator")
    public String jsCalculator() {
        return "js/calculator";
    }

    @RequestMapping("/ajax-calculator")
    public String ajaxCalculator() {
        return "ajax/calculator";
    }

    @RequestMapping("/calculator-with-relief")
    public String calculatorWithRelief() {
        return "with-relief/calculator";
    }

    @RequestMapping("/calculator-with-expenses")
    public String calculatorWithExpenses() {
        return "with-expenses/calculator";
    }

    @RequestMapping("/calculator-with-conversion")
    public String calculatorWithConversion() {
        return "with-conversion/calculator";
    }
}
