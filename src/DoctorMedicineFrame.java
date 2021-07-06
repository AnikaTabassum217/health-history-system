//package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
//import repository.*;
//import entity.*;

public class DoctorMedicineFrame extends JFrame implements ActionListener {

    private JButton Backbtn, exitBtn, getAllBtn;
    private JTable MedicineTable;
    private JScrollPane MedicineTableSP;
    private JPanel panel;
    Users user;
    int prescriptionId;

    public DoctorMedicineFrame(Users user) {
        super("Doctor Medicine Frame");
        this.user = user;
        this.setSize(800, 450);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        panel = new JPanel();
        panel.setLayout(null);

        String data[][] = {{"", "", "", "", ""}};

        String head[] = {"Id", "Name", "NID", "Date Of Birth", "Blood Group","Email", "Conatact No", "Address"};

//        DonorTable = new JTable(data, head);
//        DonorTableSP = new JScrollPane(DonorTable);
//        DonorTableSP.setBounds(350, 200, 100, 150);
//        DonorTable.setEnabled(false);
//        panel.add(DonorTableSP);

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


            PharmacistMedicineRepo medicineRepo = new PharmacistMedicineRepo();
            ArrayList<Medicine> medicineData = medicineRepo.getPrescribeMedicine(this.getPrescriptionId());
            Object data[][] = new Object[medicineData.size()][7];
            String head[] = {"Id", "Name", "Power", "Time", "Price","Patient ID","Pharmacist ID"};

            for(int i=0;i<medicineData.size();i++) {
                data[i][0] = medicineData.get(i).getId();
                data[i][1] = medicineData.get(i).getMedicineName();
                data[i][2] = medicineData.get(i).getMedicinePower();
                data[i][3] = medicineData.get(i).getMedicineTime();
                data[i][4] = medicineData.get(i).getMedicinePrice();
                data[i][5] = medicineData.get(i).getPatientId();
                data[i][6] = medicineData.get(i).getPharmacistId();
            }

            MedicineTable = new JTable(data, head);
            MedicineTable.setEnabled(false);
            MedicineTableSP = new JScrollPane(MedicineTable);
            MedicineTableSP.setBounds(150, 100, 600, 150);
            panel.add(MedicineTableSP);

            panel.revalidate();
            panel.repaint();
        } else if (command.equals(Backbtn.getText())) {
            DoctorSelectPrescriptionFrame dspf = new DoctorSelectPrescriptionFrame(this.user);
            dspf.setVisible(true);
            this.setVisible(false);
        }
    }

    public int getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(int prescriptionId) {
        this.prescriptionId = prescriptionId;
    }
}