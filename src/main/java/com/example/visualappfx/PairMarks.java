/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.visualappfx;

/**
 *
 * @author evgen
 */
public class PairMarks {
    String FIO;
    int mark;

    public PairMarks(String FIO, int mark) {
        this.FIO = FIO;
        this.mark = mark;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "PairMarks{" + "FIO=" + FIO + ", mark=" + mark + '}';
    }
    
}
