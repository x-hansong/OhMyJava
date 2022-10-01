package com.hansong.webservice;

/**
 * Created by xhans on 2016/5/23 0023.
 */
public class HelloClient {
    public static void main(String[] args){
        HelloService service = new HelloService();
        Hello helloProxy = service.getHelloPort();
        System.out.println(helloProxy.hello("你好"));
    }

}
