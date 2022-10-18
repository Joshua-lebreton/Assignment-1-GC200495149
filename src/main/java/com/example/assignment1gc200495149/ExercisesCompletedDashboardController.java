package com.example.assignment1gc200495149;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class ExercisesCompletedDashboardController implements Initializable {

    @FXML
    private Button changeViewButton;

    @FXML
    private BarChart<String, Integer> exerciseBarChart;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        exerciseBarChart.getData().addAll(DBUtility.getExercisesCompleted());
        exerciseBarChart.setLegendVisible(false);
    }
}

