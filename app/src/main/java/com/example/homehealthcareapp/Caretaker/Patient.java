package com.example.homehealthcareapp.Caretaker;

public class Patient {
    private int id;
    private String name;
    private int age;
    private String disease;
    private String careRequired;
    private String medicalHistory;

    public Patient(int id, String name, int age, String disease, String careRequired, String medicalHistory) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
        this.careRequired = careRequired;
        this.medicalHistory = medicalHistory;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getDisease() { return disease; }
    public String getCareRequired() { return careRequired; }
    public String getMedicalHistory() { return medicalHistory; }
}
