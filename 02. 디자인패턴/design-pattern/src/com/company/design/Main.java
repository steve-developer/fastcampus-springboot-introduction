package com.company.design;

import com.company.design.adapter.*;
import com.company.design.decorator.*;
import com.company.design.facade.SftpClient;
import com.company.design.observer.IButtonClickListener;
import com.company.design.observer.MyButton;
import com.company.design.proxy.BrowserProxy;
import com.company.design.proxy.IBroswer;
import com.company.design.singleton.AClazz;
import com.company.design.singleton.BClazz;
import com.company.design.strategy.*;

public class Main {

    public static void main(String[] args) {
	    System.out.println("main");

        HairDryer hairDryer = new HairDryer();
        connect(hairDryer);

        Cleaner cleaner = new Cleaner();
        AirConditioner airConditioner = new AirConditioner();

        //connect(cleaner);
        //connect(airConditioner);

        Electronic110V _cleaner = new SocketAdapter(cleaner);
        Electronic110V _airConditioner = new SocketAdapter(airConditioner);

        connect(_cleaner);
        connect(_airConditioner);

        AClazz a = new AClazz();
        BClazz b = new BClazz();

        System.out.println(a.getSocketClient().equals(b.getSocketClient()));

        MyButton button = new MyButton("종료 버튼");
        IButtonClickListener listener = event -> System.out.println("click event : "+event);
        button.addListener(listener);

        button.click("한번 클릭");
        button.click("두번 클릭");
        button.click("세번 클릭");

        SftpClient client = new SftpClient("www.google.com", 22, "/home/content", "content.tmp");
        client.connect();

        String content = "content";
        client.write(content);
        String result = client.read();
        System.out.println("----- 내용 : "+result+" -----");

        client.disConnect();

        Encoder base64Encoder = new Encoder();
        base64Encoder.setEncodingStrategy(new Base64Strategy());
        System.out.println(base64Encoder.getMessage("message"));

        Encoder normalEncoder = new Encoder();
        normalEncoder.setEncodingStrategy(new NormalStrategy());
        System.out.println(normalEncoder.getMessage("message"));


        IBroswer Browser = new BrowserProxy("www.naver.com");
        Browser.show();
        Browser.show();

        ICar audi = new Audi(1000);
        audi.showCost();

        ICar audi3 = new A3(audi);
        audi3.showCost();

        ICar audi4 = new A4(audi);
        audi4.showCost();

        ICar audi5 = new A5(audi);
        audi5.showCost();
    }

    public static void connect(Electronic110V electronic110V){
        electronic110V.powerOn();
    }
}
