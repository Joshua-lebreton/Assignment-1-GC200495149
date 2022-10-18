package com.example.assignment1gc200495149;

import javafx.scene.chart.XYChart;

import java.sql.*;
import java.util.ArrayList;


public class DBUtility {
    private static String user = "Josh200495149"; //MySQL server username
    private static String pw = "UrSwAXxnHK";
    private static String connectUrl = "jdbc:mysql://172.31.22.43:3306/Josh200495149";




    public static ArrayList<Workout> getWorkoutDataFromDB()
    {
        ArrayList<Workout> workouts = new ArrayList<>();

        String sql =    "SELECT Workout_Name, Exercise_Name, Weight, Reps " +
                        "FROM weightliftingData " +
                        "ORDER BY Workout_Name;";


        try(
                Connection conn = DriverManager.getConnection(connectUrl,user,pw);

                Statement statement = conn.createStatement();

                ResultSet dbResults = statement.executeQuery(sql);
        )
        {
            //4.  loop over the resultSet
            while (dbResults.next())
            {
                String workoutName = dbResults.getString("Workout_Name");
                String exerciseName = dbResults.getString("Exercise_Name");
                double weight = dbResults.getDouble("Weight");
                int reps = dbResults.getInt("Reps");


                Workout newWorkout = new Workout(workoutName, exerciseName, weight, reps);
                workouts.add(newWorkout);

            }
            System.out.println(workouts.toString());
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return workouts;
    }

    public static XYChart.Series<String,Integer> getWeightSummary()
    {
        XYChart.Series<String, Integer> exercisesCompleted = new XYChart.Series<>();

        String sql = "SELECT Exercise_Name  , COUNT(Exercise_Name) as TimesExerciseCompleted " +
                "FROM weightliftingData " +
                "GROUP BY  Exercise_Name " +
                "ORDER BY TimesExerciseCompleted DESC;";

        try(
                Connection conn = DriverManager.getConnection(connectUrl,user,pw);

                Statement statement = conn.createStatement();

                ResultSet resultSet = statement.executeQuery(sql);
        )
        {
            while (resultSet.next())
            {
                String topping = resultSet.getString("Exercise_Name");
                int numOfOrders = resultSet.getInt("TimesExerciseCompleted");
                exercisesCompleted.getData().add(new XYChart.Data<>(topping,numOfOrders));
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return exercisesCompleted;
    }
}
