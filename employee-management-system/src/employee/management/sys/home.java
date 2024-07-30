package employee.management.sys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class home extends JFrame implements ActionListener{

    JButton view,add,update,remove;

    home(){
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("./icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1120,630);
        add(image);

        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT");
        heading.setBounds(620,20,400,40);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        image.add(heading);

        add = new JButton("Add Employee");
        add.setBounds(820,80,150,40);
        add.addActionListener(this);
        image.add(add);

        view = new JButton("View Employee");
        view.setBounds(650,140,150,40);
        view.addActionListener(this);
        image.add(view);

        update = new JButton("update Employee");
        update.setBounds(820,140,150,40);
        view.addActionListener(this);
        image.add(update);

        remove = new JButton("Remove Employee");
        remove.setBounds(650,80,150,40);
        view.addActionListener(this);
        image.add(remove);

        setSize(1120, 630);
        setLocation(250,100);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == add){
            setVisible(false);
            new addemployee();

        }else if (ae.getSource() == view){
            setVisible(false);
            new viewemployee();

        }else if (ae.getSource() == update){
            setVisible(false);
            new viewemployee();

        }else if(ae.getSource() == remove){
            setVisible(false);
            new removeemployee();
        }

    }

    public static void main(String [] args) {
        new home();

    }

}
