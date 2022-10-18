package com.example.assignment1gc200495149;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WeightDataTableController implements Initializable {

    @FXML
    private Button changeViewButton;

    @FXML
    private TableColumn<Workout, String> exerciseNameColumn;

    @FXML
    private TableColumn<Workout, Integer> repsColumn;

    @FXML
    private TableView<Workout> tableView;

    @FXML
    private TableColumn<Workout, Double> weightColumn;

    @FXML
    private TableColumn<Workout, String> workoutNameColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        workoutNameColumn.setCellValueFactory(new PropertyValueFactory<>("workoutName"));
        exerciseNameColumn.setCellValueFactory(new PropertyValueFactory<>("exerciseName"));
        weightColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));
        repsColumn.setCellValueFactory(new PropertyValueFactory<>("reps"));
        tableView.getItems().addAll(DBUtility.getWorkoutDataFromDB());
    }

    @FXML
    private void viewDashboard(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event,"exercises-completed-dashboard-view.fxml");
    }
}

