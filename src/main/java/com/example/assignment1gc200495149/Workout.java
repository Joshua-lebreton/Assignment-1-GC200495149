package com.example.assignment1gc200495149;

import java.util.Arrays;
import java.util.List;

public class Workout {
    private String workoutName;
    private String exerciseName ;
    private double weight;
    private int reps;

    public Workout(String workoutName, String exerciseName, double weight, int reps) {
        setWorkoutName(workoutName);
        setExerciseName(exerciseName);
        setWeight(weight);
        setReps(reps);
    }

    public String getWorkoutName() {
        return workoutName;
    }

    public static List<String> validWorkoutName(){
        return Arrays.asList("back", "chest", "shoulder day", "squat 1");

    }

    public void setWorkoutName(String workoutName) {
        workoutName = workoutName.toLowerCase().trim();
        List<String> validWorkoutName = validWorkoutName();

        if (validWorkoutName.contains(workoutName)) {
            workoutName = workoutName.substring(0, 1).toUpperCase() + workoutName.substring(1, workoutName.length());
            System.out.println(workoutName);
            this.workoutName = workoutName;
        }else {
            throw new IllegalArgumentException("Valid workout names are: " + validWorkoutName);
        }
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public static List<String> validExerciseName(){
        return Arrays.asList("chin up", "lat pulldown", "seated cable row (close grip)", "rear delt fly", "bent over row (dumbbell)", "bicep curl (barbell)", "cycling", "deadlift(barbell)", "glute extension", "good morning", "good morning (barbell)", "hammer curl", "hammer curl (dumbbell)", "incline bench press", "incline bench press (barbell)", "incline press (dumbbell)", "lateral raise", "lateral raise (dumbbells)", "leg curl", "leg outward fly", "leg press", "leg press (hinge)", "military press (standing)", "seated military press", "seated military press (dumbbell)", "seated row", "seated shoulder press (barbell)", "seated shoulder press (dumbbell)", "shoulder press (standing)", "squat", "squat (barbell)", "t-bar row", "tricep extension", "tricep pushdown", "weighted dips");
    }
    public void setExerciseName(String exerciseName) {
        exerciseName = exerciseName.toLowerCase().trim();
        List<String> validExerciseName = validExerciseName();

        if (validExerciseName.contains(exerciseName)) {
            exerciseName = exerciseName.substring(0, 1).toUpperCase() + exerciseName.substring(1, exerciseName.length());
            System.out.println(exerciseName);
            this.exerciseName = exerciseName;
        }else {
            throw new IllegalArgumentException("Valid workout names are: " + validExerciseName);
        }
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight >= 1) {
            this.weight = weight;
        }else {
            throw new IllegalArgumentException("Weight must be 1 or greater");
        }
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        if (reps >= 1) {
            this.reps = reps;
        }else {
            throw new IllegalArgumentException("Reps must be 1 or greater");
        }

    }
}
