package com.company.design.strategy;

public class NormalStrategy implements EncodingStrategy{
    @Override
    public String encoding(String message) {
        return message;
    }
}
