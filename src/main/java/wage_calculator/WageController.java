package wage_calculator;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WageController {
    @RequestMapping("/hello")
    public String ayHi() {
        return "Hello!";
    }
}
