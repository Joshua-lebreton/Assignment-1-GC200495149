package com.example.assignment1gc200495149;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ExercisesCompletedDashboardController implements Initializable {

    @FXML
    private Button changeViewButton;

    @FXML
    private BarChart<String, Integer> exerciseBarChart;

    @FXML
    private TextArea legendTextArea;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        exerciseBarChart.getData().addAll(DBUtility.getExercisesCompleted());
        exerciseBarChart.setLegendVisible(false);
        ArrayList<String> namesArray = DBUtility.getExerciseName();
        String names = "Legend(In order left to right): \n\n";
        for (String name: namesArray) {
            names = names + name + "\n";
        }
        legendTextArea.setText(names);
    }

    @FXML
    private void viewTable(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event,"weight-data-table-view.fxml");
    }
}

