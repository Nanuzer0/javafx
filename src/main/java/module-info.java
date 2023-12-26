module com.example.visualappfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.example.visualappfx to javafx.fxml;
    exports com.example.visualappfx;
}