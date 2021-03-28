package com.company.ioc;

public class Main {

    public static void main(String[] args) {
        IEncoder base64 = new Base64Encoder();
        IEncoder urlEncoder = new UrlEncoder();

        Encoder encoder = new Encoder(urlEncoder);
        String result = encoder.encode("www.naver.com/books/it?page=10&size=100&name=spring-boot");
        System.out.println(result);
    }
}
