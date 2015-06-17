package wage_calculator.calculator

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification

import static org.hamcrest.core.IsEqual.equalTo
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class CalculatorControllerSpec extends Specification {
    def controller = MockMvcBuilders.standaloneSetup(new CalculatorController()).build()

    def "When no parameter is provided, BadRequest status should be returned"() {
        expect:
            controller.perform(MockMvcRequestBuilders.get('/neto'))
                .andExpect(status().isBadRequest());
    }

    def "When negative amount is provided, BadRequest status should be returned"() {
        expect:
            controller.perform(MockMvcRequestBuilders.get('/neto').param("bruto", "-420"))
                .andExpect(status().isBadRequest());
    }

    def "When proper amount is provided, neto with OK status should be returned"() {
        expect:
            controller.perform(MockMvcRequestBuilders.get('/neto').param("bruto", "69"))
                .andExpect(status().isOk()).andExpect(content().string(equalTo("69.00")));
    }
}
