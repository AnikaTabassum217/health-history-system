//package entity;

import java.lang.*;

public class Donor {
    private int id;
    private String donorName;
    private String dateOfBirth;
    private String bloodGroup;
    private String donorEmail;
    private String donorGender;
    private String donorContact;



    public Donor() {
        System.out.println("Empty-constructor");
    }

    public Donor(int id, String donorName, String dateOfBirth, String bloodGroup, String donorEmail, String donorGender, String donorContact) {
        this.id = id;
        this.donorName = donorName;
        this.dateOfBirth = dateOfBirth;
        this.bloodGroup = bloodGroup;
        this.donorEmail = donorEmail;
        this.donorGender = donorGender;
        this.donorContact = donorContact;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getDonorEmail() {
        return donorEmail;
    }

    public void setDonorEmail(String donorEmail) {
        this.donorEmail = donorEmail;
    }

    public String getDonorGender() {
        return donorGender;
    }

    public void setDonorGender(String donorGender) {
        this.donorGender = donorGender;
    }

    public String getDonorContact() {
        return donorContact;
    }

    public void setDonorContact(String donorContact) {
        this.donorContact = donorContact;
    }
}