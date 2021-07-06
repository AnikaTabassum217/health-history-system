//package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
//import repository.*;
//import entity.*;

public class PatientFrame extends JFrame implements ActionListener{
	
	JLabel title, nameLabel, ageLabel,passwordLabel,updateIDLabel;
	JTextField nameTF,ageTF,passwordTF,updateIDTF;
	
	JButton submitBtn, Logoutbtn,Backbtn, viewOwnRecordBtn,viewPerscribeMedicineBtn,updatePersonalInfoBtn,
	printPerscriptionBtn;
	JPanel panel;
	Users user;
	
	public PatientFrame(Users user)
	{
		super("Patient Frame");
		this.user = user;
		
		this.setSize(400, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		title = new JLabel("Patient Frame");
		title.setBounds(40, 20, 100, 30 );
		panel.add(title);
		
		/*updateIDLabel = new JLabel("Update ID");
		updateIDLabel.setBounds(20, 100, 100, 30);
		panel.add(updateIDLabel);
		
		updateIDTF = new JTextField("");
		updateIDTF.setBounds(120, 100, 100, 30);
		panel.add(updateIDTF);
		
		nameLabel = new JLabel("Name");
		nameLabel.setBounds(20, 150, 100, 30);
		panel.add(nameLabel);
		
		nameTF = new JTextField();
		nameTF.setBounds(120, 150, 100, 30);
		panel.add(nameTF);
		
		ageLabel = new JLabel("Age");
		ageLabel.setBounds(20, 200, 100, 30);
		panel.add(ageLabel);
		
		ageTF = new JTextField();
		ageTF.setBounds(120, 200, 100, 30);
		panel.add(ageTF);
		
		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(20, 250, 100, 30);
		panel.add(passwordLabel);
		
		passwordTF = new JTextField();
		passwordTF.setBounds(120, 250, 100, 30);
		panel.add(passwordTF);	*/	

		viewOwnRecordBtn = new JButton("View Own Record");
		viewOwnRecordBtn.setBounds(120, 70, 200, 30);
		viewOwnRecordBtn.addActionListener(this);
		panel.add(viewOwnRecordBtn);
		
		viewPerscribeMedicineBtn = new JButton("View Perscribe Medicine");
		viewPerscribeMedicineBtn.setBounds(120, 120, 200, 30);
		viewPerscribeMedicineBtn.addActionListener(this);
		panel.add(viewPerscribeMedicineBtn);
		
		updatePersonalInfoBtn = new JButton("Update Personal Information");
		updatePersonalInfoBtn.setBounds(120, 170, 200, 30);
		updatePersonalInfoBtn.addActionListener(this);
		panel.add(updatePersonalInfoBtn);
		
		
		/*printPerscriptionBtn = new JButton("Print Perscription");
		printPerscriptionBtn.setBounds(120, 220, 200, 30);
		printPerscriptionBtn.addActionListener(this);
		panel.add(printPerscriptionBtn);*/
		
		
		
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
		
		else if(command.equals(updatePersonalInfoBtn.getText()))
		{
			UpdatePersonalFrame upif = new UpdatePersonalFrame(this.user);
			upif.setVisible(true);
			this.setVisible(false);			
		}

		else if(command.equals(viewOwnRecordBtn.getText()))
		{
			MedicalTestFrame mtf = new MedicalTestFrame(this.user);
			mtf.setVisible(true);
			this.setVisible(false);
		}
		else if(command.equals(viewPerscribeMedicineBtn.getText()))
		{
			PatientMedicineFrame pmf = new PatientMedicineFrame(this.user);
			pmf.setVisible(true);
			this.setVisible(false);
		}
		
		/*if(command.equals(submitBtn.getText()))
		{
			UsersRepo ur = new UsersRepo();			
			
			Users user = new Users();
			user.setID(Integer.parseInt(updateIDTF.getText()));
			user.setName(nameTF.getText());
			user.setAge(Integer.parseInt(ageTF.getText()));
			user.setPassward(passwordTF.getText());
			user.setType("PATIENT");
			
			try{
				ur.updateUser(user);		
								
				JOptionPane.showMessageDialog(this, "Patient updated");	
				
				nameTF.setText("");
				ageTF.setText("");
				passwordTF.setText("");
				updateIDTF.setText("");	
				
			} catch(Exception e) {
				JOptionPane.showMessageDialog(this, "Patient update failed");
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