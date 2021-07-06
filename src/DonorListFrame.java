//package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
//import repository.*;
//import entity.*;

public class DonorListFrame extends JFrame implements ActionListener {

    private JButton Backbtn, exitBtn, getAllBtn;
    private JTable DonorTable;
    private JScrollPane DonorTableSP;
    private JPanel panel;
    Users user;

    public DonorListFrame(Users user) {
        super("Donor List Frame");
        this.user = user;
        this.setSize(800, 450);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        panel = new JPanel();
        panel.setLayout(null);

        String data[][] = {{"", "", "", "", "", "", "",""}};

        String head[] = {"Id", "Name", "Date Of Birth", "Blood Group","Email", "Conatact No", "Address","Pharmacist ID"};

//        DonorTable = new JTable(data, head);
//        DonorTableSP = new JScrollPane(DonorTable);
//        DonorTableSP.setBounds(350, 200, 100, 150);
//        DonorTable.setEnabled(false);
//        panel.add(DonorTableSP);

        getAllBtn = new JButton("Get All");
        getAllBtn.setBounds(500, 260, 80, 30);
        getAllBtn.addActionListener(this);
        panel.add(getAllBtn);

        Backbtn = new JButton("Back");
        Backbtn.setBounds(600, 350, 80, 30);
        Backbtn.addActionListener(this);
        panel.add(Backbtn);

        this.add(panel);
    }

    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();

        System.out.println(command);

        if (command.equals(getAllBtn.getText())) {

            DonorRepo donorRepo = new DonorRepo();
            ArrayList<Donor> donorData = donorRepo.getDonorList( );
            Object data[][] = new Object[donorData.size()][7];
            String head[] = {"Id", "Name", "Date Of Birth", "Blood Group","Email", "Conatact No", "Address"};

            for(int i=0;i<donorData.size();i++) {
                data[i][0] = donorData.get(i).getId();
                data[i][1] = donorData.get(i).getDonorName();
                data[i][2] = donorData.get(i).getDateOfBirth();
                data[i][3] = donorData.get(i).getBloodGroup();
                data[i][4] = donorData.get(i).getDonorEmail();
                data[i][5] = donorData.get(i).getDonorEmail();
                data[i][6] = donorData.get(i).getDonorGender();
            }

            DonorTable = new JTable(data, head);
            DonorTable.setEnabled(false);
            DonorTableSP = new JScrollPane(DonorTable);
            DonorTableSP.setBounds(150, 100, 600, 150);
            panel.add(DonorTableSP);

            panel.revalidate();
            panel.repaint();
        } else if (command.equals(Backbtn.getText())) {
            PharmacistFrame pf = new PharmacistFrame(this.user);
            pf.setVisible(true);
            this.setVisible(false);
        }
    }

}