
package hotel.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class CheckOut extends JFrame implements ActionListener{
    Choice c1;
    JTextField t1;
    JButton b1,b2,b3;
    
    CheckOut(){
        JLabel l1 = new JLabel("Check Out");
        l1.setBounds(110,20,200,30);
        l1.setForeground(Color.BLUE);
        l1.setFont(new Font("Tahoma",Font.BOLD,20));
        add(l1);
        
        JLabel l2 = new JLabel("Customer ID");
        l2.setBounds(30,80,100,30);
        l2.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(l2);
        
        c1 = new Choice();
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                c1.add(rs.getString("number"));  
                
            }
        }catch(Exception e){}
            
         c1.setBounds(170,80,150,40);
         add(c1);
        
        JLabel l3 = new JLabel("Room Number");
        l3.setBounds(30,130,100,30);
        l3.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(l3);
        
        t1 = new JTextField();
        t1.setBounds(170,130,150,25);
        add(t1);
        
        b1 = new JButton("Checkout");
        b1.setBounds(40,190,120,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBounds(190,190,120,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tick.png "));
        Image i6 = i1.getImage().getScaledInstance(20,20, Image.SCALE_DEFAULT);
        ImageIcon i7 = new ImageIcon(i6);
        b3 = new JButton(i7);
        b3.setBounds(330,80,20,20);
        b3.addActionListener(this);
        add(b3);
        
        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/sixth.jpg "));
        Image i3 = i2.getImage().getScaledInstance(400,290, Image.SCALE_DEFAULT);
        ImageIcon i4 = new ImageIcon(i3);
        JLabel icon = new JLabel(i4);
        icon.setBounds(360,10,400,270);
        add(icon); 
        
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null); 
        setBounds(395,180,750,280);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            String id = c1.getSelectedItem();
            String room = t1.getText();
            String str = "delete from customer where number = '"+id+"'";
            String str2 = "update room set available = 'Available' where room_number = '"+room+"'";
            conn c = new conn();
            try{
                c.s.executeUpdate(str);
                c.s.executeUpdate(str2);
                JOptionPane.showMessageDialog(null,"Checkout Done");
                new Reception().setVisible(true);
                this.setVisible(false);
                
            }catch(Exception e){}
        }else if(ae.getSource() == b2){
            new Reception().setVisible(true);
            this.setVisible(false);
            
        }else if(ae.getSource() == b3){
            conn c = new conn();
            String id = c1.getSelectedItem();
            try{
            ResultSet rs = c.s.executeQuery("Select * from customer where number = '"+id+"'");
            while(rs.next()){
                t1.setText(rs.getString("room"));
            }
            }catch(Exception e){
                
            }
            
        }
    }
     public static void main(String[] args){
        new CheckOut().setVisible(true);
    }
}
