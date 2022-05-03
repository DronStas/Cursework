package com.java.app.cursework;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.java.PropertyProduct.FruitProperty;
import com.java.PropertyProduct.OversizeProperty;
import com.java.PropertyProduct.ToyProperty;
import com.java.app.cursework.dop.CSS;
import com.java.app.cursework.dop.TextChoiceBox;
import com.java.dataBase.DataBaseHandler;
import com.java.product.Fruit;
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

    @FXML
    private TableColumn<FruitProperty, String> countryFruitsCol;

    @FXML
    private TableColumn<OversizeProperty, String> countryOverCol;

    @FXML
    private TableColumn<ToyProperty, String> countryToyCol;

    @FXML
    private TableColumn<FruitProperty, String> departmentNameFruitsCol;

    @FXML
    private TableColumn<OversizeProperty, String> departmentNameOverCol;

    @FXML
    private TableColumn<ToyProperty, String> departmentNameToyCol;

    @FXML
    private Button exitButton;

    @FXML
    private AnchorPane fruitsAnchorPane;

    @FXML
    private TableView<FruitProperty> fruitsTV;

    @FXML
    private TableColumn<OversizeProperty, Double> heightOverCol;

    @FXML
    private TableColumn<OversizeProperty, Double> lengthOverCol;

    @FXML
    private AnchorPane oversizeAnchorPane;

    @FXML
    private TableView<OversizeProperty> oversizeTV;

    @FXML
    private TableColumn<FruitProperty, Double> priceFruitsCol;

    @FXML
    private TableColumn<OversizeProperty, Double> priceOverCol;

    @FXML
    private TableColumn<ToyProperty, Double> priceToyCol;

    @FXML
    private TableColumn<FruitProperty, String> productNameFruitsCol;

    @FXML
    private TableColumn<OversizeProperty, String> productNameOverCol;

    @FXML
    private TableColumn<ToyProperty, String> productNameToyCol;

    @FXML
    private TableColumn<FruitProperty, Double> temperatureFruitsCol;

    @FXML
    private TableColumn<FruitProperty, Integer> timeFruitsCol;

    @FXML
    private AnchorPane toyAnchorPane;

    @FXML
    private TableView<ToyProperty> toyTV;

    @FXML
    private ChoiceBox<String> typeChoiceBox;

    @FXML
    private TableColumn<ToyProperty, String> typeTouCol;

    @FXML
    private TableColumn<OversizeProperty, Double> widthOverCol;
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
        countryFruitsCol.setCellValueFactory(new PropertyValueFactory<>("Country"));
        countryOverCol.setCellValueFactory(new PropertyValueFactory<>("Country"));
        countryToyCol.setCellValueFactory(new PropertyValueFactory<>("Country"));
       departmentNameFruitsCol.setCellValueFactory(new PropertyValueFactory<>("DepartmentName"));
       departmentNameOverCol.setCellValueFactory(new PropertyValueFactory<>("DepartmentName"));
        departmentNameToyCol.setCellValueFactory(new PropertyValueFactory<>("DepartmentName"));
        heightOverCol.setCellValueFactory(new PropertyValueFactory<>("Height"));
        lengthOverCol.setCellValueFactory(new PropertyValueFactory<>("Length"));
        priceFruitsCol.setCellValueFactory(new PropertyValueFactory<>("Price"));
        priceOverCol.setCellValueFactory(new PropertyValueFactory<>("Price"));
        priceToyCol.setCellValueFactory(new PropertyValueFactory<>("Price"));
        productNameFruitsCol.setCellValueFactory(new PropertyValueFactory<>("ProductName"));
        productNameOverCol.setCellValueFactory(new PropertyValueFactory<>("ProductName"));
        productNameToyCol.setCellValueFactory(new PropertyValueFactory<>("ProductName"));
        temperatureFruitsCol.setCellValueFactory(new PropertyValueFactory<>("Temperature"));
        timeFruitsCol.setCellValueFactory(new PropertyValueFactory<>("Time"));
        typeTouCol.setCellValueFactory(new PropertyValueFactory<>("Type"));
        widthOverCol.setCellValueFactory(new PropertyValueFactory<>("Width"));

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
            try {
                enterFruitTV();
            } catch (SQLException e) {
                System.out.println("Dont enter fruits(!!!");
                e.printStackTrace();
            }
            return;
        }
        if(str.equals("Габарритный товар")){
            oversizeAnchorPane.setVisible(true);
            try {
                enterOversizeTV();
            } catch (SQLException e) {
                System.out.println("Dont enter oversizes(!!!");
                e.printStackTrace();
            }
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
    private void enterFruitTV() throws SQLException {
        DataBaseHandler db= new DataBaseHandler();
        ResultSet resultSet=db.getFruits();
        ArrayList<FruitProperty> arrayList=new ArrayList<FruitProperty>();

        if(resultSet==null)
            return;
        int columns=resultSet.getMetaData().getColumnCount();
        while(resultSet.next()){
            var toy=new FruitProperty(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDouble(4),
                    resultSet.getInt(5),
                    resultSet.getDouble(6)
            );
            arrayList.add(toy);
        }
        ObservableList<FruitProperty> observableList=FXCollections.observableList(arrayList);
        fruitsTV.setItems(observableList);

    }

    private void enterOversizeTV() throws SQLException {
        DataBaseHandler db= new DataBaseHandler();
        ResultSet resultSet=db.getOversizes();
        ArrayList<OversizeProperty> arrayList=new ArrayList<OversizeProperty>();

        if(resultSet==null)
            return;
        int columns=resultSet.getMetaData().getColumnCount();
        while(resultSet.next()){
            var toy=new OversizeProperty(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDouble(4),
                    resultSet.getDouble(5),
                    resultSet.getDouble(6),
                    resultSet.getDouble(7)
            );
            arrayList.add(toy);
        }
        ObservableList<OversizeProperty> observableList=FXCollections.observableList(arrayList);
        oversizeTV.setItems(observableList);

    }
}
