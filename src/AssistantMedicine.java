//package entity;

import java.lang.*;

public class AssistantMedicine {
    private int id;
    private String medicineName;
    private String medicinePower;
    private String medicineTime;
    private String medicinePrice;
    private int patientId;
    private int pharmacistId;
    private int prscriptionId;


    public AssistantMedicine() {
        System.out.println("Empty-constructor");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getMedicinePower() {
        return medicinePower;
    }

    public void setMedicinePower(String medicinePower) {
        this.medicinePower = medicinePower;
    }

    public String getMedicineTime() {
        return medicineTime;
    }

    public void setMedicineTime(String medicineTime) {
        this.medicineTime = medicineTime;
    }

    public String getMedicinePrice() {
        return medicinePrice;
    }

    public void setMedicinePrice(String medicinePrice) {
        this.medicinePrice = medicinePrice;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getPharmacistId() {
        return pharmacistId;
    }

    public void setPharmacistId(int pharmacistId) {
        this.pharmacistId = pharmacistId;
    }

    public int getPrscriptionId() {
        return prscriptionId;
    }

    public void setPrscriptionId(int prscriptionId) {
        this.prscriptionId = prscriptionId;
    }
}
