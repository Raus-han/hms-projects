
package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.Font;
import java.sql.*;
import java.awt.event.*;
public class AddCustomer extends JFrame implements ActionListener {
    
    JTextField t1,t2,t3,t4,t5;
    JComboBox c1;
    JButton b1,b2;
    Choice c2;
    JRadioButton r1,r2;
    
    AddCustomer(){
        
        JLabel l1 = new JLabel("NEW CUSTOMER FORM");
        l1.setBounds(75,20,300,30);
        l1.setForeground(Color.BLUE);
        l1.setFont(new Font("Tahoma",Font.BOLD,20));
        add(l1);
        
        JLabel l2 = new JLabel("ID");
        l2.setBounds(35,80,100,20);
        add(l2);
        
        c1 = new JComboBox(new String[]{"Passport", "Voter-id Card","Driving License","Aadhar card"});
        c1.setBounds(200,80,150,25);
        c1.setBackground(Color.WHITE);
        add(c1);
        
        JLabel l3 = new JLabel("Number");
        l3.setBounds(35,120,100,20);
        add(l3);
        
        t1 = new JTextField();
        t1.setBounds(200,120,150,25);
        add(t1);
        
        JLabel l4 = new JLabel("Name");
        l4.setBounds(35,160,100,20);
        add(l4);
        
        t2 = new JTextField();
        t2.setBounds(200,160,150,25);
        add(t2);
        
        JLabel l5 = new JLabel("Gender");
        l5.setBounds(35,200,100,20);
        add(l5);
        r1 = new JRadioButton("Male");
        //r1.setFont(new Font("Tahoma",Font.PLAIN,14));
        r1.setBounds(210,200, 60, 25);
        r1.setBackground(Color.WHITE);
        add(r1);
        
        r2 = new JRadioButton("Female");
        //r2.setFont(new Font("Tahoma",Font.PLAIN,14));
        r2.setBounds(270,200,70,25);
        r2.setBackground(Color.WHITE);
        add(r2);
        
        JLabel l6 = new JLabel("Country");
        l6.setBounds(35,240,100,20);
        add(l6);
        
        t3 = new JTextField();
        t3.setBounds(200,240,150,25);
        add(t3);
        
        JLabel l7 = new JLabel("Allocated Room Number");
        l7.setBounds(35,280,150,25);
        add(l7);
        
        c2 = new Choice();
        try{
            conn c =new conn();
            String str = "Select * from room";
            ResultSet rs = c.s.executeQuery(str);
            while(rs.next()){
                c2.add(rs.getString("room_number"));
            }
        }catch (Exception e){}
        c2.setBounds(200,280,150,25);
        add(c2);
        
        JLabel l8 = new JLabel("Checked In");
        l8.setBounds(35,320,100,20);
        add(l8);
        
        t4 = new JTextField();
        t4.setBounds(200,320,150,25);
        add(t4);
        
        JLabel l9 = new JLabel("Deposit");
        l9.setBounds(35,360,100,20);
        add(l9);
        
        t5 = new JTextField();
        t5.setBounds(200,360,150,25);
        add(t5);
        
        b1 = new JButton("Add Customer");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        b1.setBounds(70,410,120,25);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        b2.setBounds(200,410,120,25);
        add(b2);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/fifth.png "));
        Image i2 = i1.getImage().getScaledInstance(300,400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(400,50,300,400);
        add(icon);
        
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        setBounds(370,180,800,550);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
      if(ae.getSource() == b1){
        String id = (String)c1.getSelectedItem();
        String number = t1.getText();
        String name = t2.getText();
        String gender = null;
        if(r1.isSelected()){
            gender = "Male";
        }else if(r2.isSelected()){
            gender = "Female";
        }
        String country = t3.getText();
        String room = c2.getSelectedItem();
        String status = t4.getText();
        String deposit = t5.getText();
        
        String str = "insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+status+"','"+deposit+"')";
        String str2 = "update room set available = 'Occupied' where room_number = '"+room+"'";
        try{
            conn c =new conn();
            c.s.executeUpdate(str);
            c.s.executeUpdate(str2);
            JOptionPane.showMessageDialog(null,"New Customer Added");
            new Reception().setVisible(true);
            this.setVisible(false);
        }catch(Exception e){}
        
        }else if(ae.getSource() == b2){
          new Reception().setVisible(true);
            this.setVisible(false);  
        }
        
    }
    public static void main(String[] args){
        new AddCustomer().setVisible(true);
    }
}
