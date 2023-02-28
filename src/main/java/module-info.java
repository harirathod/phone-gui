module com.phone.phonegui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.phone.phonegui to javafx.fxml;
    exports com.phone.phonegui;
}