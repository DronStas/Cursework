package com.java.app.cursework;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.java.app.cursework.dop.CSS;
import com.java.app.cursework.dop.TextChoiceBox;
import com.java.product.Fruit;
import com.java.product.Oversize;
import com.java.product.Supermarket;
import com.java.product.Toy;
import com.java.dataBase.DataBaseHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControllerCreateWin {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField ageToysTextField;

    @FXML
    private ChoiceBox<String> countryChoiceBox;

    @FXML
    private TextField departmentNameTextField;

    @FXML
    private AnchorPane fruitsAnchorPane;

    @FXML
    private TextField heightOversizeTextField;

    @FXML
    private TextField lengthOversizeTextField;

    @FXML
    private AnchorPane oversizeAnchorPane;

    @FXML
    private TextField priceTextField;

    @FXML
    private TextField productNameTextField;

    @FXML
    private TextField temperSaveFruits;

    @FXML
    private TextField timeSaveFruits;

    @FXML
    private AnchorPane toyAnchorPane;

    @FXML
    private ChoiceBox<String> typeChoiceBox;

    @FXML
    private TextField typeToysTextField;

    @FXML
    private TextField widthOversizeTextField;
    @FXML
    private Button exitButton;
    @FXML
    private Button createButton;

    @FXML
    void createButtonClicked(MouseEvent event) {
        boolean isNormalInfo = true;
        String departmentName = departmentNameTextField.getText();
        if (departmentName.equals("")) {
            CSS.errorTextField(departmentNameTextField);
            isNormalInfo = false;
        }

        String productName = productNameTextField.getText();
        if (productName.equals("")) {
            CSS.errorTextField(productNameTextField);
            isNormalInfo = false;
        }

        String country = countryChoiceBox.getValue();

        String priceStr = priceTextField.getText();
        double price = 0;
        try {
            price = Double.parseDouble(priceStr);
        } catch (Exception e) {
            isNormalInfo = false;
            CSS.errorTextField(priceTextField);
        }

        String typeChoiceBoxText = typeChoiceBox.getValue();
        Supermarket product = new Supermarket(departmentName, productName, country, price);

        Toy productToy = null;
        Fruit productFruit = null;
        Oversize productOversize = null;

        int ageGroup = 0;
        String type;
        if (typeChoiceBoxText.equals("Игрушка")) {
            String ageGroupStr = ageToysTextField.getText();
            try {
                ageGroup = Integer.parseInt(ageGroupStr);
                if (ageGroup <= 0 || ageGroup >= 150) {
                    isNormalInfo = false;
                    CSS.errorTextField(ageToysTextField);
                }
            } catch (Exception e) {
                isNormalInfo = false;
                CSS.errorTextField(ageToysTextField);
            }
            type = typeToysTextField.getText();
            if (type.equals("")) {
                CSS.errorTextField(typeToysTextField);
                isNormalInfo = false;
            }
            if (isNormalInfo) {
                productToy = new Toy(product, ageGroup, type);
            }

        }

        int time = 0;
        double temperature = 0;
        if (typeChoiceBoxText.equals("Фрукт")) {
            String timeStr = timeSaveFruits.getText();
            try {
                time = Integer.parseInt(timeStr);
                if (time <= 0) {
                    isNormalInfo = false;
                    CSS.errorTextField(timeSaveFruits);
                }
            } catch (Exception e) {
                isNormalInfo = false;
                CSS.errorTextField(timeSaveFruits);
            }
            String temperatureStr = temperSaveFruits.getText();
            try {
                temperature = Integer.parseInt(temperatureStr);

            } catch (Exception e) {
                isNormalInfo = false;
                CSS.errorTextField(temperSaveFruits);
            }
            if (isNormalInfo) {
                productFruit = new Fruit(product, time, temperature);
            }
        }


        double height = 0;
        double width = 0;
        double length = 0;
        if (typeChoiceBoxText.equals("Габарритный товар")) {
            String heightStr = heightOversizeTextField.getText();
            try {
                height = Double.parseDouble(heightStr);
                if (height <= 0) {
                    isNormalInfo = false;
                    CSS.errorTextField(heightOversizeTextField);
                }
            } catch (Exception e) {
                isNormalInfo = false;
                CSS.errorTextField(heightOversizeTextField);
            }
            String widthtStr = widthOversizeTextField.getText();
            try {
                width = Double.parseDouble(widthtStr);
                if (width <= 0) {
                    isNormalInfo = false;
                    CSS.errorTextField(widthOversizeTextField);
                }
            } catch (Exception e) {
                isNormalInfo = false;
                CSS.errorTextField(widthOversizeTextField);
            }
            String lengthStr = lengthOversizeTextField.getText();
            try {
                length = Double.parseDouble(lengthStr);
                if (length <= 0) {
                    isNormalInfo = false;
                    CSS.errorTextField(lengthOversizeTextField);
                }
            } catch (Exception e) {
                isNormalInfo = false;
                CSS.errorTextField(lengthOversizeTextField);
            }
            if (isNormalInfo) {
                productOversize = new Oversize(product, height, width, length);
            }

        }

        if (isNormalInfo) {
            System.out.println("product created");
            System.out.println(product.toString());
        } else {
            System.out.println("product not created");
            return;
        }
        DataBaseHandler dbHandler = new DataBaseHandler();

        if (typeChoiceBoxText.equals("Игрушка")) {
            dbHandler.setDB(productToy);
        }

        if (typeChoiceBoxText.equals("Фрукт")) {
            dbHandler.setDB(productFruit);
        }

        if (typeChoiceBoxText.equals("Габарритный товар")) {
            dbHandler.setDB(productOversize);
        }
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
    void exitButtonClicked(MouseEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void exitButtonMouseEntered(MouseEvent event) {
        CSS.blueButtonEnterChange(exitButton);
    }

    @FXML
    void exitButtonMouseExited(MouseEvent event) {
        CSS.blueButtonExitedChange(exitButton);
    }

    @FXML
    void heightOversizeTextFieldClicked(MouseEvent event) {
        CSS.standTextField(heightOversizeTextField);
    }

    @FXML
    void lengthOversizeTextFieldClicked(MouseEvent event) {
        CSS.standTextField(lengthOversizeTextField);
    }

    @FXML
    void priceTextFieldClicked(MouseEvent event) {
        CSS.standTextField(priceTextField);
    }

    @FXML
    void productNameTextFieldClicked(MouseEvent event) {
        CSS.standTextField(productNameTextField);
    }

    @FXML
    void temperSaveFruitsClicked(MouseEvent event) {
        CSS.standTextField(temperSaveFruits);
    }

    @FXML
    void timeSaveFruitsClicked(MouseEvent event) {
        CSS.standTextField(timeSaveFruits);
    }

    @FXML
    void typeToysTextFieldClicked(MouseEvent event) {
        CSS.standTextField(typeToysTextField);
    }

    @FXML
    void widthOversizeTextFieldClicked(MouseEvent event) {
        CSS.standTextField(widthOversizeTextField);
    }

    @FXML
    void ageToysTextFieldClicked(MouseEvent event) {
        CSS.standTextField(ageToysTextField);
    }

    @FXML
    void departmentNameTextFieldClicked(MouseEvent event) {
        CSS.standTextField(departmentNameTextField);
    }

    @FXML
    void initialize() {
        countryChoiceBox.setStyle("-fx-font-family: System; -fx-font-size:24");
        countryChoiceBox.getItems().addAll(TextChoiceBox.countries);
        countryChoiceBox.setValue("Россия");

        typeChoiceBox.setStyle("-fx-font-family: System; -fx-font-size:24");
        typeChoiceBox.getItems().addAll(TextChoiceBox.type);
        typeChoiceBox.setValue("Игрушка");

        toyAnchorPane.setVisible(true);

        typeChoiceBox.setOnAction(this::anchorControl);
    }

    private void anchorControl(ActionEvent event) {
        toyAnchorPane.setVisible(false);
        fruitsAnchorPane.setVisible(false);
        oversizeAnchorPane.setVisible(false);
        String str = typeChoiceBox.getValue();
        if (str.equals("Игрушка")) {
            toyAnchorPane.setVisible(true);
        }
        if (str.equals("Фрукт")) {
            fruitsAnchorPane.setVisible(true);
        }
        if (str.equals("Габарритный товар")) {
            oversizeAnchorPane.setVisible(true);
        }
    }

    private void openNewScene(String window) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        stage = new Stage();
        stage.setScene(new Scene(root));

        stage.showAndWait();
    }

}
