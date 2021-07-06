//package entity;

import java.lang.*;

public class Prescription {
    private int id;
    private String diseaseName;
    private String updatedDate;
    private int AssistantId;
    private int DoctorId;
    private int PharmacistId;
    private int PatientId;
    private int PrescriptionId;

    public Prescription() {
        System.out.println("Empty-constructor");
    }

    public Prescription(int id, String diseaseName, String updatedDate, int assistantId, int doctorId, int pharmacistId, int patientId, int prescriptionId) {
        this.id = id;
        this.diseaseName = diseaseName;
        this.updatedDate = updatedDate;
        AssistantId = assistantId;
        DoctorId = doctorId;
        PharmacistId = pharmacistId;
        PatientId = patientId;
        PrescriptionId = prescriptionId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public int getAssistantId() {
        return AssistantId;
    }

    public void setAssistantId(int assistantId) {
        AssistantId = assistantId;
    }

    public int getDoctorId() {
        return DoctorId;
    }

    public void setDoctorId(int doctorId) {
        DoctorId = doctorId;
    }

    public int getPharmacistId() {
        return PharmacistId;
    }

    public void setPharmacistId(int pharmacistId) {
        PharmacistId = pharmacistId;
    }

    public int getPatientId() {
        return PatientId;
    }

    public void setPatientId(int patientId) {
        PatientId = patientId;
    }

    public int getPrescriptionId() {
        return PrescriptionId;
    }

    public void setPrescriptionId(int prescriptionId) {
        PrescriptionId = prescriptionId;
    }
}