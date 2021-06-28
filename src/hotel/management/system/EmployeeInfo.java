
package hotel.management.system;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;

import net.proteanit.sql.*;


public class EmployeeInfo extends JFrame implements ActionListener {
    
    JTable t1;
    JButton b1,b2;
        
    EmployeeInfo(){
        
        t1 = new JTable();
        t1.setBounds(0,40,885,410);
        add(t1);
        
        JLabel l1 = new JLabel("Name");
        l1.setBounds(40,10,70,20);
        add(l1);
        
        JLabel l2 = new JLabel("Age");
        l2.setBounds(160,10,70,20);
        add(l2);
        
        JLabel l3 = new JLabel("Gender");
        l3.setBounds(255,10,70,20);
        add(l3);
        
        JLabel l4 = new JLabel("Department");
        l4.setBounds(355,10,70,20);
        add(l4);
        
        JLabel l5 = new JLabel("Salary");
        l5.setBounds(475,10,70,20);
        add(l5);
        
        JLabel l6 = new JLabel("Phone_No.");
        l6.setBounds(575,10,70,20);
        add(l6);
        
        JLabel l7 = new JLabel("Aadhar");
        l7.setBounds(695,10,70,20);
        add(l7);
        
        JLabel l8 = new JLabel("Email");
        l8.setBounds(825,10,70,20);
        add(l8);
        
        
        
   
        b1 = new JButton("Load Data");
        b1.setBounds(330,460,120,25);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBounds(510,460,120,25);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);
        
        setLayout(null);
        setBounds(370,180,900,530);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
          try{
              conn c = new conn();
              String str = "Select * from employee";
              ResultSet rs = c.s.executeQuery(str);
              
              t1.setModel(DbUtils.resultSetToTableModel(rs));
              
          } catch (Exception e){
              
          } 
        }else if(ae.getSource() == b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[] args){
        new EmployeeInfo().setVisible(true);
    }
}
