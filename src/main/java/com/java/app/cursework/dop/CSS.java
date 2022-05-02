package com.java.app.cursework.dop;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public  class CSS {
    public static void blueButtonEnterChange (Button button){
        button.styleProperty().set("-fx-background-color: #4F87E6");

        //-fx-background-color  #FFFFFF
        //-fx-border-radius 15
        // -fx-border-color  #BFBFBF
    }
    public static void blueButtonExitedChange (Button button){
        button.styleProperty().set("-fx-background-color: #9BBBF3");
    }
    public static void standTextField(TextField TextField){
        String str="-fx-background-color: #FFFFFF;" +
                "-fx-border-radius: 15;" +
                "-fx-border-color: #BFBFBF";
        TextField.styleProperty().set(str);
    }
    public static void errorTextField (TextField TextField){
        String str="-fx-background-color: #FF9999;" +
                "-fx-border-radius: 0;" +
                "-fx-border-color: #BFBFBF";
        TextField.styleProperty().set(str);
    }
}
