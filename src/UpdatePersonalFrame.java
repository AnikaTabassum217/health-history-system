//package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import repository.*;
//import entity.*;

public class UpdatePersonalFrame extends JFrame implements ActionListener{
	
	JLabel title, userNameLabel, firstNameLabel,lastNameLabel,passwordLabel;
	JTextField userNameTF,firstNameTF,lastNameTF,passwordTF;
	
	JButton submitBtn, Logoutbtn,Backbtn;
	JPanel panel;
	Users user;
	
	public UpdatePersonalFrame(Users user)
	{
		super("Update Personal Information Frame");
		this.user = user;
		
		this.setSize(400, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		title = new JLabel("");
		title.setBounds(20, 20, 100, 30 );
		panel.add(title);

		/*updateIDLabel = new JLabel("Update ID");
		updateIDLabel.setBounds(20, 20, 100, 30);
		panel.add(updateIDLabel);

		updateIDTF = new JTextField();
		updateIDTF.setBounds(120, 20, 100, 30);
		panel.add(updateIDTF);*/

		userNameLabel = new JLabel("User Name");
		userNameLabel.setBounds(20, 70, 100, 30);
		panel.add(userNameLabel);

		userNameTF = new JTextField();
		userNameTF.setBounds(120, 70, 100, 30);
		userNameTF.setText(this.user.getuserName());
		panel.add(userNameTF);

		firstNameLabel = new JLabel("First Name");
		firstNameLabel.setBounds(20, 130, 100, 30);
		panel.add(firstNameLabel);

		firstNameTF = new JTextField();
		firstNameTF.setBounds(120, 130, 100, 30);
		firstNameTF.setText(this.user.getfirstName());
		panel.add(firstNameTF);

		lastNameLabel = new JLabel("Last Name");
		lastNameLabel.setBounds(20, 190, 100, 30);
		panel.add(lastNameLabel);

		lastNameTF = new JTextField();
		lastNameTF.setBounds(120, 190, 100, 30);
		lastNameTF.setText(this.user.getlastName());
		panel.add(lastNameTF);

		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(20, 250, 100, 30);
		panel.add(passwordLabel);

		passwordTF = new JTextField();
		passwordTF.setBounds(120, 250, 100, 30);
		passwordTF.setText(this.user.getPassword());
		panel.add(passwordTF);

		submitBtn = new JButton("Submit");
		submitBtn.setBounds(20, 300, 100, 30);
		submitBtn.addActionListener(this);
		panel.add(submitBtn);	

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
			PatientFrame pf = new PatientFrame(this.user);
			pf.setVisible(true);
			this.setVisible(false);			
		}

		else if(command.equals(submitBtn.getText()))
		{


			String firstName = firstNameTF.getText();
			this.user.setfirstName(firstName);

			String lastName = lastNameTF.getText();
			this.user.setlastName(lastName);

			String userName = userNameTF.getText();
			this.user.setName(userName);

			String password = passwordTF.getText();
			this.user.setPassword(password);


			UsersRepo usersRepo = new UsersRepo();
			usersRepo.updateUser(this.user);

			firstNameTF.setText("");
			userNameTF.setText("");
			lastNameTF.setText("");
			passwordTF.setText("");


		}
		

	}
}