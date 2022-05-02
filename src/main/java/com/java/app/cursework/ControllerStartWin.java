package com.java.app.cursework;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.java.app.cursework.dop.CSS;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ControllerStartWin {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button controlButton;

    @FXML
    private Button createButton;

    @FXML
    private Button vievButton;

    @FXML
    void controlButtonClicked(MouseEvent event) {

    }

    @FXML
    void controlButtonMouseEntered(MouseEvent event) {
        CSS.blueButtonEnterChange(controlButton);
    }

    @FXML
    void controlButtonMouseExited(MouseEvent event) {
        CSS.blueButtonExitedChange(controlButton);
    }

    @FXML
    void createButtonClicked(MouseEvent event) {

        openNewScene("/createWin.fxml");
    }

    @FXML
    void createButtonMouseEntered(MouseEvent event) {
        CSS.blueButtonEnterChange(createButton);
    }

    @FXML
    void createButtonMouseExited(MouseEvent event) {
        CSS.blueButtonExitedChange(createButton);
    }

    @FXML
    void vievButtonClicked(MouseEvent event) {
        openNewScene("/enterWin.fxml");
    }

    @FXML
    void vievButtonMouseEntered(MouseEvent event) {
        CSS.blueButtonEnterChange(vievButton);
    }

    @FXML
    void vievButtonMouseExited(MouseEvent event) {
        CSS.blueButtonExitedChange(vievButton);
    }

    @FXML
    void initialize() {
        assert controlButton != null : "fx:id=\"controlButton\" was not injected: check your FXML file 'StartWin.fxml'.";
        assert createButton != null : "fx:id=\"createButton\" was not injected: check your FXML file 'StartWin.fxml'.";
        assert vievButton != null : "fx:id=\"vievButton\" was not injected: check your FXML file 'StartWin.fxml'.";

    }
    public void openNewScene(String window){
        Stage stage = (Stage) createButton.getScene().getWindow();


        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource(window));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root=loader.getRoot();
         stage=new Stage();
        stage.setScene(new Scene(root));

        stage.showAndWait();
    }

}
