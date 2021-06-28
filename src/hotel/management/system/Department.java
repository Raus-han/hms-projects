
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class Department extends JFrame implements ActionListener{
   
    
    JTable t1;
    JButton b1,b2;
    
    Department(){
        
       
        
        t1 = new JTable();
        t1.setBounds(0,50,650,300);
        add(t1);
        
         b1 = new JButton("Submit");
        b1.setBounds(120,400,120,27);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBounds(370,400,120,27);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);
        
        JLabel l3 = new JLabel("Department");
        l3.setBounds(130,10,100,20);
        l3.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(l3);
        
        JLabel l4 = new JLabel("Budget");
        l4.setBounds(440,10,100,20);
        l4.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(l4);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null); 
        setBounds(480,200,600,500);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            try{
                String str = "select * from department";
                
                conn c = new conn();
                ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
                
                
                
            }catch(Exception e){
                System.out.println(e);
            
            }
        }else if(ae.getSource() == b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[] args){
        new Department().setVisible(true);
    }
}
