package com.hansong.controller;

/**
 * Created by xhans on 2016/3/16.
 */
public class GreenhouseController {
    public static void main(String[] args){
        GreenhouseControls gc = new GreenhouseControls();

        gc.addEvent(gc.new Bell(900));
        Event[] eventList = {
                gc.new LightOn(200),
                gc.new LightOff(400),
                gc.new WaterOn(600),
                gc.new WaterOff(800),
                new GreenhouseControls.Terminate(1000)
        };

        gc.addEvent(gc.new Restart(2000, eventList));

        if (args.length == 1){
            gc.addEvent(new GreenhouseControls.Terminate(
                    new Integer(args[0])
            ));
        }

        gc.run();
    }
}
