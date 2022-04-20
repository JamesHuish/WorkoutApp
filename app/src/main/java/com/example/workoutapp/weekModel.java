package com.example.workoutapp;

public class weekModel {

    private String weekNo;
    private String Squat;
    private String Bench;
    private String Deadlift;
    private String Deadlift2;

    private int id;

    // creating getter and setter methods
    public String getweekNo() {
        return weekNo;
    }

    public String getSquat() {
        return Squat;
    }
    public void setSquat(String Squat) {
        this.Squat = Squat;
    }

    public String getBench() {
        return Bench;
    }

    public void setBench(String Bench) {
        this.Bench = Bench;
    }

    public String getDeadlift() {
        return Deadlift;
    }

    public void setDeadlift(String Deadlift) {
        this.Deadlift = Deadlift;
    }

    public String getDeadlift2() {
        return Deadlift2;
    }

    public void setDeadlift2(String Deadlift2) {
        this.Deadlift2 = Deadlift2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // constructor
    public weekModel(String weekNo, String Squat , String Bench, String Deadlift, String Deadlift2) {
        this.weekNo = weekNo;
        this.Squat = Squat;
        this.Bench = Bench;
        this.Deadlift = Deadlift;
        this.Deadlift2 = Deadlift2;
    }
}
