//package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import repository.*;
//import entity.*;

public class AssistantPerscriptionFrame extends JFrame implements ActionListener{
	
	JLabel title, idLabel, patientIdLabel,doctorIdLabel,pharmacistIdLabel,medicineListLabel,
	nextVisitingDateLabel,diseaseLabel;
	
	JTextField idTF,patientIdTF,doctorIdTF,pharmacistIdTF,medicineListTF,
	nextVisitingDateTF,diseaseLabelTF;
	
	JButton submitBtn, Logoutbtn,Backbtn;
	JPanel panel;
	Users user;
	
	public AssistantPerscriptionFrame(Users user)
	{
		super("Assistant Perscription Frame");
		this.user = user;
		
		this.setSize(400, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		title = new JLabel("Assistant Perscription Frame");
		title.setBounds(40,0, 150, 30);
		panel.add(title);
		
		/*idLabel = new JLabel("ID");
		idLabel.setBounds(20, 70, 100, 30);
		panel.add(idLabel);
		
		idTF = new JTextField();
		idTF.setBounds(120, 70, 100, 30);
		panel.add(idTF);*/
		
		patientIdLabel = new JLabel("Patient ID");
		patientIdLabel.setBounds(20, 70, 100, 30);
		panel.add(patientIdLabel);
		
		patientIdTF = new JTextField();
		patientIdTF.setBounds(120, 70, 100, 30);
		panel.add(patientIdTF);
		
		doctorIdLabel = new JLabel("Doctor ID");
		doctorIdLabel.setBounds(20, 130, 100, 30);
		panel.add(doctorIdLabel);
		
		doctorIdTF = new JTextField();
		doctorIdTF.setBounds(120, 130, 100, 30);
		panel.add(doctorIdTF);
		
		pharmacistIdLabel = new JLabel("Assistant ID");
		pharmacistIdLabel.setBounds(20, 190, 100, 30);
		panel.add(pharmacistIdLabel);
		
		pharmacistIdTF = new JTextField();
		pharmacistIdTF.setBounds(120, 190, 100, 30);
		panel.add(pharmacistIdTF);
		
		/*medicineListLabel = new JLabel("Medicine List");
		medicineListLabel.setBounds(20, 250, 100, 30);
		panel.add(medicineListLabel);
		
		medicineListTF = new JTextField();
		medicineListTF.setBounds(120, 250, 100, 30);
		panel.add(medicineListTF);*/
		
		nextVisitingDateLabel = new JLabel("Visiting Date");
		nextVisitingDateLabel.setBounds(20, 250, 100, 30);
		panel.add(nextVisitingDateLabel);
		
		nextVisitingDateTF = new JTextField();
		nextVisitingDateTF.setBounds(120, 250, 100, 30);
		panel.add(nextVisitingDateTF);

		diseaseLabel= new JLabel("Disease Name");
		diseaseLabel.setBounds(20, 310, 100, 30);
		panel.add(diseaseLabel);


		diseaseLabelTF = new JTextField();
		diseaseLabelTF.setBounds(120, 310, 100, 30);
		panel.add(diseaseLabelTF);
		
		submitBtn = new JButton("Submit");
		submitBtn.setBounds(20, 430, 100, 30);
		submitBtn.addActionListener(this);
		panel.add(submitBtn);	

        Logoutbtn = new JButton("Logout");
		Logoutbtn.setBounds(220, 430, 100, 30);
		//Logoutbtn.addActionListener(this);
		panel.add(Logoutbtn);		
		
		Backbtn = new JButton("Back");
		Backbtn.setBounds(220, 480, 100, 30);
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


			 String patientId = patientIdTF.getText();


			 String doctorId = doctorIdTF.getText();


			 String assistantId = pharmacistIdTF.getText();



			 String visitingDate = nextVisitingDateTF.getText();


			 String diseaseName = diseaseLabelTF.getText();


			 AssistantPrescription assistantPrescription = new AssistantPrescription();
			 assistantPrescription.setPatientId(Integer.parseInt(patientId));
			 assistantPrescription.setDoctorId(Integer.parseInt(doctorId));
			 assistantPrescription.setAssistantId(Integer.parseInt(assistantId));
			 assistantPrescription.setVisitingDate(visitingDate);
			 assistantPrescription.setDiseaseName(diseaseName);


			 AssistantPrescriptionRepo apr  = new AssistantPrescriptionRepo ();
			 apr.insertPrescriptionByAssistant(assistantPrescription);

			 patientIdTF.setText("");
			 doctorIdTF.setText("");
			 pharmacistIdTF.setText("");
			 nextVisitingDateTF.setText("");
			 diseaseLabelTF.setText("");


		 }

		
		/*if(command.equals(submitBtn.getText()))
		{
			UsersRepo ur = new UsersRepo();
			Doctors_DetailsRepo ddr = new Doctors_DetailsRepo();
			
			Users user = new Users();
			
			user.setName(nameTF.getText());
			user.setAge(Integer.parseInt(ageTF.getText()));
			user.setPassward(passwordTF.getText());
			user.setType("DOCTOR");
			
			try{
				ur.insertUser(user);							
				
				user = ur.getUser(nameTF.getText(), passwordTF.getText());
				
				Doctors_Details dd = new Doctors_Details();
				
				dd.setDoctorID(user.getID());
				dd.setTime(timeTF.getText());
				dd.setQualification(qualificationTF.getText());
				dd.setFees(Double.parseDouble(feesTF.getText()));
				
				ddr.insertDoctor(dd);
				
				JOptionPane.showMessageDialog(this, "Doctor created");

				nameTF.setText("");
				ageTF.setText("");
				passwordTF.setText("");	
				timeTF.setText("");					
				qualificationTF.setText("");	
				feesTF.setText("");					
				
			} catch(Exception e) {
				JOptionPane.showMessageDialog(this, "Doctor creation failed");
			}			
		}
		else if(command.equals(Logoutbtn.getText()))
		{			
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);				
		}
		else if(command.equals(Backbtn.getText()))
		{
			AdminFrame af = new AdminFrame();
			af.setVisible(true);
			this.setVisible(false);			
		}				
		else{System.exit(0);}*/
	}
}