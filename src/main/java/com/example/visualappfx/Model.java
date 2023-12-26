/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.visualappfx;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 *
 * @author evgen
 */
public class Model implements Iterable<WatchType> {
    ArrayList<WatchType> allPairs = new ArrayList<>();
    ArrayList<IOserver> allO = new ArrayList<>();
    
    void events(){
        allO.forEach( (o)->{o.event(this);});
    }
    
    public void sub(IOserver o)
    {
        allO.add(o);
    }
    
    public void addPair(WatchType p){
        allPairs.add(p);
        events();
    }
    
    public void removePair(WatchType p){
        allPairs.remove(p);
        events();
    }

    @Override
    public Iterator<WatchType> iterator() {
        return allPairs.iterator();
    }

    @Override
    public void forEach(Consumer<? super WatchType> action) {
        Iterable.super.forEach(action); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Spliterator<WatchType> spliterator() {
        return Iterable.super.spliterator(); //To change body of generated methods, choose Tools | Templates.
    }
}
