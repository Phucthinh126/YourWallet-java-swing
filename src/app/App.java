package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import view.LoginFrame;

public class App extends JFrame{
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new LoginFrame().setVisible(true);;
        });
    }
    
}
