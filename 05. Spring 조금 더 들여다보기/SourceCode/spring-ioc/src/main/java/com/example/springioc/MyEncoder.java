package com.example.springioc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MyEncoder {

    private IEncoder encoder;

    public MyEncoder(@Qualifier("urlEncoder") IEncoder iEncoder){
        this.encoder = iEncoder;
    }

    public String encode(String message){
        return encoder.encode(message);
    }
}
