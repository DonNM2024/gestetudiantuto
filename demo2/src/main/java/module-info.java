module com.example.demo2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jdk.jdi;
    // Ajoutez les modules pour FontAwesomeFX
    //requires de.jensd.fx.glyphs.fontawesome;
    //requires de.jensd.fx.glyphs.commons;



    opens com.example.demo2 to javafx.fxml;
    exports com.example.demo2;
}