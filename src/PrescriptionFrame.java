//package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
//import repository.*;
//import entity.*;

public class PrescriptionFrame extends JFrame implements ActionListener {

    private JButton Backbtn, exitBtn, getAllBtn, viewDetailsBtn;
    private JTable PrescriptionTable;
    private JScrollPane PrescriptionTableSP;
    private JPanel panel;
    Users user;
    int patientId;

    public PrescriptionFrame(Users user) {
        super("Prscription Frame");
        this.user = user;
        this.setSize(800, 450);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        panel = new JPanel();
        panel.setLayout(null);

        String data[][] = {{"", "", "", "", "", "", "",""}};

        String head[] = {"Id", "Name", "Date Of Birth", "Blood Group","Email", "Conatact No", "Address","Pharmacist ID"};

//        DonorTable = new JTable(data, head);
//        DonorTableSP = new JScrollPane(DonorTable);
//        DonorTableSP.setBounds(350, 200, 100, 150);
//        DonorTable.setEnabled(false);
//        panel.add(DonorTableSP);

        getAllBtn = new JButton("Get All");
        getAllBtn.setBounds(500, 260, 80, 30);
        getAllBtn.addActionListener(this);
        panel.add(getAllBtn);

        viewDetailsBtn = new JButton("View Details");
        viewDetailsBtn.setBounds(300, 260, 150, 30);
        viewDetailsBtn.addActionListener(this);
        panel.add(viewDetailsBtn);

        Backbtn = new JButton("Back");
        Backbtn.setBounds(600, 350, 80, 30);
        Backbtn.addActionListener(this);
        panel.add(Backbtn);

        this.add(panel);
    }

    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();

        System.out.println(command);

        if (command.equals(getAllBtn.getText())) {

            PrescriptionRepo prescriptionRepo = new PrescriptionRepo();
            ArrayList<Prescription> prescriptionData = prescriptionRepo.getPrescription(this.getPatientId());//From SelectPatientFrame we get PatientId
            Object data[][] = new Object[prescriptionData.size()][7];
            String head[] = {"Id", "DISEASE", "UPDATE_DATE", "A_ID","D_ID", "PHID", "PA_ID"};

            for(int i=0;i<prescriptionData.size();i++) {
                data[i][0] = prescriptionData.get(i).getId();
                data[i][1] = prescriptionData.get(i).getDiseaseName();
                data[i][2] = prescriptionData.get(i).getUpdatedDate();
                data[i][3] = prescriptionData.get(i).getAssistantId();
                data[i][4] = prescriptionData.get(i).getDoctorId();
                data[i][5] = prescriptionData.get(i).getPharmacistId();
                data[i][6] = prescriptionData.get(i).getPatientId();
            }

            PrescriptionTable = new JTable(data, head);
            PrescriptionTable.setEnabled(false);
            PrescriptionTableSP = new JScrollPane(PrescriptionTable);
            PrescriptionTableSP.setBounds(150, 100, 600, 150);
            panel.add(PrescriptionTableSP);

            panel.revalidate();
            panel.repaint();
        }




        else if (command.equals(Backbtn.getText())) {
            SelectPatientFrame spf = new SelectPatientFrame(this.user);
            spf.setVisible(true);
            this.setVisible(false);
        }

        else if (command.equals(viewDetailsBtn.getText())) {
            SelectPrescriptionFrame spf = new SelectPrescriptionFrame(this.user);
            spf.setVisible(true);
            this.setVisible(false);
        }
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }
}