package TrialProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Main implements ActionListener {

    JFrame frame = new JFrame("Homepage");
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JLabel or = new JLabel("--OR--");
    JLabel Email, Password;
    JTextField Email1 = new JTextField();
    JPasswordField password = new JPasswordField();
    JButton login, signup, labelG, labelF, labelT;
    Font font = new Font("Consolas", Font.PLAIN, 17);
    ImageIcon f, g, t;

    public Main() {

        Email = new JLabel("Email");
        Email.setBounds(50, 100, 100, 30);
        Email.setForeground(Color.black);

        Password = new JLabel("Password");
        Password.setBounds(50, 140, 100, 30);
        Password.setForeground(Color.black);

        password.setBounds(50, 167, 200, 20);
        password.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        Email1.setBounds(50, 127, 200, 20);
        Email1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        Email1.setFont(font);
        Email1.setCaretColor(Color.white);

        login = new JButton("Sign In");
        login.setBounds(65, 190, 75, 25);
        login.setFont(new Font("Chicken Pie", Font.BOLD, 10));

        or.setBounds(128, 213, 50, 25);
        or.setFont(new Font("Chicken Pie", Font.BOLD, 15));

        signup = new JButton("Sign Up");
        signup.setFont(new Font("Chicken Pie", Font.BOLD, 10));
        signup.setBounds(160, 190, 75, 25);

        panel1.setBounds(0, 0, 359, 500);
        panel1.setBackground(new Color(0xfaebd7));
        panel1.setLayout(new BorderLayout());

        f = new ImageIcon("Training/TrialProject/icons8-facebook-30.png");
        g = new ImageIcon("Training/TrialProject/icons8-google-48.png");
        t = new ImageIcon("Training/TrialProject/icons8-twitter-30.png");

        panel2.setBounds(360, 0, 360, 500);
        panel2.setBackground(new Color(0xfff5ee));
        panel2.setLayout(null);
        panel2.add(Email);
        panel2.add(Email1);
        panel2.add(Password);
        panel2.add(password);
        panel2.add(login);
        panel2.add(or);
        panel2.add(signup);
        panel2.add(panel3);

        panel3.setBounds(50, 240, 200, 30);

        panel3.setBackground(new Color(0xfff5ee));
        panel3.setLayout(new GridLayout(1, 3));

        labelG = new JButton(g);
        labelG.setBackground(Color.white);
        labelF = new JButton(f);
        labelF.setBackground(Color.white);
        labelT = new JButton(t);
        labelT.setBackground(Color.white);

        panel3.add(labelF);
        panel3.add(labelG);
        panel3.add(labelT);

        frame.setSize(720, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        frame.add(panel1);
        frame.add(panel2);
        frame.setVisible(true);
        login.addActionListener(this);
        signup.addActionListener(this);
        labelG.addActionListener(this);
        labelF.addActionListener(this);
        labelT.addActionListener(this);
    }

    public static void main(String[] args) {
        new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signup) {
            frame.dispose();
            Register register = new Register();
        }

        else if (e.getSource() == login) {
            JOptionPane.showMessageDialog(null, "Login Successfully");
            frame.dispose();
            homepage hompage = new homepage();
        }

        else if (e.getSource() == labelG) {
            frame.dispose();
            google google = new google();

        }

        else if (e.getSource() == labelF) {
            frame.dispose();
            facebook facebook = new facebook();

        }

        else if (e.getSource() == labelT) {
            frame.dispose();
            twitter twitter = new twitter();
        }
    }
}