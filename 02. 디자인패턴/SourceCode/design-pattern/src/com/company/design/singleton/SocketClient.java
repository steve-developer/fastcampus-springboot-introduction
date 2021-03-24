package com.company.design.singleton;

public class SocketClient {

    private static SocketClient socketClient = null;

    // default 생성자 막기
    private SocketClient(){}

    public static SocketClient getInstance(){

        if(socketClient == null){
            socketClient = new SocketClient();
            System.out.println("socket new instance");
        }

        return socketClient;
    }

    public void connect(){
        System.out.println("socket");
    }

}
