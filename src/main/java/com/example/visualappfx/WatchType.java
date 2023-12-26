package com.example.visualappfx;
public interface WatchType {
    double getPrice();
    String getBrand();
    String toString();

    String getTime();
    public void SetTime(int[] data) throws Exception;
    public void SetForward(int[] data) throws Exception;
}
