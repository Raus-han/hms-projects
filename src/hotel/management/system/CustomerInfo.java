
package hotel.management.system;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;

import net.proteanit.sql.*;


public class CustomerInfo extends JFrame implements ActionListener {
    
    JTable t1;
    JButton b1,b2;
        
    CustomerInfo(){
        
        t1 = new JTable();
        t1.setBounds(0,40,885,410);
        add(t1);
        
        JLabel l1 = new JLabel("Document");
        l1.setBounds(25,10,70,20);
        add(l1);
        
        JLabel l2 = new JLabel("Number");
        l2.setBounds(140,10,70,20);
        add(l2);
        
        JLabel l3 = new JLabel("Name");
        l3.setBounds(260,10,70,20);
        add(l3);
        
        JLabel l4 = new JLabel("Gender");
        l4.setBounds(365,10,70,20);
        add(l4);
        
        JLabel l5 = new JLabel("Country");
        l5.setBounds(475,10,70,20);
        add(l5);
        
        JLabel l6 = new JLabel("Room Number");
        l6.setBounds(565,10,90,20);
        add(l6);
        
        JLabel l7 = new JLabel("Checked In");
        l7.setBounds(685,10,70,20);
        add(l7);
        
        JLabel l8 = new JLabel("Deposit");
        l8.setBounds(805,10,70,20);
        add(l8);
        
        
        
   
        b1 = new JButton("Load Data");
        b1.setBounds(310,460,120,25);
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
        setBounds(340,180,900,530);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
          try{
              conn c = new conn();
              String str = "Select * from customer";
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
        new CustomerInfo().setVisible(true);
    }
}
