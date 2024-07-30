package employee.management.sys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class login extends JFrame implements ActionListener {
    
    JTextField tf_username;
    JTextField tf_password;

    login() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel a_username = new JLabel("Username");
        a_username.setBounds(40, 20, 100, 30);
        add(a_username);

        tf_username = new JTextField();
        tf_username.setBounds(150, 20, 150, 30);
        add(tf_username);

        JLabel a_password = new JLabel("Password");
        a_password.setBounds(40, 70, 100, 30);
        add(a_password);

        tf_password = new JPasswordField();
        tf_password.setBounds(150, 70, 150, 30);
        add(tf_password);

        JButton loginbtButton = new JButton("LOGIN");
        loginbtButton.setBounds(150,140,150,30);
        loginbtButton.setBackground(Color.BLACK);
        loginbtButton.setForeground(Color.WHITE);
        loginbtButton.addActionListener(this);
        add(loginbtButton);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("./icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,0,200,200);
        add(image);

        setSize(600, 300);
        setLocation(450,200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String username = tf_username.getText();
            String password = tf_password.getText();

            connection c = new connection();

            String query = "select * from login where username = '"+username+"' and password = '"+password+"'";

            ResultSet rs = c.s.executeQuery(query);
            if(rs.next()){
                setVisible(false);
                new home();
            }else {
                JOptionPane.showMessageDialog(null, "Incorrect username or password");
                
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String [] args) {
        new login();
    }
}
