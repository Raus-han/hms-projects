
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener{
    
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;
        Reception(){
            b1 = new JButton("New Customer Form");
            b1.setBackground(Color.BLACK);
            b1.setForeground(Color.WHITE);
            b1.addActionListener(this);
            b1.setBounds(10,30,150,30);
            add(b1);
            
            b2 = new JButton("Room");
            b2.setBackground(Color.BLACK);
            b2.setForeground(Color.WHITE);
            b2.addActionListener(this);
            b2.setBounds(10,70,150,30);
            add(b2);
            
            b3 = new JButton("Department");
            b3.setBackground(Color.BLACK);
            b3.setForeground(Color.WHITE);
            b3.addActionListener(this);
            b3.setBounds(10,110,150,30);
            add(b3);
            
            b4 = new JButton("All Employee Info");
            b4.setBackground(Color.BLACK);
            b4.setForeground(Color.WHITE);
            b4.addActionListener(this);
            b4.setBounds(10,150,150,30);
            add(b4);
            
            b5 = new JButton("Customer Info");
            b5.setBackground(Color.BLACK);
            b5.setForeground(Color.WHITE);
            b5.addActionListener(this);
            b5.setBounds(10,190,150,30);
            add(b5);
            
            b6 = new JButton("Manager Info");
            b6.setBackground(Color.BLACK);
            b6.setForeground(Color.WHITE);
            b6.addActionListener(this);
            b6.setBounds(10,230,150,30);
            add(b6);
            
            b7 = new JButton("Check Out");
            b7.setBackground(Color.BLACK);
            b7.setForeground(Color.WHITE);
            b7.addActionListener(this);
            b7.setBounds(10,270,150,30);
            add(b7);
            
            b8 = new JButton("Update Check Status");
            b8.setBackground(Color.BLACK);
            b8.setForeground(Color.WHITE);
            b8.addActionListener(this);
            b8.setBounds(10,310,150,30);
            add(b8);
            
            b9 = new JButton("Update Room Status");
            b9.setBackground(Color.BLACK);
            b9.setForeground(Color.WHITE);
            b9.addActionListener(this);
            b9.setBounds(10,350,150,30);
            add(b9);
            
            b10 = new JButton("Pick Up Service");
            b10.setBackground(Color.BLACK);
            b10.setForeground(Color.WHITE);
            b10.addActionListener(this);
            b10.setBounds(10,390,150,30);
            add(b10);
            
            b11 = new JButton("Search Room");
            b11.setBackground(Color.BLACK);
            b11.setForeground(Color.WHITE);
            b11.addActionListener(this);
            b11.setBounds(10,430,150,30);
            add(b11);
            
            b12 = new JButton("Logout");
            b12.setBackground(Color.BLACK);
            b12.setForeground(Color.WHITE);
            b12.addActionListener(this);
            b12.setBounds(10,470,150,30);
            add(b12);
            
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/fourth.jpg"));
        JLabel l3 = new JLabel(i1);
        l3.setBounds(190,30,490,470);
        add(l3);
            
            
            
            getContentPane().setBackground(Color.WHITE);
        
            setLayout(null);
            setBounds(415,170,720,550);
            setVisible(true);
     
    }
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == b1){
                new AddCustomer().setVisible(true);
                this.setVisible(false);
            }else if(ae.getSource() == b2){
                new Room().setVisible(true);
                this.setVisible(false);
            }else if(ae.getSource() == b3){
                new Department().setVisible(true);
                this.setVisible(false);
              
            }else if(ae.getSource() == b4){
                new EmployeeInfo().setVisible(true);
                this.setVisible(false);
            
            }else if(ae.getSource() == b5){
                new CustomerInfo().setVisible(true);
                this.setVisible(false);
            }else if(ae.getSource() == b6){
               new ManagerInfo().setVisible(true);
                this.setVisible(false);
            }else if(ae.getSource() == b7){
                new CheckOut().setVisible(true);
                this.setVisible(false);
            
            }else if(ae.getSource() == b8){
                new UpdateCheck().setVisible(true);
                this.setVisible(false);
            
            }else if(ae.getSource() == b9){
                new UpdateRoom().setVisible(true);
                this.setVisible(false);
            
            }else if(ae.getSource() == b10){
                new PickUp().setVisible(true);
                this.setVisible(false);
            
            }else if(ae.getSource() == b11){
                new SearchRoom().setVisible(true);
                this.setVisible(false);
            
            }else if(ae.getSource() == b12){
               setVisible(false);
                       
            }
            
        }
    public static void main(String[] args){
        new Reception().setVisible(true);
    }
}
