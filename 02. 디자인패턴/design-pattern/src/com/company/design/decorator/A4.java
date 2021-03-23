package com.company.design.decorator;

public class A4 extends AudiModelDecorator {
    public A4(ICar audi) {
        super(audi);
        this.modelPrice = 2000;
    }
}
