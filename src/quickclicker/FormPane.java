package quickclicker;

/**
*
* @author Mainul35
*/

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class FormPane extends JPanel {

    private JLabel lblName;
    private JLabel lblPass;
    private JTextField txtName;
    private JPasswordField txtPass;
    private JButton btnLogin;
    private String uname = "abcd";
    private String pass = "1234";

    public FormPane() {
        setLayout(new GridBagLayout());
        lblName = new JLabel("Username:");
        lblPass = new JLabel("Password:");
        txtName = new JTextField(12);
        txtName.setToolTipText("Username: abcd");
        
        txtPass = new JPasswordField(12);
        txtPass.setToolTipText("Password: 1234");
        
        btnLogin = new JButton("Play");

        Font font = new Font("Forte", Font.PLAIN, 25);
        lblName.setFont(font);
        lblPass.setFont(font);
        txtName.setFont(font);
        txtPass.setFont(font);
        btnLogin.setFont(font);
        txtPass.setEchoChar('*');

        GridBagConstraints gc = new GridBagConstraints();
         /**
          * 
          ******** First Row********
        */
        gc.gridx = 0;
        gc.gridy = 0;
        gc.insets = new Insets(10, 10, 10, 10);
        add(lblName, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        add(txtName, gc);

        /**
         * ******Second row*******
         */
        gc.gridx = 0;
        gc.gridy = 1;
        add(lblPass, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        add(txtPass, gc);

        /**
         * *****Third row*********
         */
        gc.gridx = 1;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.LINE_START;
        add(btnLogin, gc);

        btnLogin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(uname.equals(txtName.getText())){
                    if(pass.equals(txtPass.getText())){
                        UI.mf.dispose();
                        new UI();
                    }else{
                        JOptionPane.showMessageDialog(null, "Sorry, incorrect password! \n(Hint: 1234)");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Sorry, incorrect username! \n(Hint: abcd)");
                }
            }
        });
    }
}
