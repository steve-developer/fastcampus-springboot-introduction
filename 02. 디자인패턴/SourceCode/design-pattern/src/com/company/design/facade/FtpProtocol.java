package com.company.design.facade;

public class FtpProtocol {

    public FtpProtocol(String host, int port, String path){
        System.out.println("ftp server create");
    }


    public void connect(){
        System.out.println("ftp server connected");
    }

    public void moveDirectory(){
        System.out.println("move path");
    }

    public void disConnect(){
        System.out.println("ftp server disConnected");
    }
}
