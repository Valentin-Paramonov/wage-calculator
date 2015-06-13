package wage_controller

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification
import wage_calculator.WageController

import static org.hamcrest.core.IsEqual.equalTo
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class WageControllerSpec extends Specification {
    def mvc = MockMvcBuilders.standaloneSetup(new WageController()).build()

    def 'When getting the /hello endpoint, "Hello!" should be returned with OK status'() {
        expect:
            mvc.perform(MockMvcRequestBuilders.get('/hello'))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo('Hello!')))
    }
}
