package com.example.springioc;

public class Encoder {

    private IEncoder encoder;

    public Encoder(IEncoder iEncoder){
        this.encoder = iEncoder;
    }

    public String encode(String message){
        return encoder.encode(message);
    }
}
