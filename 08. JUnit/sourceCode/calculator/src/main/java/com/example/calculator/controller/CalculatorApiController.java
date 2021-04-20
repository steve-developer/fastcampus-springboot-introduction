package com.example.calculator.controller;

import com.example.calculator.dto.CalculatorReq;
import com.example.calculator.dto.CalculatorRes;
import com.example.calculator.service.DollarCalculator;
import com.example.calculator.service.ICalculator;
import com.example.calculator.service.MarketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.error.Mark;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorApiController {

    private final ICalculator iCalculator;

    public CalculatorApiController(DollarCalculator dollarCalculator) {
        this.iCalculator = dollarCalculator;
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/sum")
    public int get(CalculatorReq calculatorReq){
        int result = iCalculator.sum(calculatorReq.getX(), calculatorReq.getY());
        return result;
    }

    @PostMapping("/sum")
    public CalculatorRes post(@RequestBody CalculatorReq calculatorReq){
        CalculatorRes res = new CalculatorRes();
        var sum = iCalculator.sum(calculatorReq.getX(), calculatorReq.getY());
        res.setResult(sum);

        var body = new CalculatorRes.Result();
        body.setResponseResult(sum);

        res.setBody(body);
        return res;
    }

/*    @RequestMapping("/sum")
    public int mapping(@RequestBody CalculatorReq calculatorReq){
        return dollarCalculator.sum(calculatorReq.getX(), calculatorReq.getY());
    }*/
}
