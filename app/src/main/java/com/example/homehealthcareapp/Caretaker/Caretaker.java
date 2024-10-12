package com.example.homehealthcareapp.Caretaker;

public class Caretaker {
    private int id;
    private String name;
    private String specialization;
    private int experience;
    private double reviews;
    private int patientsHandled;

    public Caretaker(int id, String name, String specialization, int experience, double reviews, int patientsHandled) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.experience = experience;
        this.reviews = reviews;
        this.patientsHandled = patientsHandled;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getSpecialization() { return specialization; }
    public int getExperience() { return experience; }
    public double getReviews() { return reviews; }
    public int getPatientsHandled() { return patientsHandled; }
}
