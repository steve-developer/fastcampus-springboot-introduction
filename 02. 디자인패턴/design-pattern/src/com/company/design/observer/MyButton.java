package com.company.design.observer;

public class MyButton {
    private String name;
    private IButtonClickListener buttonClickListener;

    public MyButton(String buttonName){
        this.name = buttonName;
    }

    public void click(String clickEvent){
        buttonClickListener.clickEvent(this.name+", "+clickEvent);
    }

    public void addListener(IButtonClickListener buttonClickListener){
        this.buttonClickListener = buttonClickListener;
    }
}
