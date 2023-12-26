package com.example.visualappfx;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;

public class pairController {
    Model m = BModel.build();
    WatchType p;

    public void setPair(WatchType p) {
        this.p = p;
        String name = p.getClass().getName();
        if (name=="com.example.visualappfx.Watch")
            seconds.setDisable(true);
        time.setText(p.getTime());
        brand.setText(p.getBrand());
        price.setText(String.valueOf(p.getPrice()));
    }

    @FXML
    Label time;
    @FXML
    Label brand;
    @FXML
    Label price;
    @FXML
    TextField hours;
    @FXML
    TextField minutes;
    @FXML
    TextField seconds;

    @FXML
    void removeMark(){
        m.removePair(p);
    }
    @FXML
    void addTime() throws Exception {
        String name = p.getClass().getName();
        if (name=="com.example.visualappfx.Watch"){
            int[] time_ = {Integer.parseInt(hours.getText()),Integer.parseInt(minutes.getText())};
            p.SetForward(time_);
            time.setText(p.getTime());
        }
        else {
            int[] time_ = {Integer.parseInt(hours.getText()),Integer.parseInt(minutes.getText()),Integer.parseInt(seconds.getText())};
            p.SetForward(time_);
            time.setText(p.getTime());
        }
    }
}
