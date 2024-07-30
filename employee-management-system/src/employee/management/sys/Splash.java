package employee.management.sys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Splash extends JFrame implements ActionListener {

    Splash() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(80,30,1200,60);
        heading.setFont(new Font("serif", Font.PLAIN,60));
        heading.setForeground(Color.RED);
        add(heading);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("./icons/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1110, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50,100,1050,500);
        add(image);

        JButton click1 = new JButton("CLICK TO CONTINUE");
        click1.setBounds(400,400,300,70);
        click1.setBackground(Color.BLACK);
        click1.setForeground(Color.WHITE);
        click1.addActionListener(this);
        image.add(click1);

        setSize(1170,650);
        setLocation(200,50);
        setVisible(true);
        while (true) {
            heading.setVisible(true);
            try {
                Thread.sleep(500);
            }catch (Exception e){

            }

            heading.setVisible(false);
        }
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new login();
    }

    public static void main(String [] args) {
        new Splash();
    }
}
