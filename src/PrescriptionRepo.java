//package repository;

import java.lang.*;
import java.util.*;
//import entity.*;
//import interfaces.*;

public class PrescriptionRepo {
    DatabaseConnection dbc = null;

    public PrescriptionRepo() {
        dbc = new DatabaseConnection();
    }

    public ArrayList<Prescription> getPrescription(int patientID)
    {
        ArrayList<Prescription> prescriptionList= new ArrayList<>();
        String query = "Select * from prescription where  PA_ID = " + patientID +";";
        try {
            System.out.println(query);
            dbc.openConnection();
            dbc.result = dbc.st.executeQuery(query);
            System.out.println("Query complete");
            while (dbc.result.next()) {
                Prescription prescription = new Prescription();
                System.out.println("inside while");

                prescription.setId(dbc.result.getInt("PR_ID"));
                prescription.setDiseaseName(dbc.result.getString("DISEASE"));
                prescription.setUpdatedDate(dbc.result.getString("UPDATE_DATE"));
                prescription.setAssistantId(dbc.result.getInt("A_ID"));
                prescription.setDoctorId(dbc.result.getInt("D_ID"));
                prescription.setPharmacistId(dbc.result.getInt("PHID"));
                prescription.setPatientId(dbc.result.getInt("PA_ID"));


                prescriptionList.add(prescription);
            }
        } catch (Exception ex) {
            System.out.println("Exception : " + ex.getMessage());
        }
        dbc.closeConnection();
        return prescriptionList;
    }



    public ArrayList<Prescription> getPrescriptionByDoctorId(int doctorID)
    {
        ArrayList<Prescription> prescriptionList= new ArrayList<>();
        String query = "Select * from prescription where  D_ID = " + doctorID +";";
        try {
            System.out.println(query);
            dbc.openConnection();
            dbc.result = dbc.st.executeQuery(query);
            System.out.println("Query complete");
            while (dbc.result.next()) {
                Prescription prescription = new Prescription();
                System.out.println("inside while");

                prescription.setId(dbc.result.getInt("PR_ID"));
                prescription.setDiseaseName(dbc.result.getString("DISEASE"));
                prescription.setUpdatedDate(dbc.result.getString("UPDATE_DATE"));
                prescription.setAssistantId(dbc.result.getInt("A_ID"));
                prescription.setDoctorId(dbc.result.getInt("D_ID"));
                prescription.setPharmacistId(dbc.result.getInt("PHID"));
                prescription.setPatientId(dbc.result.getInt("PA_ID"));


                prescriptionList.add(prescription);
            }
        } catch (Exception ex) {
            System.out.println("Exception : " + ex.getMessage());
        }
        dbc.closeConnection();
        return prescriptionList;
    }

//    public <Prescription> getPrescriptionByAssistantId(int assistantID)
//    {
//
//        String query = "INSERT INTO `users` (`ID`, `Name`, `Age`, `Passward`, `Type`) VALUES (NULL,'"
//                +u.getUserName()+"',"+u.getAge()+",'"+u.getPassward()+"','"+u.getType()+"');";
//
//        System.out.println(query);
//        try
//        {
//            dbc.openConnection();
//            dbc.st.execute(query);
//            dbc.closeConnection();
//        }
//
//
//
//        catch(Exception ex){System.out.println(ex.getMessage());}




    }





