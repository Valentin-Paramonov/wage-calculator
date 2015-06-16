package wage_calculator.templates;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TemplateController {
    @RequestMapping("/js-calculator")
    public String jsCalculator() {
        return "js-calculator";
    }
}
