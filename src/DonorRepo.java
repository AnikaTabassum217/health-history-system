//package repository;

import java.lang.*;
import java.util.*;
//import entity.*;
//import interfaces.*;

public class DonorRepo {
    DatabaseConnection dbc = null;

    public DonorRepo() {
        dbc = new DatabaseConnection();
    }

    public ArrayList<Donor> getDonorList()
    {
        ArrayList<Donor> DonorList= new ArrayList<>();
        String query = "Select * from donor ";
        try {
            System.out.println(query);
            dbc.openConnection();
            dbc.result = dbc.st.executeQuery(query);
            System.out.println("Query complete");
            while (dbc.result.next()) {
                Donor donor = new Donor();
                System.out.println("inside while");

                donor.setId(dbc.result.getInt("DID"));
                donor.setDonorName(dbc.result.getString("D_NAME"));
                donor.setDateOfBirth(dbc.result.getString("DOB"));
                donor.setBloodGroup(dbc.result.getString("BLOOD_GROUP"));
                donor.setDonorEmail(dbc.result.getString("D_EMAIL"));
                donor.setDonorEmail(dbc.result.getString("D_GENDER"));
                donor.setDonorGender(dbc.result.getString("D_CONTACT"));

                DonorList.add(donor);
            }
        } catch (Exception ex) {
            System.out.println("Exception : " + ex.getMessage());
        }
        dbc.closeConnection();
        return DonorList;
    }
}

