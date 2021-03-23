package com.company.design.adapter;

public class HairDryer implements Electronic110V {
    @Override
    public void powerOn() {
        System.out.println("110v 헤어드라이기 ON");
    }
}
