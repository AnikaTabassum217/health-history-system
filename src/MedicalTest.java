//package entity;

import java.lang.*;

public class MedicalTest {
    private int id;
    private String medicalTestName;
    private String medicalTestType;
    private String medicalTestDate;
    private String medicalTestResult;
    private String medicalTestObservation;
    private int assistantID;
    private int doctorID;
    private int patientID;

    public MedicalTest() {
        System.out.println("Empty-constructor");
    }

    public MedicalTest(int id, String medicalTestName, String medicalTestType, String medicalTestDate, String medicalTestResult, String medicalTestObservation, int assistantID, int doctorID, int patientID) {
        this.id = id;
        this.medicalTestName = medicalTestName;
        this.medicalTestType = medicalTestType;
        this.medicalTestDate = medicalTestDate;
        this.medicalTestResult = medicalTestResult;
        this.medicalTestObservation = medicalTestObservation;
        this.assistantID = assistantID;
        this.doctorID = doctorID;
        this.patientID = patientID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMedicalTestName() {
        return medicalTestName;
    }

    public void setMedicalTestName(String medicalTestName) {
        this.medicalTestName = medicalTestName;
    }

    public String getMedicalTestType() {
        return medicalTestType;
    }

    public void setMedicalTestType(String medicalTestType) {
        this.medicalTestType = medicalTestType;
    }

    public String getMedicalTestDate() {
        return medicalTestDate;
    }

    public void setMedicalTestDate(String medicalTestDate) {
        this.medicalTestDate = medicalTestDate;
    }

    public String getMedicalTestResult() {
        return medicalTestResult;
    }

    public void setMedicalTestResult(String medicalTestResult) {
        this.medicalTestResult = medicalTestResult;
    }

    public String getMedicalTestObservation() {
        return medicalTestObservation;
    }

    public void setMedicalTestObservation(String medicalTestObservation) {
        this.medicalTestObservation = medicalTestObservation;
    }

    public int getAssistantID() {
        return assistantID;
    }

    public void setAssistantID(int assistantID) {
        this.assistantID = assistantID;
    }

    public int getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public int getPatienttID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }
}