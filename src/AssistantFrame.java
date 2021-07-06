//package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
//import repository.*;
//import entity.*;

public class AssistantFrame extends JFrame implements ActionListener {
	
	JLabel title, nameLabel, ageLabel,passwordLabel;
	JTextField nameTF,ageTF,passwordTF;
	
	JButton submitBtn, Logoutbtn,Backbtn,newpatientBtn,oldPatientBtn,medicineBtn;
	JPanel panel;
	Users user;
	
	public AssistantFrame(Users user)
	{
		super("Assistant Frame");
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
		panel.add(passwordTF);				
		
		submitBtn = new JButton("Submit");
		submitBtn.setBounds(20, 300, 100, 30);
		submitBtn.addActionListener(this);
		panel.add(submitBtn);*/	
		
		
		newpatientBtn = new JButton("New Patient");
		newpatientBtn.setBounds(120, 70, 150, 30);
		newpatientBtn.addActionListener(this);
		panel.add(newpatientBtn);
		
		oldPatientBtn = new JButton("Old Patient");
		oldPatientBtn.setBounds(120, 130, 150, 30);
		oldPatientBtn.addActionListener(this);
		panel.add(oldPatientBtn);

		medicineBtn = new JButton("Medicine");
		medicineBtn.setBounds(120, 190, 150, 30);
		medicineBtn.addActionListener(this);
		panel.add(medicineBtn);
		

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
		
		else if(command.equals(newpatientBtn.getText()))
		{
			AssistantPerscriptionFrame pf = new AssistantPerscriptionFrame(this.user);
			pf.setVisible(true);
			this.setVisible(false);			
		}	
		else if(command.equals(oldPatientBtn.getText()))
		{
			UpdatePerscriptionFrame upf = new UpdatePerscriptionFrame(this.user);
			upf.setVisible(true);
			this.setVisible(false);			
		}

		else if(command.equals(medicineBtn.getText()))
		{
			AssistantMedicineFrame amf = new AssistantMedicineFrame(this.user);
			amf.setVisible(true);
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
		else{System.exit(0);}*/
	}
}