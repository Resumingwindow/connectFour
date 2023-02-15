module com.intern.connectfour {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.intern.connectfour to javafx.fxml;
    exports com.intern.connectfour;
}