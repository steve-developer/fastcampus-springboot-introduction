package com.company.ioc;

public class Encoder {

    //private Base64Encoder base64Encoder = new Base64Encoder();
    private IEncoder encoder;

    public Encoder(IEncoder iEncoder){
        this.encoder = iEncoder;
    }

    public String encode(String message){
        return encoder.encode(message);
    }
}
