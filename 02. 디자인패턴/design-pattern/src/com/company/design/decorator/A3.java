package com.company.design.decorator;

public class A3 extends AudiModelDecorator {

    public A3(ICar audi) {
        super(audi);
        this.modelPrice = 1000;
    }
}
