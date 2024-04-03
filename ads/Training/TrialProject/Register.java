package TrialProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Register extends JFrame implements ActionListener {

    private Connection connectToDatabase() {
        try {
            String url = "jdbc:mysql://localhost:3306/oracle"; // Change "mydatabase" to your database name
            String user = "root"; // Change "myusername" to your database username
            String password = "Shikiakn062602"; // Change "mypassword" to your database password
            Connection conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    JFrame frame = new JFrame();
    JLabel registration, name, email, confirmemail, password, confirmmpass, gender;
    JPasswordField pass, conpass;
    JTextField name1, email1, confirmemail1;
    Font font = new Font("Consolas", Font.BOLD, 20);
    Font font1 = new Font("Consolas", Font.ITALIC, 15);
    JComboBox<String> genderComboBox;
    JButton back, register;

    Register() {

        registration = new JLabel("Register");
        registration.setFont(new Font("Chicken Pie", Font.ITALIC, 30));
        registration.setBounds(0, 0, 200, 50);

        name = new JLabel("NAME");
        name.setFont(font);
        name.setBounds(20, 10, 100, 20);

        name1 = new JTextField();
        name1.setFont(font1);
        name1.setBounds(20, 30, 150, 20);

        email = new JLabel("EMAIL");
        email.setFont(font);
        email.setBounds(20, 70, 100, 20);

        email1 = new JTextField();
        email1.setFont(font1);
        email1.setBounds(20, 90, 150, 20);

        confirmemail = new JLabel("CONFIRM EMAIL");
        confirmemail.setFont(font);
        confirmemail.setBounds(20, 130, 150, 20);

        confirmemail1 = new JTextField();
        confirmemail1.setFont(font1);
        confirmemail1.setBounds(20, 150, 150, 20);

        password = new JLabel("PASSWORD");
        password.setFont(font);
        password.setBounds(250, 10, 190, 20);

        pass = new JPasswordField();
        pass.setBounds(250, 30, 190, 20);

        confirmmpass = new JLabel("CONFIRM PASSWORD");
        confirmmpass.setFont(font);
        confirmmpass.setBounds(250, 70, 200, 20);

        conpass = new JPasswordField();
        conpass.setBounds(250, 90, 190, 20);

        gender = new JLabel("GENDER");
        gender.setFont(font);
        gender.setBounds(250, 130, 150, 20);

        String[] genders = { " ", "Male", "Female" };
        genderComboBox = new JComboBox<>(genders);
        genderComboBox.setFont(new Font("Consolas", Font.PLAIN, 15));
        genderComboBox.setBounds(250, 150, 100, 20);

        back = new JButton("Back");
        back.setFont(font1);
        back.setBounds(25, 185, 100, 30);

        register = new JButton("Register");
        register.setFont(font1);
        register.setBounds(270, 185, 100, 30);

        JPanel panel1 = new JPanel();
        panel1.setBounds(0, 0, 720, 75);
        panel1.setBackground(new Color(0xfaebd7));
        panel1.setLayout(new BorderLayout());
        panel1.add(registration);

        JPanel panel2 = new JPanel();
        panel2.setBounds(0, 76, 720, 425);
        panel2.setBackground(new Color(0xf0f8ff));
        panel2.setLayout(null);
        panel2.add(name);
        panel2.add(name1);
        panel2.add(email);
        panel2.add(email1);
        panel2.add(confirmemail);
        panel2.add(confirmemail1);
        panel2.add(password);
        panel2.add(pass);
        panel2.add(confirmmpass);
        panel2.add(conpass);
        panel2.add(gender);
        panel2.add(genderComboBox);
        panel2.add(back);
        panel2.add(register);

        frame.setSize(720, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.add(panel1);
        frame.add(panel2);
        back.addActionListener(this);
        register.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            frame.dispose();
            Main main = new Main();
        } else if (e.getSource() == register) {
            String name = name1.getText();
            String email = email1.getText();
            String confirmEmail = confirmemail1.getText();
            String password = new String(pass.getPassword());
            String confirmPassword = new String(conpass.getPassword());
            String gender = (String) genderComboBox.getSelectedItem();

            try (Connection conn = connectToDatabase()) {
                String sql = "INSERT INTO users (name, email, password, gender) VALUES (?, ?, ?, ?)";
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setString(1, name);
                    pstmt.setString(2, email);
                    pstmt.setString(3, password); // Ideally, you should hash the password before saving
                    pstmt.setString(4, gender);
                    pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Register Successfully!");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Registration Failed!");
            }
        }
    }
}