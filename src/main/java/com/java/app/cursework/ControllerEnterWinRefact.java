package com.java.app.cursework;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.java.app.cursework.dop.CSS;
import com.java.app.cursework.dop.TextChoiceBox;
import com.java.dataBase.DataBaseHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControllerEnterWinRefact {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<ToyProperty, Integer> ageGroupToyCol;

//    @FXML
//    private TableColumn<Fruit, String> countryFruitsCol;

//    @FXML
//    private TableColumn<Oversize, String> countryOverCol;

    @FXML
    private TableColumn<ToyProperty, String> countryToyCol;

//    @FXML
//    private TableColumn<Fruit, String> departmentNameFruitsCol;

//    @FXML
//    private TableColumn<Oversize, String> departmentNameOverCol;

    @FXML
    private TableColumn<ToyProperty, String> departmentNameToyCol;

    @FXML
    private Button exitButton;

    @FXML
    private AnchorPane fruitsAnchorPane;

//    @FXML
//    private TableView<Fruit> fruitsTV;

//    @FXML
//    private TableColumn<Oversize, Double> heightOverCol;

//    @FXML
//    private TableColumn<Oversize, Double> lengthOverCol;

    @FXML
    private AnchorPane oversizeAnchorPane;

//    @FXML
//    private TableView<Oversize> oversizeTV;

//    @FXML
//    private TableColumn<Fruit, Double> priceFruitsCol;

//    @FXML
//    private TableColumn<Oversize, Double> priceOverCol;

    @FXML
    private TableColumn<ToyProperty, Double> priceToyCol;

//    @FXML
//    private TableColumn<Fruit, String> productNameFruitsCol;

//    @FXML
//    private TableColumn<Oversize, String> productNameOverCol;

    @FXML
    private TableColumn<ToyProperty, String> productNameToyCol;

//    @FXML
//    private TableColumn<Fruit, Double> temperatureFruitsCol;

//    @FXML
//    private TableColumn<Fruit, Integer> timeFruitsCol;

    @FXML
    private AnchorPane toyAnchorPane;

    @FXML
    private TableView<ToyProperty> toyTV;

    @FXML
    private ChoiceBox<String> typeChoiceBox;

    @FXML
    private TableColumn<ToyProperty, String> typeTouCol;

//    @FXML
//    private TableColumn<Oversize, Double> widthOverCol;
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
    void initialize() {
        ageGroupToyCol.setCellValueFactory(new PropertyValueFactory<>("AgeGroup"));
//        countryFruitsCol.setCellValueFactory(new PropertyValueFactory<>("countryFruitsCol"));
//        countryOverCol.setCellValueFactory(new PropertyValueFactory<>("countryOverCol"));
        countryToyCol.setCellValueFactory(new PropertyValueFactory<>("Country"));
//        departmentNameFruitsCol.setCellValueFactory(new PropertyValueFactory<>("departmentNameFruitsCol"));
//        departmentNameOverCol.setCellValueFactory(new PropertyValueFactory<>("departmentNameOverCol"));
        departmentNameToyCol.setCellValueFactory(new PropertyValueFactory<>("DepartmentName"));
//        heightOverCol.setCellValueFactory(new PropertyValueFactory<>("heightOverCol"));
//        lengthOverCol.setCellValueFactory(new PropertyValueFactory<>("lengthOverCol"));
//        priceFruitsCol.setCellValueFactory(new PropertyValueFactory<>("priceFruitsCol"));
//        priceOverCol.setCellValueFactory(new PropertyValueFactory<>("priceOverCol"));
        priceToyCol.setCellValueFactory(new PropertyValueFactory<>("Price"));
//        productNameFruitsCol.setCellValueFactory(new PropertyValueFactory<>("productNameFruitsCol"));
//        productNameOverCol.setCellValueFactory(new PropertyValueFactory<>("productNameOverCol"));
        productNameToyCol.setCellValueFactory(new PropertyValueFactory<>("ProductName"));
//        temperatureFruitsCol.setCellValueFactory(new PropertyValueFactory<>("temperatureFruitsCol"));
//        timeFruitsCol.setCellValueFactory(new PropertyValueFactory<>("timeFruitsCol"));
        typeTouCol.setCellValueFactory(new PropertyValueFactory<>("Type"));
//        widthOverCol.setCellValueFactory(new PropertyValueFactory<>("widthOverCol"));

        typeChoiceBox.setStyle("-fx-font-family: System; -fx-font-size:24");
        typeChoiceBox.getItems().addAll(TextChoiceBox.type);
        typeChoiceBox.setValue("Игрушка");
        toyAnchorPane.setVisible(true);
        try {
            enterToyTV();
        } catch (SQLException e) {
            System.out.println("Dont enter toys(!!!");
            e.printStackTrace();
        }

        typeChoiceBox.setOnAction(this::anchorControl);


    }
    private void anchorControl(ActionEvent event) {
        toyAnchorPane.setVisible(false);
        fruitsAnchorPane.setVisible(false);
        oversizeAnchorPane.setVisible(false);
        String str=typeChoiceBox.getValue();
        if(str.equals("Игрушка")){

            toyAnchorPane.setVisible(true);
            try {
                enterToyTV();
            } catch (SQLException e) {
                System.out.println("Dont enter toys(!!!");
                e.printStackTrace();
            }
            return;
        }
        if(str.equals("Фрукт")){
            fruitsAnchorPane.setVisible(true);
            return;
        }
        if(str.equals("Габарритный товар")){
            oversizeAnchorPane.setVisible(true);
            return;
        }
    }
    private void enterToyTV() throws SQLException {
        DataBaseHandler db= new DataBaseHandler();
        ResultSet resultSet=db.getToys();
        ArrayList<ToyProperty> arrayList=new ArrayList<ToyProperty>();

        if(resultSet==null)
            return;
        int columns=resultSet.getMetaData().getColumnCount();
        while(resultSet.next()){
            var toy=new ToyProperty(
                  resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDouble(4),
                    resultSet.getInt(5),
                    resultSet.getString(6)
            );
            arrayList.add(toy);
        }
        ObservableList<ToyProperty> observableList=FXCollections.observableList(arrayList);
        toyTV.setItems(observableList);

    }
}
