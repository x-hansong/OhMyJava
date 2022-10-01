package com.hansong.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * Created by xhans on 2016/5/23 0023.
 */
@WebService
public class HelloOrigin {

    @WebMethod
    public String hello(String name){
        return "Hello, " + name;
    }

    public static void main(String[] args){
        HelloOrigin hello = new HelloOrigin();
        Endpoint.publish("http://localhost:8080/hello", hello);
    }
}
