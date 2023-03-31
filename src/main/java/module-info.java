module com.jhp.pwgenerator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.jhp.pwgenerator to javafx.fxml;
    exports com.jhp.pwgenerator;
}