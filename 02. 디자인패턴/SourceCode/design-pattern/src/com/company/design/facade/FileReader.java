package com.company.design.facade;

public class FileReader {

    public FileReader(String fileName){

    }

    public void fileConnect(){
        System.out.println("FileReader Connected");
    }

    public String fileRead(){
        return "content";
    }

    public void fileDisconnect(){
        System.out.println("FileReader disConnected");
    }
}
