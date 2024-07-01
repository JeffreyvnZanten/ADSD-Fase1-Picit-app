module org.picit.hellopicit {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens org.picit.hellopicit to javafx.fxml;
    exports org.picit.hellopicit;
}