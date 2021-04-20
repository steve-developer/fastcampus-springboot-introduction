package com.example.calculator.controller;

import com.example.calculator.dto.CalculatorReq;
import com.example.calculator.service.DollarCalculator;
import com.example.calculator.service.MarketServer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest({CalculatorApiController.class})
@AutoConfigureMockMvc
@Import(DollarCalculator.class)
public class CalculatorApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MarketServer marketServer;

    @Test
    public void helloTest() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/calculator/hello")
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        ).andExpect(
                content().string("hello")
        ).andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getTest() throws Exception {
        when(marketServer.price()).thenReturn(1100);

        LinkedMultiValueMap<String, String> map = new LinkedMultiValueMap();
        map.add("x","10");
        map.add("y","10");

        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/calculator/sum").queryParams(map)
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        ).andExpect(
                content().string("22000")
        ).andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void postTest() throws Exception {
        when(marketServer.price()).thenReturn(1100);

        CalculatorReq req = new CalculatorReq();
        req.setX(10);
        req.setY(10);

        String json = new ObjectMapper().writeValueAsString(req);
        System.out.println(json);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/calculator/sum")
                .content(json)
                .contentType("application/json")
                .accept("application/json")
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.result").value("22000")
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.body.responseResult").value("22000")
        ).andDo(MockMvcResultHandlers.print());
    }

}
