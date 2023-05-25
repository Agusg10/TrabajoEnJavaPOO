package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import DomainClasses.InstagramProfile;

public class LogIn extends JDialog {
    private JTextField tfUsernam;
    private JLabel tfPassword;
    private JPasswordField PF;
    private JButton LIButton;
    private JPanel Loginpannel;
    private InstagramProfile prof;
    private boolean loginSuccessful;
    public LogIn(JFrame parent, InstagramProfile profile){
        super(parent);
        this.prof = profile;
        this.loginSuccessful = false;
        setTitle("Login");
        setContentPane(Loginpannel);
        setMinimumSize(new Dimension(450,450));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        LIButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = tfUsernam.getText();
                String password = new String(PF.getPassword());

                if (prof != null && prof.userLogin(username,password)) {
                    loginSuccessful = true;
                } else {
                    JOptionPane.showMessageDialog(LogIn.this, "Invalid login credentials!");
                    loginSuccessful = false;
                }
                dispose();
            }
        });
    }

    public boolean isLoginSuccessful() {
        return loginSuccessful;
    }
}
