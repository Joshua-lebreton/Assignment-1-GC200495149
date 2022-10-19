module com.example.assignment1gc200495149 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.assignment1gc200495149 to javafx.fxml;
    exports com.example.assignment1gc200495149;
    exports com.example.Controllers;
    opens com.example.Controllers to javafx.fxml;
}