package Increment;

import java.awt.Color;

import java.awt.Container;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Gui {

    public JPanel pshop, ppowerup, pscore, pstatus;
    Container p3;
    static String status = "<html>"
            + "Total Super Click purchaed: <br/>0<br/>"
            + "<br/>Next Super Click purchase rate: <br/>20 Points<br/><br/>"
            + "Total Click Factory purchased: <br/>0<br/>"
            + "<br/>Next Click Factory rate: <br/>100 Points<br/><br/>"
            + "Total Click Multiplier purchased: <br/>0<br/>"
            + "<br/>Next Click Multiplier purchase <br/>rate: <br/>1000 Points<br/><br/>"
            + "Total Click Machine purchased: <br/>0<br/>"
            + "<br/>Next Click Machine purchase <br/>rate: <br/>10000 Points<br/>"
            + "</html>";
    private static JLabel lblshop, lblpower, showlbl;
    public static JLabel lblstatus;
    static private JButton btnsuper, btnfactory, btnmultiplier, btnmachine, btneworker, btnctogether, btnmanagement, btnplay;
    public JPanel showscore;
    public int score = 0;
    int a = 0;
    static private int point = 0;

    public Gui() {

        JFrame frame = new JFrame();

        p3 = frame.getContentPane();
        p3.setLayout(null);
        p3.setSize(800, 700);
        p3.setBackground(Color.decode("#AAAAAA"));
        btnplay = new JButton();

        btnplay.setBounds(295, 200, 200, 200);
        btnplay.setIcon(new ImageIcon(getClass().getResource("image/images.png")));
        btnplay.setBackground(Color.blue);

        p3.add(btnplay);
        ButtonAction ba = new ButtonAction();
//        btnplay.addActionListener(l);

        lblstatus = new JLabel();

        lblstatus.setText(status);

        pstatus = new JPanel();
        pstatus.setBounds(10, 100, 250, 450);

        pstatus.add(lblstatus);
        p3.add(pstatus);

        // Panel
        // Panel for Shop option
        pshop = new JPanel();
        pshop.setBounds(535, 100, 250, 250);
        pshop.setLayout(null);
        pshop.setBackground(Color.black);
        p3.add(pshop);

        // Label for shop
        lblshop = new JLabel("Shop");
        lblshop.setBounds(100, 0, 50, 40);
        lblshop.setFont(new Font("monospaced", Font.BOLD + Font.ITALIC, 20));
        lblshop.setForeground(Color.white);
        pshop.add(lblshop);

        // Increment Buttons
        btnsuper = new JButton("Super Click");
        btnsuper.setBounds(25, 40, 200, 40);
        btnsuper.setToolTipText("Increases the number of \n" +
"points gained per click by 1");
        btnsuper.setFont(new Font("monospaced", Font.BOLD + Font.ITALIC, 16));
        btnsuper.setBackground(Color.white);
        btnsuper.setEnabled(false);
        pshop.add(btnsuper);
        btnsuper.addActionListener(ba);

        btnfactory = new JButton("CLick Factory");
        btnfactory.setBounds(25, 90, 200, 40);
        btnfactory.setToolTipText("Generates 1 point every ten \n" +
"seconds");
        btnfactory.setFont(new Font("monospaced", Font.BOLD + Font.ITALIC, 16));
        btnfactory.setBackground(Color.white);
        btnfactory.setEnabled(false);
        pshop.add(btnfactory);

        btnmultiplier = new JButton("Click Multiplier");
        btnmultiplier.setBounds(25, 140, 200, 40);
        btnmultiplier.setToolTipText("Doubles the number of \n" +
"points gained for each click");
        btnmultiplier.setFont(new Font("monospaced", Font.BOLD + Font.ITALIC, 16));
        btnmultiplier.setBackground(Color.white);
        btnmultiplier.setEnabled(false);
        pshop.add(btnmultiplier);

        btnmachine = new JButton("Click Machine");
        btnmachine.setBounds(25, 190, 200, 40);
        btnmachine.setToolTipText("Generates 2 points every \n" +
"five seconds");
        btnmachine.setFont(new Font("monospaced", Font.BOLD + Font.ITALIC, 16));
        btnmachine.setBackground(Color.white);
        btnmachine.setEnabled(false);
        pshop.add(btnmachine);

        // Panel for score
        pscore = new JPanel();
        pscore.setBounds(40, 20, 360, 70);
        pscore.setLayout(null);
        pscore.setBackground(Color.lightGray);
        p3.add(pscore);

        //Score text area
        showscore = new JPanel();
        showscore.setBounds(25, 10, 310, 50);
        showscore.setFont(new Font("monospaced", Font.BOLD + Font.ITALIC, 16));
        showscore.setForeground(Color.ORANGE);
        pscore.add(showscore);

        showlbl = new JLabel("0");
        showlbl.setBounds(120, 0, 200, 50);
        showlbl.setFont(new Font("monospaced", Font.BOLD + Font.ITALIC, 25));
        showlbl.setForeground(Color.decode("#22eeee"));
        showscore.add(showlbl);

        // Power up panel
        ppowerup = new JPanel();
        ppowerup.setBounds(535, 360, 250, 190);
        ppowerup.setLayout(null);
        ppowerup.setBackground(Color.black);

        p3.add(ppowerup);

        lblpower = new JLabel("Power Up");
        lblpower.setBounds(80, 0, 100, 40);
        lblpower.setFont(new Font("monospaced", Font.BOLD + Font.ITALIC, 20));
        lblpower.setForeground(Color.WHITE);
        ppowerup.add(lblpower);

        // Power up buttons
        btneworker = new JButton("Efficient Worker");
        btneworker.setBounds(25, 40, 200, 40);
        btneworker.setFont(new Font("monospaced", Font.BOLD + Font.ITALIC, 16));
        btneworker.setBackground(Color.white);
        btneworker.setEnabled(false);
        ppowerup.add(btneworker);

        btnctogether = new JButton("Click together");
        btnctogether.setBounds(25, 90, 200, 40);
        btnctogether.setFont(new Font("monospaced", Font.BOLD + Font.ITALIC, 16));
        btnctogether.setBackground(Color.white);
        btnctogether.setEnabled(false);
        ppowerup.add(btnctogether);

        btnmanagement = new JButton("New Management");
        btnmanagement.setBounds(25, 140, 200, 40);
        btnmanagement.setFont(new Font("monospaced", Font.BOLD + Font.ITALIC, 16));
        btnmanagement.setBackground(Color.white);
        btnmanagement.setEnabled(false);
        ppowerup.add(btnmanagement);

//        ActionListener factory = new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                if (e.getSource() == btnfactory) {
//
//                    increment = increment + 2;
//
//                }
//                score = score - fcost;
//                if (score >= fcost) {
//                    btnfactory.setEnabled(true);
//                } else {
//                    btnfactory.setEnabled(false);
//                }
//                showlbl.setText(score + "");
//                fcost = (int) (fcost * 1.5);
//
//            }
//
//        };
//        ActionListener machine = new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                if (e.getSource() == btnmachine) {
//
//                    increment = increment + 10;
//
//                }
//                score = score - mccost;
//                if (score >= mccost) {
//                    btnmachine.setEnabled(true);
//                } else {
//                    btnmachine.setEnabled(false);
//                }
//                showlbl.setText(score + "");
//                mccost = (int) (mccost * 1.2);
//
//            }
//
//        };
//        ActionListener multiplier = new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                int d = 0;
//
//                if (e.getSource() == btnmultiplier) {
//
//                    increment = increment * 2;
//
//                }
//                score = score - mcost;
//                if (score >= mcost) {
//                    btnmultiplier.setEnabled(true);
//                } else {
//                    btnmultiplier.setEnabled(false);
//                }
//
//                showlbl.setText(score + "");
//                mcost = mcost * 2;
//
//            }
//
//        };
        btnfactory.addActionListener(ba);
        btnmachine.addActionListener(ba);
        btnmultiplier.addActionListener(ba);

        btnplay.addActionListener(ba);
        // Frame

        frame.setTitle("Quick Clicker");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(3);
        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);

    }

    static public JButton getSuperClickButton(){
        return btnsuper;
    }
    
    static public JButton getClickMultiplierButton(){
        return btnmultiplier;
    }
    
    static public JButton getPlayButton(){
        return btnplay;
    }
    
    static public JButton getClickFactoryButton(){
        return btnfactory;
    }
    
    static public JButton getClickMachineButton(){
        return btnmachine;
    }
    
    static public void addPoint(int val) {
        point += val;
    }

    static public void reducePoint(int val) {
        point -= val;
    }

    static public int getPoint() {
        return point;
    }
    
    static JLabel getPointLabel(){
        return showlbl;
    }
    
    static JLabel getStatusLabel(){
        return lblstatus;
    }
}
