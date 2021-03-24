package com.company.design.adapter;

public class Cleaner implements Electronic220V{
    @Override
    public void connect() {
        System.out.println("220v 청소기 ON");
    }
}
