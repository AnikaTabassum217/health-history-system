//package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import repository.*;
//import entity.*;

public class PharmacistFrame extends JFrame implements ActionListener{
	
	JLabel title, nameLabel, ageLabel,passwordLabel,timeLabel,qualificationLabel,feesLabel;
	JTextField nameTF,ageTF,passwordTF,timeTF,qualificationTF,feesTF;
	
	JButton submitBtn,Logoutbtn,Backbtn,giveMedicineBtn,searchPatientinfoBtn,viewPatientRecordBtn,
	viewDonorListBtn,contactDonorBtn;
	JPanel panel;
	Users user;
	
	public PharmacistFrame(Users user)
	{
		super("Pharmacist Frame");
		this.user = user;
		
		this.setSize(400, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		title = new JLabel("Pharmacist Frame");
		title.setBounds(40,0, 150, 30);
		panel.add(title);
		
		/*nameLabel = new JLabel("Name");
		nameLabel.setBounds(20, 70, 100, 30);
		panel.add(nameLabel);
		
		nameTF = new JTextField();
		nameTF.setBounds(120, 70, 100, 30);
		panel.add(nameTF);
		
		ageLabel = new JLabel("Age");
		ageLabel.setBounds(20, 130, 100, 30);
		panel.add(ageLabel);
		
		ageTF = new JTextField();
		ageTF.setBounds(120, 130, 100, 30);
		panel.add(ageTF);
		
		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(20, 190, 100, 30);
		panel.add(passwordLabel);
		
		passwordTF = new JTextField();
		passwordTF.setBounds(120, 190, 100, 30);
		panel.add(passwordTF);
		
		timeLabel = new JLabel("Time");
		timeLabel.setBounds(20, 250, 100, 30);
		panel.add(timeLabel);
		
		timeTF = new JTextField();
		timeTF.setBounds(120, 250, 100, 30);
		panel.add(timeTF);
		
		qualificationLabel = new JLabel("Qualification");
		qualificationLabel.setBounds(20, 310, 100, 30);
		panel.add(qualificationLabel);
		
		qualificationTF = new JTextField();
		qualificationTF.setBounds(120, 310, 100, 30);
		panel.add(qualificationTF);
		
		feesLabel = new JLabel("Fees");
		feesLabel.setBounds(20, 370, 100, 30);
		panel.add(feesLabel);
		
		feesTF = new JTextField();
		feesTF.setBounds(120, 370, 100, 30);
		panel.add(feesTF);	*/	

        /*giveMedicineBtn = new JButton("Give Medicine");
		giveMedicineBtn.setBounds(120, 70, 200, 30);
		giveMedicineBtn.addActionListener(this);
		panel.add(giveMedicineBtn);	*/


        searchPatientinfoBtn = new JButton("Search Patient Information");
		searchPatientinfoBtn.setBounds(120, 100, 200, 30);
		searchPatientinfoBtn.addActionListener(this);
		panel.add(searchPatientinfoBtn);
		
		//viewPatientRecordBtn = new JButton("View Patient Record");
		//viewPatientRecordBtn.setBounds(120, 70, 200, 30);
		//viewPatientRecordBtn.addActionListener(this);
		//panel.add(viewPatientRecordBtn);
		
		viewDonorListBtn = new JButton("View Donor List");
		viewDonorListBtn.setBounds(120, 150, 200, 30);
		viewDonorListBtn.addActionListener(this);
		panel.add(viewDonorListBtn);
		
		/*contactDonorBtn = new JButton("Contact Donor");
		contactDonorBtn.setBounds(120, 310, 200, 30);
		contactDonorBtn.addActionListener(this);
		panel.add(contactDonorBtn);*/
		
		
		
		//submitBtn = new JButton("Submit");
		//submitBtn.setBounds(20, 430, 100, 30);
		//submitBtn.addActionListener(this);
		//panel.add(submitBtn);	

        Logoutbtn = new JButton("Logout");
		Logoutbtn.setBounds(220, 300, 100, 30);
		Logoutbtn.addActionListener(this);
		panel.add(Logoutbtn);		
		
		Backbtn = new JButton("Back");
		Backbtn.setBounds(220, 350, 100, 30);
		//Backbtn.addActionListener(this);
		panel.add(Backbtn);		
			
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(Logoutbtn.getText()))
		{			
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);				
		}
		
		else if(command.equals(viewDonorListBtn.getText()))
		{			
			DonorListFrame dlf = new DonorListFrame(this.user);
			dlf.setVisible(true);
			this.setVisible(false);				
		}
		
		else if(command.equals(searchPatientinfoBtn.getText()))
		{			
			SelectPatientFrame spf = new SelectPatientFrame(this.user);
			spf.setVisible(true);
			this.setVisible(false);				
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
		else{System.exit(0);} */
	}
}