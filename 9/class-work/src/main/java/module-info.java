module com.example.test {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires mysql.connector.java;

    opens com.example.test to javafx.fxml;
    exports com.example.test;
    exports com.example.test.view;
    opens com.example.test.view to javafx.fxml;
}