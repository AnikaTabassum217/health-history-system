//package repository;

import java.lang.*;
import java.util.*;
//import entity.*;
//import interfaces.*;

public class MedicineRepo {
    DatabaseConnection dbc = null;

    public MedicineRepo() {
        dbc = new DatabaseConnection();
    }

    public ArrayList<Medicine> getPrescribeMedicine(int patientID)
    {
        ArrayList<Medicine> medicineList= new ArrayList<>();
        String query = "Select * from medicine where  PA_ID = " + patientID +";";
        try {
            System.out.println(query);
            dbc.openConnection();
            dbc.result = dbc.st.executeQuery(query);
            System.out.println("Query complete");
            while (dbc.result.next()) {
                Medicine medicine = new Medicine();
                System.out.println("inside while");

                medicine.setId(dbc.result.getInt("MED_ID"));// medicine is an object of Medicine and from database we set all data in m object
                medicine.setMedicineName(dbc.result.getString("MED_NAME"));
                medicine.setMedicinePower(dbc.result.getString("MED_POWER"));
                medicine.setMedicineTime(dbc.result.getString("MED_TIME"));
                medicine.setMedicinePrice(dbc.result.getString("MED_PRICE"));
                medicine.setPatientId(dbc.result.getInt("PA_ID"));
                medicine.setPharmacistId(dbc.result.getInt("PHID"));

                medicineList.add(medicine);// medicineList is an object of Medicine and here all medicine add in medicines object
            }
        } catch (Exception ex) {
            System.out.println("Exception : " + ex.getMessage());
        }
        dbc.closeConnection();
        return medicineList;// all medicine are save in medicineList object so when we return we can see list of medicine
    }

    public Medicine getPrescribeMedicineByMedicineId(int medicineId)
    {
        Medicine medicine= new Medicine();
        String query = "Select * from medicine where  MED_ID = " + medicineId +";";
        try {
            System.out.println(query);
            dbc.openConnection();
            dbc.result = dbc.st.executeQuery(query);
            System.out.println("Query complete");
            while (dbc.result.next()) {
                System.out.println("inside while");

                medicine.setId(dbc.result.getInt("MED_ID"));// using medicine object we set data from database in medicine object
                medicine.setMedicineName(dbc.result.getString("MED_NAME"));
                medicine.setMedicinePower(dbc.result.getString("MED_POWER"));
                medicine.setMedicineTime(dbc.result.getString("MED_TIME"));
                medicine.setMedicinePrice(dbc.result.getString("MED_PRICE"));
                medicine.setPatientId(dbc.result.getInt("PA_ID"));
                medicine.setPharmacistId(dbc.result.getInt("PHID"));
            }
        } catch (Exception ex) {
            System.out.println("Exception : " + ex.getMessage());
        }
        dbc.closeConnection();
        return medicine;
    }


    public boolean updateMedicine(Medicine m)
    {

        String query = "UPDATE `medicine` SET "
                +"`MED_NAME` = '"+m.getMedicineName()
                +"',`MED_POWER` = '"+m.getMedicinePower()
                +"',`MED_TIME` = '"+m.getMedicineTime()+"'  WHERE `MED_ID` = " +m.getId()+";";

        try {
            System.out.println(query);
            dbc.openConnection();
            dbc.st.executeUpdate(query);
            System.out.println("Query complete");
        } catch (Exception ex) {
            System.out.println("Exception : " + ex.getMessage());
            return false;
        }
        dbc.closeConnection();
        return true;
    }

    public void insertMedicineByAssistant(AssistantMedicine m)
    {
        String query = "INSERT INTO `medicine` (`MED_ID`, `MED_NAME`, `MED_POWER`, `MED_TIME`, `PA_ID`, `PHID`, `PR_ID`) VALUES (NULL,'"
                +m.getMedicineName()+"',"+m.getMedicinePower()+",'"+m.getMedicineTime()+"','"+m.getPatientId()+"','"+m.getPharmacistId()+"','"+m.getPrscriptionId()+"');";

        System.out.println(query);
        try
        {
            dbc.openConnection();
            dbc.st.execute(query);
            dbc.closeConnection();
        }
        catch(Exception ex){System.out.println(ex.getMessage());}
    }



}
