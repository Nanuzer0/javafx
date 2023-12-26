package com.example.visualappfx;
public class Watch2 implements  WatchType{
    private int Hour =0 ;
    private int minute = 0;
    private int second = 0;

    public String getBrand() {
        return Brand;
    }

    public double getPrice() {
        return price;
    }

    private String Brand="";
    private double price=0;

    public Watch2(int hour, int minute, int second, String brand, double price) {
        Hour = hour%24;
        this.minute = minute%60;
        this.second = second%60;
        Brand = brand;
        this.price = price;
    }
    public Watch2() {
        Hour = 0;
        this.minute = 0;
        this.second = 0;
        Brand = "";
        this.price = 0.0;
    }
    public Watch2(int Time){
        Hour = Time/3600;
        minute = Time/60-Hour*60;
        second = Time-minute*60-Hour*3600;
    }
    public Watch2(int Time, String brand, double price){
        Hour = Time/3600;
        minute = Time/60-Hour*60;
        second = Time-minute*60-Hour*3600;
        Brand = brand;
        this.price = price;
    }

    @Override
    public String toString(){return this.Hour+":"+this.minute+":"+this.second+" "+this.Brand+ " "+this.price;}

    @Override
    public String getTime() {
        return this.Hour+":"+this.minute+":"+this.second;
    }

    @Override
    public void SetTime(int[] data) throws Exception{
        int hour = data[0];
        int minute = data[1];
        int second = data[2];
        if(0<=hour && hour<=23) Hour = hour;
        else throw new Exception("Incorrect amount");
        if(0<=minute && minute<=60) this.minute = minute;
        else throw new Exception("Incorrect amount");
        if(0<=second && second<=60) this.second = second;
        else throw new Exception("Incorrect amount");
    }

    @Override
    public void SetForward(int[] data) throws Exception{
        int hours = data[0];
        int minutes = data[1];
        int seconds = data[2];
        this.Hour = this.Hour+hours%24;
        this.minute = this.minute+minutes%60;
        this.second = this.second+seconds%60;

        if (this.second>=60) {this.minute++; this.second%=60;}
        if (this.minute>=60) {this.Hour++; this.minute%=60;}
        if (this.Hour==24) this.Hour=0;
    }

}
