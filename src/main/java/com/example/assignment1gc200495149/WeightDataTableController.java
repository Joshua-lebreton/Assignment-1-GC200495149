package com.example.assignment1gc200495149;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class WeightDataTableController implements Initializable {

    @FXML
    private Button ChangeViewButton;

    @FXML
    private TableColumn<?, ?> ExerciseNameColumn;

    @FXML
    private TableColumn<?, ?> RepsColumn;

    @FXML
    private TableView<?> TableView;

    @FXML
    private TableColumn<?, ?> WeightColumn;

    @FXML
    private TableColumn<?, ?> WeightNameColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

