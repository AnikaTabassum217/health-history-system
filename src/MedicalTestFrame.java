//package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
//import repository.*;
//import entity.*;

public class MedicalTestFrame extends JFrame implements ActionListener {

    private JButton Backbtn, exitBtn, getAllBtn;
    private JTable TestTable;
    private JScrollPane TestTableSP;
    private JPanel panel;
    Users user;

    public MedicalTestFrame(Users user) {
        super("Medical Test Frame");
        this.user = user;
        this.setSize(800, 450);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        panel = new JPanel();
        panel.setLayout(null);

        String data[][] = {{"", "", "", "", "", "", "", "",""}};

        String head[] = {"Id", "Name", "Type", "Date", "Result","Observation", "Assistant ID", "Doctor ID","Patient ID"};


        getAllBtn = new JButton("Get All");
        getAllBtn.setBounds(500, 260, 80, 30);
        getAllBtn.addActionListener(this);
        panel.add(getAllBtn);

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


            MedicalTestRepo medicalTestRepo = new MedicalTestRepo();//For calling MedicalTestRepo we create an object which is medicalTestRepo

            ArrayList<MedicalTest> medicalTestData = medicalTestRepo.getPatientMedicalTest(this.user.getid());//medicalTestData is an object of MedicalTest and by using  medicalTestRepo we call getPatientMedicalTest class frome MedicalTestFrame to MedicalTestRepo
            Object data[][] = new Object[medicalTestData.size()][9];
            String head[] = {"Id", "Name", "Type", "Date", "Result","Observation", "Assistant ID", "Doctor ID","Patient ID"};

            for(int i=0;i<medicalTestData.size();i++) {
                data[i][0] = medicalTestData.get(i).getId();//from test object we pick data and put into frame
                data[i][1] = medicalTestData.get(i).getMedicalTestName();
                data[i][2] = medicalTestData.get(i).getMedicalTestType();
                data[i][3] = medicalTestData.get(i).getMedicalTestDate();
                data[i][4] = medicalTestData.get(i).getMedicalTestResult();
                data[i][5] = medicalTestData.get(i).getMedicalTestObservation();
                data[i][6] = medicalTestData.get(i).getAssistantID();
                data[i][7] = medicalTestData.get(i).getDoctorID();
                data[i][8] = medicalTestData.get(i).getPatienttID();
            }

            //panel.remove(DonorTableSP);

            TestTable = new JTable(data, head);
            TestTable.setEnabled(false);
            TestTableSP = new JScrollPane(TestTable);
            TestTableSP.setBounds(150, 100, 600, 150);
            panel.add(TestTableSP);

            panel.revalidate();
            panel.repaint();
        } else if (command.equals(Backbtn.getText())) {
            PatientFrame pf = new PatientFrame(this.user);
            pf.setVisible(true);
            this.setVisible(false);
        }
    }

}
