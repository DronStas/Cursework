module com.java.app.cursework {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.java.app.cursework to javafx.fxml;
    exports com.java.app.cursework;
    exports com.java.app.cursework.dop;
    opens com.java.app.cursework.dop to javafx.fxml;
    exports com.java.PropertyProduct;
    opens com.java.PropertyProduct to javafx.fxml;
}