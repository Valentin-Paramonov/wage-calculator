package wage_calculator.exchange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

import static wage_calculator.BigDecimalUtils.toFixed;

@Component
class EurToJpyConverter {
    private static final String ecbUrl = "http://sdw-wsrest.ecb.europa.eu/service/data/EXR/D.JPY.EUR.SP00.A";
    private static String exRatePattern = "(\\d+\\.\\d{2})";
    private final RestTemplate rest;

    @Autowired
    EurToJpyConverter(RestTemplate rest) {
        this.rest = rest;
    }

    BigDecimal convert(BigDecimal eur) {
        return toFixed(eur.multiply(exRate()), 0);
    }

    private BigDecimal exRate() {
        return new BigDecimal(Arrays.stream(exRateCsv().split(","))
                                    .filter(s -> s.matches(exRatePattern))
                                    .findFirst()
                                    .orElseThrow(() ->
                                            new IllegalArgumentException("Failed to get the exchange rate")
                                    ));
    }

    private String exRateCsv() {
        LocalDate yesterday = LocalDate.now().minusDays(1);
        ResponseEntity<String> response = rest.getForEntity(ecbUrl + "?startPeriod={start}&endPeriod={end}&detail=dataonly", String.class, yesterday, yesterday);
        checkIsOk(response);
        return response.getBody();
    }

    private void checkIsOk(ResponseEntity<String> response) {
        HttpStatus statusCode = response.getStatusCode();
        if (statusCode != HttpStatus.OK) {
            throw new IllegalArgumentException("Got response status " + statusCode);
        }
    }
}
