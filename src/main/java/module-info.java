module taschenrechner.taschenrechner {
    requires javafx.controls;
    requires javafx.fxml;


    opens taschenrechner.taschenrechner to javafx.fxml;
    exports taschenrechner.taschenrechner;
}