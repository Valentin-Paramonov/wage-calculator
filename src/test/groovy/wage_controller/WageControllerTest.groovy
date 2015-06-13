package wage_controller

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.mock.web.MockServletContext
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import wage_calculator.WageController

@RunWith(SpringJUnit4ClassRunner)
@SpringApplicationConfiguration(classes = MockServletContext)
@WebAppConfiguration
class WageControllerTest {
    def mvc

    @Before
    public void setup() {
        mvc = MockMvcBuilders.standaloneSetup(new WageController()).build()
    }

    @Test
    void "Should work"() {
        mvc.perform(MockMvcRequestBuilders.get('/hello'))
            .andExpect(status().isOk())
            .andExpect(content().string(equaltTo('Hello!')))
    }
}
