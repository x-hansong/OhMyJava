package com.hansong.controller;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhans on 2016/3/16.
 */
public class Controller {
    private List<Event> eventList = new ArrayList<>();
    public void addEvent(Event c){
        eventList.add(c);
    }

    public void run(){
        while (eventList.size() > 0){
            for (Event e : new ArrayList<Event>(eventList)){
                if (e.ready()){
                    System.out.println(e);
                    e.action();
                    eventList.remove(e);
                }
            }
        }
    }
}
