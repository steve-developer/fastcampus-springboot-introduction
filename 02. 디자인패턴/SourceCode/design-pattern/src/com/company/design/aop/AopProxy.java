package com.company.design.aop;

import com.company.design.proxy.Html;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class AopProxy implements IAopBrowser {

    private String url;
    private Html html;
    private Runnable before;
    private Runnable after;

    public AopProxy(String url){
        this.url = url;
    }

    public AopProxy(String url, Runnable before,  Runnable after) {
        this.url = url;
        this.before = before;
        this.after = after;
    }

    @Override
    public Html show() throws InterruptedException {
        after.run();

        if(html == null){
            this.html = new Html(url);
            System.out.println("BrowserProxy loading html from "+url);
        }
        System.out.println("BrowserProxy use cache html");
        Thread.sleep(2000);
        before.run();
        return html;
    }
}
