package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.LoginController;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;


public class LoginFrame extends JFrame {
    private JPanel panelUser, panelButtons, panelPass;
    private JLabel labelUser;
    private JLabel labelPassword;
    private JTextField textFieldUser;
    private JPasswordField textFieldPassword;
    private JButton buttonLogin, buttonReset, buttonExit;

    public LoginFrame() {
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        add(Box.createVerticalStrut(5));
        setSize(390, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Login Your Wallet");

        panelUser = new JPanel();
        labelUser = new JLabel("User");
        labelUser.setPreferredSize(new Dimension(90, 25));
        textFieldUser = new JTextField();
        textFieldUser.setPreferredSize(new Dimension(150, 25));
        panelUser.add(labelUser);
        panelUser.add(textFieldUser);

        panelPass = new JPanel();
        labelPassword = new JLabel("Password");
        labelPassword.setPreferredSize(new Dimension(90, 25));
        textFieldPassword = new JPasswordField();
        textFieldPassword.setPreferredSize(new Dimension(150, 25));
        panelPass.add(labelPassword);
        panelPass.add(textFieldPassword);

        panelButtons = new JPanel();
        panelButtons.setLayout(new FlowLayout(FlowLayout.CENTER));

        buttonLogin = new JButton("Login"); // button login
        buttonLogin.setPreferredSize(new Dimension(70, 25));
        panelButtons.add(buttonLogin);

        buttonReset = new JButton("Reset"); // button reset
        buttonReset.setPreferredSize(new Dimension(70, 25));
        panelButtons.add(buttonReset);
        buttonExit = new JButton("Exit");
        buttonExit.setPreferredSize(new Dimension(70, 25));
        panelButtons.add(buttonExit);

        getContentPane().add(panelUser);
        getContentPane().add(panelPass);
        getContentPane().add(panelButtons);

        setVisible(true);

        // acction for button
        buttonLogin.addActionListener(new ProcessButton());
        buttonReset.addActionListener(new ProcessButton()  );
        buttonExit.addActionListener(new ProcessButton());
    }

    // handling form login
    private class ProcessButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton buttonUser = (JButton) e.getSource();
            if(buttonUser == buttonReset){
                // dat lai textFieldUser, textFildPassword
                textFieldUser.setText(" ");
                textFieldPassword.setText("");
            }else if (buttonUser == buttonLogin) {
                LoginController loginController = new LoginController();
                String pass = new String( textFieldPassword.getPassword());

                if(loginController.confirmLogin(textFieldUser.getText(), pass)){
                    new MainFrame().setLocationRelativeTo(null);
                }else{
                    JOptionPane.showMessageDialog(null,"Sai Thông Tin Đăng Nhặp");
                }
            }else{
                System.exit(0); // thoat trang login
            }
        }
    
        
    }

    

    

}
