
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class login {
    public static void main(String[] args)
    {
        String[] cat={"Student","Teacher"};
        JFrame jf=new JFrame("Login");
        jf.setLayout(new GridLayout(4,2));
        JLabel l=new JLabel("Username");
        JTextField jt=new JTextField();
        JLabel l2=new JLabel("Password");
        JTextField jt2=new JTextField();
        JLabel l3=new JLabel("Category");
        JButton b=new JButton("Submit");
        JButton b1=new JButton("Reset");
        JComboBox j1=new JComboBox(cat);
        j1.setSelectedIndex(-1);
        jf.add(l);
        jf.add(jt);
        jf.add(l2);
        jf.add(jt2);
        jf.add(l3);
        jf.add(j1);
        jf.add(b);
        jf.add(b1);
        jf.setSize(300,300);
        jf.setVisible(true);

        //Database Connection

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/login", "root", "Aditi@123");
//here sonoo is database name, root is username and password
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("select count(*) from Category where Username='"+jt.getText()+"'And Password='"+jt2.getText()+"' And Category='"+j1.getSelectedItem()+"'");
                    rs.next();

                    if (rs.getInt(1)>0)
                    {
                        JOptionPane.showMessageDialog(jf,"You are logged in Successfully");
                    }else
                    {
                        JOptionPane.showMessageDialog(jf,"Signup first","Alert",JOptionPane.WARNING_MESSAGE);
                    }
                    con.close();
                } catch (Exception h) {
                    System.out.println(h);
                }

            }
        });

        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);

    }

}
