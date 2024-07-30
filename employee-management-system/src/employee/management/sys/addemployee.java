package employee.management.sys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import com.toedter.calendar.JDateChooser;
import java.sql.*;

public class addemployee extends JFrame implements ActionListener{

    Random ran = new Random();
    int number = ran.nextInt(999999);

    JTextField tf_name, tf_fname, tf_address, tf_phone, tf_aadhar, tf_email, tf_salary, tf_designation;
    JDateChooser dc_dob;
    JComboBox<String> cb_education;
    JLabel lblempId;
    JButton add, back;

    addemployee() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);
        
        tf_name = new JTextField();
        tf_name.setBounds(200, 150, 150, 30);
        add(tf_name);
        
        JLabel labelfname = new JLabel("Father's Name");
        labelfname.setBounds(400, 150, 150, 30);
        labelfname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelfname);
        
        tf_fname = new JTextField();
        tf_fname.setBounds(600, 150, 150, 30);
        add(tf_fname);
        
        JLabel labeldob = new JLabel("Date of Birth");
        labeldob.setBounds(50, 200, 150, 30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldob);
        
        dc_dob = new JDateChooser();
        dc_dob.setBounds(200, 200, 150, 30);
        add(dc_dob);
        
        JLabel labelsalary = new JLabel("Salary");
        labelsalary.setBounds(400, 200, 150, 30);
        labelsalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelsalary);
        
        tf_salary = new JTextField();
        tf_salary.setBounds(600, 200, 150, 30);
        add(tf_salary);
        
        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50, 250, 150, 30);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladdress);
        
        tf_address = new JTextField();
        tf_address.setBounds(200, 250, 150, 30);
        add(tf_address);
        
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(400, 250, 150, 30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelphone);
        
        tf_phone = new JTextField();
        tf_phone.setBounds(600, 250, 150, 30);
        add(tf_phone);
        
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 300, 150, 30);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelemail);
        
        tf_email = new JTextField();
        tf_email.setBounds(200, 300, 150, 30);
        add(tf_email);
        
        JLabel labeleducation = new JLabel("Highest Education");
        labeleducation.setBounds(400, 300, 150, 30);
        labeleducation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeleducation);

        String courses[] = {"BBA", "BCA", "BA", "BSC", "B.COM", "BTech", "MBA", "MCA", "MA", "MTech", "MSC", "PHD"};
        cb_education = new JComboBox<>(courses);
        cb_education.setBackground(Color.WHITE);
        cb_education.setBounds(600, 300, 150, 30);
        add(cb_education);
        
        JLabel labeldesignation = new JLabel("Designation");
        labeldesignation.setBounds(50, 350, 150, 30);
        labeldesignation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldesignation);
        
        tf_designation = new JTextField();
        tf_designation.setBounds(200, 350, 150, 30);
        add(tf_designation);
        
        JLabel labelaadhar = new JLabel("Aadhar Number");
        labelaadhar.setBounds(400, 350, 150, 30);
        labelaadhar.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelaadhar);
        
        tf_aadhar = new JTextField();
        tf_aadhar.setBounds(600, 350, 150, 30);
        add(tf_aadhar);
        
        JLabel labelempId = new JLabel("Employee id");
        labelempId.setBounds(50, 400, 150, 30);
        labelempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempId);
        
        lblempId = new JLabel("" + number);
        lblempId.setBounds(200, 400, 150, 30);
        lblempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblempId);
        
        add = new JButton("Add Details");
        add.setBounds(250, 550, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(450, 550, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);      

        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String name = tf_name.getText();
            String fname = tf_fname.getText();
            String dob = ((JTextField) dc_dob.getDateEditor().getUiComponent()).getText();
            String salary = tf_salary.getText();
            String address = tf_address.getText();
            String phone = tf_phone.getText();
            String email = tf_email.getText();
            String education = (String) cb_education.getSelectedItem();
            String designation = tf_designation.getText();
            String aadhar = tf_aadhar.getText();
            String empId = lblempId.getText();
            
            try {
                connection conn = new connection();
                String query = "INSERT INTO employee (name, fname, dob, salary, address, phone, email, education, designation, aadhar, empId) VALUES ('"+name+"', '"+fname+"', '"+dob+"', '"+salary+"', '"+address+"', '"+phone+"', '"+email+"', '"+education+"', '"+designation+"', '"+aadhar+"', '"+empId+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new home();
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "An unexpected error occurred.");
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new home();
        }
    }

    public static void main(String[] args) {
        new addemployee();
    }
}
