
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AddDriver extends JFrame implements ActionListener{
    
    JTextField t1,t2,t3,t4,t5,t6;
    JComboBox c1,c2,c3;
    JRadioButton r1,r2;
    JButton b1,b2;
    
    AddDriver(){
        JLabel title = new JLabel("Add  Driver");
        title.setFont(new Font("Tahoma",Font.BOLD, 17));
        title.setBounds(150,20,200,20);
        add(title);
        
        JLabel name = new JLabel("Name");
        name.setFont(new Font("Tahoma",Font.PLAIN,17));
        name.setBounds(60,70,120,30);
        add(name);
        t1 = new JTextField();
        t1.setBounds(200,70,150,30);
        add(t1);
        
        JLabel age = new JLabel("Age");
        age.setFont(new Font("Tahoma",Font.PLAIN,17));
        age.setBounds(60,120,120,30);
        add(age);
        t2 = new JTextField();
        t2.setBounds(200,120,150,30);
        add(t2);
        
        JLabel gender = new JLabel("Gender");
        gender.setFont(new Font("Tahoma",Font.PLAIN,17));
        gender.setBounds(60,170,120,30);
        add(gender);
        c1 = new JComboBox(new String[]{"Male","Female"});
        c1.setBounds(200,170,150,30);
        c1.setBackground(Color.WHITE);
        add(c1);
        
        JLabel company = new JLabel("Car Company");
        company.setFont(new Font("Tahoma",Font.PLAIN,17));
        company.setBounds(60,220,120,30);
        add(company);
        t3 = new JTextField();
        t3.setBounds(200,220,150,30);
        add(t3);
        
        JLabel brand = new JLabel("Car Model");
        brand.setFont(new Font("Tahoma",Font.PLAIN,17));
        brand.setBounds(60,270,120,30);
        add(brand);
        t4 = new JTextField();
        t4.setBounds(200,270,150,30);
        add(t4);
        
        JLabel available = new JLabel("Available");
        available.setFont(new Font("Tahoma",Font.PLAIN,17));
        available.setBounds(60,320,120,30);
        add(available);
        c2 = new JComboBox(new String[]{"Available","Busy"});
        c2.setBounds(200,320,150,30);
        c2.setBackground(Color.WHITE);
        add(c2);
        
        JLabel location = new JLabel("Location");
        location.setFont(new Font("Tahoma",Font.PLAIN,17));
        location.setBounds(60,370,120,30);
        add(location);
        t5 = new JTextField();
        t5.setBounds(200,370,150,30);
        add(t5);
        
        b1 = new JButton("Add Driver");
        b1.setBounds(70,440,130,30);
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);
        b2 = new JButton("Cancel");
        b2.setBounds(210,440,130,30);
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE); 
        add(b2);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(390,70,470,330);
        add(l3);
        
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        setBounds(325,170,910,530);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            String name = t1.getText();
            String age = t2.getText();
            String gender = (String)c1.getSelectedItem();
            String company= t3.getText();
            String brand = t4.getText();
            String available = (String)c2.getSelectedItem();
            String location = t5.getText();
            
            conn c = new conn();
             String str = "insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+brand+"','"+available+"','"+location+"')";
         try{
            
             c.s.executeUpdate(str);
             
             JOptionPane.showMessageDialog(null, "Driver Successfully Added");
         }catch(Exception e){
          System.out.println(e);

         }
            
        }else if(ae.getSource() == b2){
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new AddDriver().setVisible(true);
    }
    
}
