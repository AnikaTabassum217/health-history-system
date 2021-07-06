//package repository;

import java.lang.*;
import java.util.*;
//import entity.*;
//import interfaces.*;

public class AssistantPrescriptionRepo {
    DatabaseConnection dbc = null;

    public AssistantPrescriptionRepo() {
        dbc = new DatabaseConnection();
    }

    //PA_ID = assistantPrescription.getPatientId();
    public void insertPrescriptionByAssistant(AssistantPrescription assistantPrescription)
    {
        String query = "INSERT INTO `prescription` (`PR_ID`, `PA_ID`, `D_ID`, `A_ID`, `UPDATE_DATE`,`DISEASE`) VALUES " +
                "(NULL,"+assistantPrescription.getPatientId()+","+assistantPrescription.getDoctorId()+","+assistantPrescription.getAssistantId()+",'"+assistantPrescription.getVisitingDate()+"','"+assistantPrescription.getDiseaseName()+"');";

        System.out.println(query);
        try
        {
            dbc.openConnection();
            dbc.st.execute(query);
            dbc.closeConnection();
        }
        catch(Exception ex){System.out.println(ex.getMessage());}
    }


    public void updatePrescriptionByAssistant(AssistantPrescription p)
    {

        String query = "UPDATE `prescription` SET `PA_ID` = " +p.getPatientId()
                +",`D_ID` = "+p.getDoctorId()
                +",`A_ID` = "+p.getAssistantId()
                +",`DISEASE`='"+p.getDiseaseName()
                +"',`UPDATE_DATE` = '"+p.getVisitingDate()+"'  WHERE `PR_ID` = " +p.getId()+";";

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
