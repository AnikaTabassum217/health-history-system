//package repository;

import java.lang.*;
import java.util.*;
//import entity.*;
//import interfaces.*;

public class PharmacistMedicineRepo {
    DatabaseConnection dbc = null;

    public PharmacistMedicineRepo() {
        dbc = new DatabaseConnection();
    }

    public ArrayList<Medicine> getPrescribeMedicine(int prescriptionID)
    {
        ArrayList<Medicine> medicineList= new ArrayList<>();
        String query = "Select * from medicine where  PR_ID = " + prescriptionID +";";
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

}
