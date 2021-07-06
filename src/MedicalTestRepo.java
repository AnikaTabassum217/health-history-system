//package repository;

import java.lang.*;
import java.util.*;
//import entity.*;
//import interfaces.*;

public class MedicalTestRepo {
    DatabaseConnection dbc = null;

    public MedicalTestRepo() {
        dbc = new DatabaseConnection();
    }

    public ArrayList<MedicalTest> getPatientMedicalTest(int patientID)//patientID is user because we login to PatientFarme by using user which is Patient
    {
        ArrayList<MedicalTest> medicalTestsList = new ArrayList<>();//Here we use ArrayList for each test , here create an object and more than one medical test can create , so we use Arraylist type
        String query = "Select * from medical_test where  PA_ID = " + patientID +";"; //In PatientFrame only patient can login and patient see their info by using patientID which is user
        try {
            System.out.println(query);
            dbc.openConnection();
            dbc.result = dbc.st.executeQuery(query);
            System.out.println("Query complete");
            while (dbc.result.next()) {
                MedicalTest test = new MedicalTest();
                System.out.println("inside while");

                test.setId(dbc.result.getInt("MT_ID"));//from database we set all data in test object
                test.setMedicalTestName(dbc.result.getString("MT_NAME"));
                test.setMedicalTestType(dbc.result.getString("MT_TYPE"));
                test.setMedicalTestDate(dbc.result.getString("MT_DATE"));
                test.setMedicalTestResult(dbc.result.getString("MT_RESULT"));
                test.setMedicalTestObservation(dbc.result.getString("MT_OBSERVATION"));
                test.setAssistantID(dbc.result.getInt("A_ID"));
                test.setDoctorID(dbc.result.getInt("D_ID"));
                test.setPatientID(dbc.result.getInt("PA_ID"));
                medicalTestsList.add(test);//medicalTestsList is an object of MedicalTest and here we add all test
            }
        } catch (Exception ex) {
            System.out.println("Exception : " + ex.getMessage());
        }
        dbc.closeConnection();
        return medicalTestsList;// all tests are save in medicalTestsList object so when we return we can see list of test
    }
}