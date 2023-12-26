package com.example.visualappfx;
public class WatchFactory {
    static public WatchType CreateWatch(int time, String brand, double price, WatchEnum type){
        WatchType watch = null;

        switch (type){
            case HourMinute:
                watch = new Watch(time,brand,price);
                break;
            case HourMinuteSecond:
                watch = new Watch2(time,brand,price);
                break;
        }
        return watch;
    }
}
