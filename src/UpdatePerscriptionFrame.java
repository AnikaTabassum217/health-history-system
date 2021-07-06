//package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import repository.*;
//import entity.*;

public class UpdatePerscriptionFrame extends JFrame implements ActionListener{
	
	JLabel title, idLabel, patientIdLabel,doctorIdLabel,pharmacistIdLabel,medicineListLabel,
	nextVisitingDateLabel,diseaseLabel;
	
	JTextField idTF,patientIdTF,doctorIdTF,pharmacistIdTF,medicineListTF,
	nextVisitingDateTF,diseaseTF;
	
	JButton submitBtn, Logoutbtn,Backbtn;
	JPanel panel;
	Users user;
	
	public UpdatePerscriptionFrame(Users user)
	{
		super("Update Perscription Frame");
		this.user = user;
		
		this.setSize(400, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		title = new JLabel("Update Perscription Frame");
		title.setBounds(40,0, 200, 30);
		panel.add(title);
		
		idLabel = new JLabel("Update ID");
		idLabel.setBounds(20, 70, 100, 30);
		panel.add(idLabel);
		
		idTF = new JTextField();
		idTF.setBounds(120, 70, 100, 30);
		panel.add(idTF);
		
		patientIdLabel = new JLabel("Patient ID");
		patientIdLabel.setBounds(20, 130, 100, 30);
		panel.add(patientIdLabel);
		
		patientIdTF = new JTextField();
		patientIdTF.setBounds(120, 130, 100, 30);
		panel.add(patientIdTF);
		
		doctorIdLabel = new JLabel("Doctor ID");
		doctorIdLabel.setBounds(20, 190, 100, 30);
		panel.add(doctorIdLabel);
		
		doctorIdTF = new JTextField();
		doctorIdTF.setBounds(120, 190, 100, 30);
		panel.add(doctorIdTF);
		
		pharmacistIdLabel = new JLabel("Assistant ID");
		pharmacistIdLabel.setBounds(20, 250, 100, 30);
		panel.add(pharmacistIdLabel);
		
		pharmacistIdTF = new JTextField();
		pharmacistIdTF.setBounds(120, 250, 100, 30);
		panel.add(pharmacistIdTF);
		
		nextVisitingDateLabel = new JLabel("Visiting Date");
		nextVisitingDateLabel.setBounds(20, 310, 100, 30);
		panel.add(nextVisitingDateLabel);
		
		nextVisitingDateTF = new JTextField();
		nextVisitingDateTF.setBounds(120, 310, 100, 30);
		panel.add(nextVisitingDateTF);

		diseaseLabel = new JLabel("Diesease Name");
		diseaseLabel.setBounds(20, 370, 100, 30);
		panel.add(diseaseLabel);


		diseaseTF = new JTextField();
		diseaseTF.setBounds(120, 370, 100, 30);
		panel.add(diseaseTF);
		
		submitBtn = new JButton("Submit");
		submitBtn.setBounds(20, 490, 100, 30);
		submitBtn.addActionListener(this);
		panel.add(submitBtn);	

        Logoutbtn = new JButton("Logout");
		Logoutbtn.setBounds(220, 490, 100, 30);
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

			String Id = idTF.getText();

			String patientId = patientIdTF.getText();


			String doctorId = doctorIdTF.getText();


			String assistantId = pharmacistIdTF.getText();



			String visitingDate = nextVisitingDateTF.getText();


			String diseaseName = diseaseTF.getText();


			AssistantPrescription assistantPrescription = new AssistantPrescription();
			assistantPrescription.setId(Integer.parseInt(Id));
			assistantPrescription.setPatientId(Integer.parseInt(patientId));
			assistantPrescription.setDoctorId(Integer.parseInt(doctorId));
			assistantPrescription.setAssistantId(Integer.parseInt(assistantId));
			assistantPrescription.setVisitingDate(visitingDate);
			assistantPrescription.setDiseaseName(diseaseName);


			AssistantPrescriptionRepo apr  = new AssistantPrescriptionRepo ();
			apr.updatePrescriptionByAssistant(assistantPrescription);

			patientIdTF.setText("");
			doctorIdTF.setText("");
			pharmacistIdTF.setText("");
			nextVisitingDateTF.setText("");
			diseaseTF.setText("");


		}


	}
}