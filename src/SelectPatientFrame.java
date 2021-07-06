//package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import repository.*;
//import entity.*;

public class SelectPatientFrame extends JFrame implements ActionListener{
	
	JLabel title, IDLabel;
	JTextField IDTF;
	
	JButton submitBtn,Logoutbtn,Backbtn;
	JPanel panel;
	Users user;
	
	public SelectPatientFrame(Users user)
	{
		super("Select Patient Frame");
		this.user = user;
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		title = new JLabel("Select Patient");
		title.setBounds(40,0, 100, 30);
		panel.add(title);
		
		IDLabel = new JLabel("ID");
		IDLabel.setBounds(20,40, 50, 30);
		panel.add(IDLabel);
		
		IDTF = new JTextField("");
		IDTF.setBounds(80,40, 100, 30);
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
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(submitBtn.getText()))
		{
			PrescriptionFrame pf = new PrescriptionFrame(this.user);
			int patientId = Integer.parseInt(IDTF.getText());//After passing any type of value in text field it will get String type. so we use Integer.parseInt from String to int as it is a patientID
			pf.setPatientId(patientId);//we set patientId in SelectPatientFrame and from this frame we pass into PrescriptionFrame
			pf.setVisible(true);
			this.setVisible(false);
		}
		else if(command.equals(Logoutbtn.getText()))
		{			
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);				
		}
		else if(command.equals(Backbtn.getText()))
		{
			PharmacistFrame pf = new PharmacistFrame(this.user);
			pf.setVisible(true);
			this.setVisible(false);			
		}			
		else{System.exit(0);}
	}
}