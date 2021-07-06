//package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import repository.*;
//import entity.*;

public class DoctorFrame extends JFrame implements ActionListener{
	
	JLabel title, nameLabel, ageLabel,passwordLabel;
	JTextField nameTF,ageTF,passwordTF;
	
	JButton submitBtn, Logoutbtn,Backbtn, viewPatientrecordBtn, changePowerOfMedicineBtn,perscribeMedicineBtn;
	JPanel panel;
	Users user;
	
	public DoctorFrame(Users user)
	{
		super("Doctor Frame");
		this.user = user;
		
		this.setSize(400, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		title = new JLabel("");
		title.setBounds(20, 20, 100, 30 );
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
		panel.add(passwordTF);	*/

		viewPatientrecordBtn = new JButton("View Patient Record");
		viewPatientrecordBtn.setBounds(120, 70, 200, 30);
		viewPatientrecordBtn.addActionListener(this);
		panel.add(viewPatientrecordBtn);
		
		changePowerOfMedicineBtn = new JButton("Change Power Of Medicine");
		changePowerOfMedicineBtn.setBounds(120, 130, 200, 30);
		changePowerOfMedicineBtn.addActionListener(this);
		panel.add(changePowerOfMedicineBtn);
		
		//perscribeMedicineBtn = new JButton("Perscribe Medicine");
		//perscribeMedicineBtn.setBounds(120, 190, 200, 30);
		//perscribeMedicineBtn.addActionListener(this);
		//panel.add(perscribeMedicineBtn);
		
		
		
		//submitBtn = new JButton("Submit");
		//submitBtn.setBounds(20, 300, 100, 30);
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
		else if(command.equals(changePowerOfMedicineBtn.getText()))
		{
			DoctorSelectMedicineFrame dsmf = new DoctorSelectMedicineFrame(this.user);
			dsmf.setVisible(true);
			this.setVisible(false);
		}

		else if(command.equals(viewPatientrecordBtn.getText()))
		{
			DoctorSelectPatientFrame dspf = new DoctorSelectPatientFrame(this.user);
			dspf.setVisible(true);
			this.setVisible(false);			
		}
		
		/*if(command.equals(submitBtn.getText()))
		{
			UsersRepo ur = new UsersRepo();			
			
			Users user = new Users();
			
			user.setName(nameTF.getText());
			user.setAge(Integer.parseInt(ageTF.getText()));
			user.setPassward(passwordTF.getText());
			user.setType("PATIENT");
			
			try{
				ur.insertUser(user);		
								
				JOptionPane.showMessageDialog(this, "Patient created");	
				
				nameTF.setText("");
				ageTF.setText("");
				passwordTF.setText("");
				
			} catch(Exception e) {
				JOptionPane.showMessageDialog(this, "Patient creation failed");
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