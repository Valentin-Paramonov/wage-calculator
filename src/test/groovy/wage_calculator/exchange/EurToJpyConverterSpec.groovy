package wage_calculator.exchange

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate
import spock.lang.Specification


class EurToJpyConverterSpec extends Specification {
    EurToJpyConverter converter
    def response

    def setup() {
        def rest = Mock(RestTemplate)
        response = Mock(ResponseEntity)
        rest.getForEntity(*_) >> response
        converter = new EurToJpyConverter(rest)
    }

    def "Should convert EUR to JPY according to the exchange rate"() {
        given:
            response.statusCode >> HttpStatus.OK
            response.body >> 'aaa,spam,rubbish,nothing,1.33,much,else'
        when:
            def jpy = converter.convert(5.20)
        then:
            jpy == 7.0
    }
}
