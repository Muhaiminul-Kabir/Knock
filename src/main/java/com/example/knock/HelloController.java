package com.example.knock;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import java.net.URL;
import java.time.LocalTime;
import java.util.ResourceBundle;

class RGB {
    private int r;
    private int g;
    private int b;

    public RGB(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public Color setColor() {
        return Color.rgb(r, g, b);
    }


}


public class HelloController implements Initializable {
    @FXML
    private Label welcomeText;
    @FXML
    private AnchorPane we;
    @FXML
    private TextField msg;
    @FXML
    private Button send;
    @FXML
    private ScrollPane inbox;

    RGB sender = new RGB(10, 10, 10);
    RGB receiver = new RGB(10, 10, 10);

    int i = 0;
    int v = 10;
    double h;

    @FXML
    private void sendMsg() {
        Bubble b = new Bubble(0, i, msg.getText(),
                LocalTime.now().withNano(0).toString(),
                sender.setColor());

        we.setPadding(new Insets(10));

        we.getChildren().addAll(b);
        we.setPrefHeight(h += 10);
        i += 100;
        //if ()
        System.out.println(i);

        inbox.setVvalue(1);
        msg.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        inbox.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                System.out.println(inbox.getVvalue());
            }
            if (e.getCode() == KeyCode.LEFT) {
                double ik = inbox.getVvalue();
                ik += 0.1;
                inbox.setVvalue(ik);

            }
        });
        h = we.getPrefHeight();
        v = (int) (we.getPrefWidth() / 2);
    }
}