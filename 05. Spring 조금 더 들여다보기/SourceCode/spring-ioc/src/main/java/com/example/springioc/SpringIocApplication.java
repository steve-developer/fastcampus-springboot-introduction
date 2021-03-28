package com.example.springioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationContextFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class SpringIocApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringIocApplication.class, args);
        ApplicationContext context = ApplicationContextProvider.getContext();
        MyEncoder myEncoder = context.getBean(MyEncoder.class);
        //Encoder base64Encoder = context.getBean("base64Encode", Encoder.class);
        //Encoder urlEncoder = context.getBean("urlEncode", Encoder.class);
        String result = myEncoder.encode("www.naver.com/books/it?page=10&size=100&name=spring-boot");
        System.out.println(result);
    }
}

@Configuration
class AppConfig{

    @Bean("base64Encode")
    public Encoder encoder(Base64Encoder base64Encoder){
        Encoder encoder = new Encoder(base64Encoder);
        return encoder;
    }


    @Bean("urlEncode")
    public Encoder encoder(UrlEncoder urlEncoder){
        Encoder encoder = new Encoder(urlEncoder);
        return encoder;
    }



}