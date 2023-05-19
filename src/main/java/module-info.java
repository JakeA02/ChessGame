module com.example.chessgame {
    requires javafx.controls;
    requires javafx.fxml;
        requires javafx.web;
            
        requires org.controlsfx.controls;
                    requires org.kordamp.ikonli.javafx;
            requires com.almasb.fxgl.all;
    requires com.google.common;

    opens com.example.chessgame to javafx.fxml;
    exports com.example.chessgame;
}