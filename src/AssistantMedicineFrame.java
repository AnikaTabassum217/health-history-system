//package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import repository.*;
//import entity.*;

public class AssistantMedicineFrame extends JFrame implements ActionListener{

    JLabel title, IDLabel, NameLabel,PowerLabel,TimeLabel,PatientLabel,Pharmacistlabel,PrescriptionLabel;
    JTextField IDTF,NameTF,PowerTF,TimeTF,PatientTF,PharmacistTF,PrescriptionTF;

    JButton submitBtn, Logoutbtn,Backbtn, getMedicineBtn;
    JPanel panel;
    Users user;
    Medicine medicine;
    int medicineId;

    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }

    public AssistantMedicineFrame(Users user)
    {
        super("Assistant Medicine Frame");
        this.user = user;

        this.setSize(400, 650);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        panel = new JPanel();
        panel.setLayout(null);

        title = new JLabel("Assistant Medicine Frame");
        title.setBounds(20, 20, 100, 30 );
        panel.add(title);

       /* idLabel = new JLabel("Update ID");
        idLabel.setBounds(20, 70, 100, 30);
        panel.add(idLabel);

        idTF = new JTextField();
        idTF.setBounds(120, 70, 100, 30);
        panel.add(idTF);*/

        NameLabel = new JLabel("Medicine Name");
        NameLabel.setBounds(20, 130, 100, 30);
        panel.add(NameLabel);

        NameTF= new JTextField();
        NameTF.setBounds(120, 130, 100, 30);
        panel.add(NameTF);

        PowerLabel = new JLabel("Power");
        PowerLabel.setBounds(20, 190, 100, 30);
        panel.add(PowerLabel);

        PowerTF = new JTextField();
        PowerTF.setBounds(120, 190, 100, 30);
        panel.add(PowerTF);

        TimeLabel = new JLabel("Time");
        TimeLabel.setBounds(20, 250, 100, 30);
        panel.add(TimeLabel);

        TimeTF = new JTextField();
        TimeTF.setBounds(120, 250, 100, 30);
        panel.add(TimeTF);

        PatientLabel = new JLabel("Patient ID");
        PatientLabel.setBounds(20, 310, 100, 30);
        panel.add(PatientLabel);

        PatientTF = new JTextField();
        PatientTF.setBounds(120, 310, 100, 30);
        panel.add(PatientTF);

        Pharmacistlabel = new JLabel("Pharmacist ID");
        Pharmacistlabel.setBounds(20, 370, 100, 30);
        panel.add(Pharmacistlabel);


        PharmacistTF = new JTextField();
        PharmacistTF.setBounds(120, 370, 100, 30);
        panel.add(PharmacistTF);

        PrescriptionLabel = new JLabel("Prescription ID");
        PrescriptionLabel.setBounds(20, 430, 100, 30);
        panel.add(PrescriptionLabel);


        PrescriptionTF = new JTextField();
        PrescriptionTF.setBounds(120, 430, 100, 30);
        panel.add(PrescriptionTF);


        submitBtn = new JButton("SUBMIT");
        submitBtn.setBounds(20, 480, 100, 30);
        submitBtn.addActionListener(this);
        panel.add(submitBtn);

        /*getMedicineBtn = new JButton("GET MEDICINE");
        getMedicineBtn.setBounds(20, 300, 100, 30);
        getMedicineBtn.addActionListener(this);
        panel.add(getMedicineBtn);*/

        Logoutbtn = new JButton("Logout");
        Logoutbtn.setBounds(220, 480, 100, 30);
        Logoutbtn.addActionListener(this);
        panel.add(Logoutbtn);

        Backbtn = new JButton("Back");
        Backbtn.setBounds(220, 530, 100, 30);
        Backbtn.addActionListener(this);
        panel.add(Backbtn);

        this.add(panel);
    }


    public void actionPerformed(ActionEvent ae)
    {
        String command = ae.getActionCommand();

        if(command.equals(Backbtn.getText()))
        {
            AssistantFrame af = new AssistantFrame(this.user);
            af.setVisible(true);
            this.setVisible(false);
        }


        else if(command.equals(submitBtn.getText()))
        {


            String medicineName = NameTF.getText();


            String power = PowerTF.getText();


            String time = TimeTF.getText();



            String patientId = PatientTF.getText();


            String pharmacistId = PharmacistTF.getText();

            String prescriptionId = PrescriptionTF.getText();


            AssistantMedicine assistantMedicine = new AssistantMedicine();

            assistantMedicine.setMedicineName(medicineName);
            assistantMedicine.setMedicinePower(power);
            assistantMedicine.setMedicineTime(time);
            assistantMedicine.setPatientId(Integer.parseInt(patientId));
            assistantMedicine.setPharmacistId(Integer.parseInt(pharmacistId));
            assistantMedicine.setPrscriptionId(Integer.parseInt(prescriptionId));



            MedicineRepo medicine = new MedicineRepo();
            medicine.insertMedicineByAssistant(assistantMedicine);

            NameTF.setText("");
            PowerTF.setText("");
            TimeTF.setText("");
            PatientTF.setText("");
            PharmacistTF.setText("");
            PrescriptionTF.setText("");


        }


    }
}