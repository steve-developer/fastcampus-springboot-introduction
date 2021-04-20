package com.example.calculator;

import com.example.calculator.service.DollarCalculator;
import com.example.calculator.service.MarketServer;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.BDDMockito.given;


@SpringBootTest
class AbstractCalculatorReqApplicationTests {

    @Autowired
    private DollarCalculator dollarCalculator;

    @Mock
    private MarketServer marketServer;

    @Test
    void contextLoads() {
    }

}
