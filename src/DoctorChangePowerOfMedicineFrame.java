//package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import repository.*;
//import entity.*;

public class DoctorChangePowerOfMedicineFrame extends JFrame implements ActionListener{

    JLabel title, IDLabel, NameLabel,PowerLabel,TimeLabel;
    JTextField IDTF,NameTF,PowerTF,TimeTF;

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

    public DoctorChangePowerOfMedicineFrame(Users user)
    {
        super("Doctor Change Power Of Medicine Frame");
        this.user = user;

        this.setSize(400, 450);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        panel = new JPanel();
        panel.setLayout(null);

        title = new JLabel("");
        title.setBounds(20, 20, 100, 30 );
        panel.add(title);



        IDLabel = new JLabel("ID");
        IDLabel.setBounds(20, 70, 100, 30);
        panel.add(IDLabel);

        IDTF = new JTextField();
        IDTF.setBounds(120, 70, 100, 30);
        IDTF.setText("");
        panel.add(IDTF);

        NameLabel = new JLabel("Medicine Name");
        NameLabel.setBounds(20, 130, 100, 30);
        panel.add(NameLabel);

        NameTF = new JTextField();
        NameTF.setBounds(120, 130, 100, 30);
        NameTF.setText("");
        panel.add(NameTF);

        PowerLabel = new JLabel("Power");
        PowerLabel.setBounds(20, 190, 100, 30);
        panel.add(PowerLabel);

        PowerTF = new JTextField();
        PowerTF.setBounds(120, 190, 100, 30);
        PowerTF.setText("");
        panel.add(PowerTF);

        TimeLabel = new JLabel("Time");
        TimeLabel.setBounds(20, 250, 100, 30);
        panel.add(TimeLabel);

        TimeTF = new JTextField();
        TimeTF.setBounds(120, 250, 100, 30);
        TimeTF.setText("");
        panel.add(TimeTF);

        submitBtn = new JButton("UPDATE");
        submitBtn.setBounds(20, 330, 100, 30);
        submitBtn.addActionListener(this);
        panel.add(submitBtn);

        getMedicineBtn = new JButton("GET MEDICINE");
        getMedicineBtn.setBounds(20, 300, 100, 30);
        getMedicineBtn.addActionListener(this);
        panel.add(getMedicineBtn);

        Logoutbtn = new JButton("Logout");
        Logoutbtn.setBounds(220, 300, 100, 30);
        Logoutbtn.addActionListener(this);
        panel.add(Logoutbtn);

        Backbtn = new JButton("Back");
        Backbtn.setBounds(220, 350, 100, 30);
        Backbtn.addActionListener(this);
        panel.add(Backbtn);

        this.add(panel);
    }


    public void actionPerformed(ActionEvent ae)
    {
        String command = ae.getActionCommand();

        if(command.equals(Backbtn.getText()))
        {
            DoctorSelectMedicineFrame pf = new DoctorSelectMedicineFrame(this.user);
            pf.setVisible(true);
            this.setVisible(false);
        }

        else if(command.equals(submitBtn.getText()))// here submit means update info
        {
            Medicine medicine = new Medicine();
            String Id = IDTF.getText();//  from database we pick ID info by using get method
            medicine.setId(Integer.parseInt(Id));//put updated or previous info by using set method

            String Name = NameTF.getText();
            medicine.setMedicineName(Name);

            String Power = PowerTF.getText();
            medicine.setMedicinePower(Power);

            String Time = TimeTF.getText();
            medicine.setMedicineTime(Time);

            MedicineRepo medicineRepo = new MedicineRepo();// medicineRepo is an object of MedicineRepo
            medicineRepo.updateMedicine(medicine);//here we call update Medicine query, so info will be updated
        }

        else if(command.equals(getMedicineBtn.getText()))
        {
            MedicineRepo medicineRepo = new MedicineRepo();
            medicine = medicineRepo.getPrescribeMedicineByMedicineId(this.getMedicineId());// we get one medicine info

            IDTF.setText("" + medicine.getId());//
            NameTF.setText(medicine.getMedicineName());
            PowerTF.setText(medicine.getMedicinePower());
            TimeTF.setText(medicine.getMedicineTime());

        }

    }
}