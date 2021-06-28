
package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class AddEmployee extends JFrame implements ActionListener {
    
    JTextField t1,t2,t3,t4,t5,t6;
    JRadioButton r1,r2;
    JComboBox c1;
    JButton b1;
    
    AddEmployee()
    {
        JLabel name = new JLabel("Name");
        name.setFont(new Font("Tahoma",Font.PLAIN,17));
        name.setBounds(60,30,120,30);
        add(name);
        
        t1 = new JTextField();
        t1.setBounds(180,30,150,30);
        add(t1);
        
        JLabel age = new JLabel("AGE");
        age.setFont(new Font("Tahoma",Font.PLAIN,17));
        age.setBounds(60,80,120,30);
        add(age);
        
        t2 = new JTextField();
        t2.setBounds(180,80,150,30);
        add(t2);   

        
        JLabel gender = new JLabel("GENDER");
        gender.setFont(new Font("Tahoma",Font.PLAIN,17));
        gender.setBounds(60,130,120,30);
        add(gender);
        
        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Tahoma",Font.PLAIN,14));
        r1.setBounds(180,130, 70, 30);
        r1.setBackground(Color.WHITE);
        add(r1);
        
        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Tahoma",Font.PLAIN,14));
        r2.setBounds(250,130, 70, 30);
        r2.setBackground(Color.WHITE);
        add(r2);
        
        JLabel job = new JLabel("JOB");
        job.setFont(new Font("Tahoma",Font.PLAIN,17));
        job.setBounds(60,180,120,30);
        add(job);
        
        String str[] = {"Front Desk Clerks","Proters","Housekeeping","Kitchen Staff","Room Services","Waiter/Waitress","Manager","Accountant","Chef"};
        c1 = new JComboBox(str);
        c1.setBounds(180,180,150,30);
        c1.setBackground(Color.WHITE);
        add(c1);

        
        JLabel salary = new JLabel("SALARY");
        salary.setFont(new Font("Tahoma",Font.PLAIN,17));
        salary.setBounds(60,230,120,30);
        add(salary);
        
        t3 = new JTextField();
        t3.setBounds(180,230,150,30);
        add(t3);
        
        JLabel phone = new JLabel("PHONE");
        phone.setFont(new Font("Tahoma",Font.PLAIN,17));
        phone.setBounds(60,280,120,30);
        add(phone);
        
        t4 = new JTextField();
        t4.setBounds(180,280,150,30);
        add(t4);
        
        JLabel aadhar = new JLabel("AADHAR");
        aadhar.setFont(new Font("Tahoma",Font.PLAIN,17));
        aadhar.setBounds(60,330,120,30);
        add(aadhar);
        
        t5 = new JTextField();
        t5.setBounds(180,330,150,30);
        add(t5);
        
        JLabel email  = new JLabel("EMAIL");
        email.setFont(new Font("Tahoma",Font.PLAIN,17));
        email.setBounds(60,380,120,30);
        add(email);
        
        t6 = new JTextField();
        t6.setBounds(180,380,150,30);
        add(t6);
        
        b1 = new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(120,440,160,30);
        b1.addActionListener((ActionListener)this);
        add(b1);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400,400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(350,50,450,450);
        add(l3);
        
        JLabel l2 = new JLabel("ADD EMPLOYEE DETAILs");
        l2.setForeground(Color.BLUE);
        l2.setBounds(420,30,400,30);
        l2.setFont(new Font("Tahoma",Font.PLAIN,25));
        add(l2);
        
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        setBounds(370,160,800,550);
        setVisible(true);
        
    }
        public void actionPerformed(ActionEvent ae){
            String name = t1.getText();
            String age = t2.getText();
            String salary = t3.getText();
            String phone = t4.getText();
            String aadhar = t5.getText();
            String email = t6.getText();
            
            String gender = null;
            if(r1.isSelected())
            {
                gender = "Male";          
            }
            else if(r2.isSelected())
            {
                gender = "Female";
            }
            
            String job = (String)c1.getSelectedItem();

            conn c = new conn();
            String str =  "insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+aadhar+"','"+email+"')";
            
            try{
               c.s.executeUpdate(str);
               JOptionPane.showMessageDialog(null,"New Employee Added");
               this.setVisible(false);
            }catch(Exception e){
              System.out.println(e);  
            }

        }
    public static void main(String[] args){
        new AddEmployee().setVisible(true);
    }
}
