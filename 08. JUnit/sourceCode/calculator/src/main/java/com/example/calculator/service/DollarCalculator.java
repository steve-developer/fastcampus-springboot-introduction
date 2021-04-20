package com.example.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class DollarCalculator implements ICalculator {
    private int market = 100;
    private final MarketServer marketServer;

    public DollarCalculator(MarketServer marketServer) {
        this.marketServer = marketServer;
    }

    @Override
    public int sum(int x, int y) {
        x *= marketServer.price();
        y *= marketServer.price();
        return x + y;
    }

    @Override
    public int minus(int x, int y) {
        x *= marketServer.price();
        y *= marketServer.price();
        return x - y;
    }

    @Override
    public int multiply(int x, int y) {
        x *= marketServer.price();
        y *= marketServer.price();
        return x * y;
    }

    @Override
    public int division(int x, int y) {
        x *= marketServer.price();
        y *= marketServer.price();
        return x / y;
    }
}
