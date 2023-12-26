package com.example.visualappfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements IOserver, Initializable {
    Model m = BModel.build();
    public MainController(){
        m.sub(this);
    }

    @FXML
    public TextField fio;
    @FXML
    TextField mark;
    @FXML
    ChoiceBox<String> watchtype;
    @FXML
    TextField seconds;
    @FXML
    TextField hours;
    @FXML
    TextField minutes;
    @FXML
    TextField brand;
    @FXML
    TextField price;

    @FXML
    GridPane allPair;

    @FXML
    public void addMark(ActionEvent actionEvent) {
        //m.addPair(new PairMarks(fio.getText(), Integer.parseInt(mark.getText())));
        if (watchtype.getValue() == "ЧасыМинуты")
            m.addPair(WatchFactory.CreateWatch(Integer.parseInt(hours.getText())*60+Integer.parseInt(minutes.getText()), brand.getText(), Double.parseDouble(price.getText()), WatchEnum.HourMinute));
        else
            m.addPair(WatchFactory.CreateWatch(Integer.parseInt(hours.getText())*3600+Integer.parseInt(minutes.getText())*60+Integer.parseInt(seconds.getText()), brand.getText(), Double.parseDouble(price.getText()), WatchEnum.HourMinuteSecond));;
    }



    @Override
    public void event(Model m) {
        allPair.getChildren().clear();

        for (WatchType p: m) {
            try {
                pairController pc = new pairController();
                FXMLLoader fxmlLoader = new FXMLLoader(pairController.class.getResource("pairView.fxml"));
                fxmlLoader.setController(pc);
                Parent root = fxmlLoader.load();
                pc.setPair(p);
                allPair.addColumn(0, root);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
       }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[] types = {"ЧасыМинуты","ЧасыМинутыСекунды"};
        watchtype.getItems().addAll(types);
        watchtype.setValue("ЧасыМинутыСекунды");
        watchtype.setOnAction(this::ChangeType);
    }
    public void ChangeType(ActionEvent event){
        seconds.setDisable(watchtype.getValue() == "ЧасыМинуты");
    }
}
