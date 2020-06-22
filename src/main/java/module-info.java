module PaintballSystem.main {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;

    opens Gui to javafx.fxml;
    exports Gui;

}
