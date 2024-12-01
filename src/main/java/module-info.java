module com.poo.volumtarium {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    exports com.poo.volumtarium;
    exports com.poo.volumtarium.controllers;

    opens com.poo.volumtarium to javafx.fxml;
    opens com.poo.volumtarium.controllers to javafx.fxml;
}
