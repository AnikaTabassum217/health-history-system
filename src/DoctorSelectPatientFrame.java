//package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
//import repository.*;
//import entity.*;

public class DoctorSelectPatientFrame extends JFrame implements ActionListener {

    JLabel title, IDLabel;
    JTextField IDTF;

    JButton submitBtn, Logoutbtn, Backbtn;
    private JTable PrescriptionTable;
    private JScrollPane PrescriptionTableSP;
    JPanel panel;
    Users user;
    private int prescriptionId;


    public DoctorSelectPatientFrame(Users user) {
        super("Doctor Select Patient Frame");
        this.user = user;
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        panel = new JPanel();
        panel.setLayout(null);

        title = new JLabel("Doctor Select Patient");
        title.setBounds(40, 0, 150, 30);
        panel.add(title);

        IDLabel = new JLabel("ID");
        IDLabel.setBounds(20, 40, 50, 30);
        panel.add(IDLabel);

        IDTF = new JTextField("");
        IDTF.setBounds(80, 40, 100, 30);
        panel.add(IDTF);


        submitBtn = new JButton("Submit");
        submitBtn.setBounds(20, 100, 100, 30);
        submitBtn.addActionListener(this);
        panel.add(submitBtn);

        Logoutbtn = new JButton("Logout");
        Logoutbtn.setBounds(180, 100, 100, 30);
        Logoutbtn.addActionListener(this);
        panel.add(Logoutbtn);

        Backbtn = new JButton("Back");
        Backbtn.setBounds(180, 150, 100, 30);
        Backbtn.addActionListener(this);
        panel.add(Backbtn);

        this.add(panel);


    }

    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();

        if (command.equals(submitBtn.getText())) {
            DoctorPrescriptionFrame dspf = new DoctorPrescriptionFrame(this.user);
            int patientId = Integer.parseInt(IDTF.getText());
            dspf.setPatientId(patientId);
            dspf.setVisible(true);
            this.setVisible(false);
        }

    }


		/*else if(command.equals(Logoutbtn.getText()))
		{			
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);				
		}
		else if(command.equals(Backbtn.getText()))
		{
			DoctorFrame df = new DoctorFrame(this.user);
			df.setVisible(true);
			this.setVisible(false);			
		}			
		else{System.exit(0);}*/


    public int getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(int prescriptionId) {
        this.prescriptionId = prescriptionId;
    }


}