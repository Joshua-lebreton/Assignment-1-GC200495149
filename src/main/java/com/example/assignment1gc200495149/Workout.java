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
        return Arrays.asList("back", "chest", "shoulder day", "squat 1", "legs", "shoulders - heavy day","legs","back heavier chins","2 - back heavy chins","1 incline day","2 - shoulders","1 - heavy squats","1 heavy  rows","2 legs-high reps","push - shoulders / bench","legs - heavy","back - heavier chins","push - incline","legs - 5x5 / volume","back - chins. 5x6","back - light chins, 8-10 reps","back - pyramid. 5max, decrease 5 sets","pulls", "legs - heavy #25", "push - incline #28", "back - pyramid. 5max, decrease 5 sets #22","legs - 5x5 / volume #22","push - shoulders / bench #25","squat light #1","back - pyramid. 5max, decrease 5 sets #23","push - incline #29","legs - heavy #26","back - pyramid. 5max, decrease 5 sets #24","push - shoulders / bench #26","squat light #2","back- heavy 3x8 chins #1","push - incline #30","legs - heavy #27","back - light chins, 8-10 reps #20","push - shoulders / bench #27","legs - heavy #28","back - pyramid. 5max, decrease 5 sets #25","push - incline #31","back - light chins, 8-10 reps #21","squat light #3","push - shoulders / bench #28","back - light chins, 8-10 reps #22","squat light #4","push - incline #32","back- heavy 3x8 chins #2","legs - heavy #29", "push - shoulders / bench #29", "back - light chins, 8-10 reps #23", "squat light #5", "push - incline #33", "back- heavy 3x8 chins #3","legs - heavy #30","push - shoulders / bench #30", "pulls #6", "push - incline #34", "squat light #6", "back- heavy 3x8 chins #4", "push - shoulders / bench #31", "legs - heavy #31", "back - light chins, 8-10 reps #24", "push - incline #35", "back- heavy 3x8 chins #5", "squat light #7", "push - shoulders / bench #32", "back easy #1", "legs - heavy #32", "push - incline #36", "back day 1 #1", "squat light #8", "push - shoulders / bench #33", "back - pyramid. 5max, decrease 5 sets #26", "squat light #10", "push - incline #37", "back day 1 #2", "legs - 5x5 / volume #23", "push - shoulders / bench #34", "back- heavy 3x8 chins #6", "squat light #11", "push - incline #38", "back day 1 #3", "squat light #12", "push - shoulders / bench #35", "back workout", "legs - heavy #33", "push - incline #39", "back- heavy 3x8 chins #7", "back with deadlift", "push - shoulders / bench #36", "legs - heavy #34", "back day 1 #4", "push - incline #40");
    }

    public void setWorkoutName(String workoutName) {
        workoutName = workoutName.toLowerCase().trim();
        List<String> validWorkoutName = validWorkoutName();
        System.out.println(workoutName);
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
        return Arrays.asList("incline bench press (barbell)", "weighted dips", "incline bench press", "squat (barbell)", "leg press (hinge)", "good morning (barbell)", "squat", "leg press", "good morning", "chin up", "lat pulldown", "seated cable row (close grip)", "rear delt fly", "seated row", "hammer curl", "hammer curl (dumbbell)", "glute extension", "seated military press", "seated shoulder press (barbell)", "leg outward fly", "seated military press (dumbbell)", "lateral raise", "seated shoulder press (dumbbell)", "lateral raise (dumbbells)", "bicep curl (barbell)", "t-bar row", "incline press (dumbbell)", "tricep pushdown", "tricep extension","bent over row (dumbbell)", "leg curl", "cycling", "military press (standing)", "shoulder press (standing)", "deadlift (barbell)", "deadlift", "hammer back row wide 45 angle", "hammer lat pulldown", "rotator cuff work.", "shrugs (dumbbell)", "hammer seated row", "hammer seated row (close grip)", "pull up", "hammer shoulder press", "overhead press (dumbbell)", "overhead press (barbell)", "bench press (barbell)", "hammer decline chest press", "front squat (barbell)", "lateral raise (dumbbell)", "leg extension (machine)", "landmine press", "bicep curl (dumbbell)", "romanian deadlift (barbell)", "neutral chin", "skullcrusher (barbell)", "lat pulldown (cable)", "rope never ending", "face pull", "front raise (dumbbell)", "deadlift - trap bar", "stairmaster", "hammer row stand 1armed", "sling shot bench", "sling shot incline", "hack squat", "hammer row - wide grip", "shrugs", "rack pull - 1 pin", "hammer high row - 1 arm", "rack pull 2 pin", "kettlebell swings", "close grip bench", "low incline dumbbell bench", "sumo deadlift", "lying skullcrusher", "high bar squat", "curl ez bar", "curl dumbbell", "lat pulldown closegrip", "cable fly");
    }
    public void setExerciseName(String exerciseName) {
        exerciseName = exerciseName.toLowerCase().trim();
        List<String> validExerciseName = validExerciseName();
        System.out.println(exerciseName);
        if (validExerciseName.contains(exerciseName)) {
            exerciseName = exerciseName.substring(0, 1).toUpperCase() + exerciseName.substring(1, exerciseName.length());
            System.out.println(exerciseName);
            this.exerciseName = exerciseName;
        }else {
            throw new IllegalArgumentException("Valid exercise names are: " + validExerciseName);
        }
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight >= 0) {
            this.weight = weight;
        }else {
            throw new IllegalArgumentException("Weight must be 0 or greater");
        }
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        if (reps >= 0) {
            this.reps = reps;
        }else {
            throw new IllegalArgumentException("Reps must be 0 or greater");
        }

    }

    public String toString(){
        return workoutName +" "+ exerciseName +" "+ weight +" "+ reps;
    }
}
