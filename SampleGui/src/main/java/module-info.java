module com.ito5136.samplegui {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.ito5136.samplegui to javafx.fxml;
    exports com.ito5136.samplegui;
}