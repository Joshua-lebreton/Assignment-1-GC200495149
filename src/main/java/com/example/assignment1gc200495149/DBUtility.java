package com.example.assignment1gc200495149;

import javafx.scene.chart.XYChart;

import java.sql.*;
import java.util.ArrayList;

/** Utility class that gets ResultSets from MySql
 * @author Joshua Lebreton
 * Data set from https://www.kaggle.com/datasets/joep89/weightlifting?resource=download
 */
public class DBUtility {
    private static String user = "Josh200495149";
    private static String pw = "UrSwAXxnHK";
    private static String connectUrl = "jdbc:mysql://172.31.22.43:3306/Josh200495149";

    /**
     * Gets Workout Names, Exercise Names, Weight and Reps from weightliftingData Ordered by Workout Name
     * @return ArrayList of Workout type
     * @throws Exception for if call to database fails
     */
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

            while (dbResults.next())
            {
                String workoutName = dbResults.getString("Workout_Name");
                String exerciseName = dbResults.getString("Exercise_Name");
                double weight = dbResults.getDouble("Weight");
                int reps = dbResults.getInt("Reps");


                Workout newWorkout = new Workout(workoutName, exerciseName, weight, reps);
                workouts.add(newWorkout);

            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return workouts;
    }

    /**
     * Gets the top 10 Exercise Names and the number of times each Exercise was recorded as TimesExerciseCompleted from weightliftingData Ordered by TimesExerciseCompleted
     * @return XYChart
     */
    public static XYChart.Series<String,Integer> getExercisesCompleted()
    {
        XYChart.Series<String, Integer> exercisesCompleted = new XYChart.Series<>();

        String sql = "SELECT Exercise_Name, COUNT(Exercise_Name) as TimesExerciseCompleted " +
                "FROM weightliftingData " +
                "GROUP BY  Exercise_Name " +
                "ORDER BY TimesExerciseCompleted DESC " +
                "LIMIT 10;";

        try(
                Connection conn = DriverManager.getConnection(connectUrl,user,pw);

                Statement statement = conn.createStatement();

                ResultSet dbResults = statement.executeQuery(sql);
        )
        {
            while (dbResults.next())
            {
                String exerciseInitial = dbResults.getString("Exercise_Name");
                exerciseInitial = exerciseInitial.replace("(","");
                int index = exerciseInitial.indexOf(" ");
                exerciseInitial= exerciseInitial.substring(0,1) + exerciseInitial.substring(index, index +2);
                exerciseInitial = exerciseInitial.toUpperCase();
                int numOfOrders = dbResults.getInt("TimesExerciseCompleted");
                exercisesCompleted.getData().add(new XYChart.Data<>(exerciseInitial,numOfOrders));
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return exercisesCompleted;
    }


    public static ArrayList<String> getExerciseName()
    {
        ArrayList<String> exerciseNames = new ArrayList<>();

        String sql = "SELECT Exercise_Name, COUNT(Exercise_Name) as TimesExerciseCompleted " +
                "FROM weightliftingData " +
                "GROUP BY  Exercise_Name " +
                "ORDER BY TimesExerciseCompleted DESC " +
                "LIMIT 10;";

        try(
                Connection conn = DriverManager.getConnection(connectUrl,user,pw);

                Statement statement = conn.createStatement();

                ResultSet dbResults = statement.executeQuery(sql);
        )
        {
            while (dbResults.next())
            {
                String exerciseName = dbResults.getString("Exercise_Name");
                exerciseNames.add(exerciseName);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return exerciseNames;
    }
}
