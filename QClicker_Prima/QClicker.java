package QClicker;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class QClicker extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        QClicker frame = new QClicker();
        frame.setVisible(true);
    }

    /**
     * Create the frame.
     */
    JPanel shopPanel = new JPanel();
    JLabel lblShop = new JLabel("Shop");
    JPanel panel = new JPanel();
    JButton btnSuperClick = new JButton("Super Click");
    JButton btnMultiplier = new JButton("Multiplier");
    JButton btnFactory = new JButton("Factory");
    JButton btnMachine = new JButton("Machine");
    JPanel panel_1 = new JPanel();
    JButton btnEfficientWorkers = new JButton("Efficient Workers");
    JButton btnWeAllClick = new JButton("We All Click Together");
    JButton btnNewManagement = new JButton("New Management");
    JLabel lblPowerUps = new JLabel("Power Ups");
    JPanel panel_2 = new JPanel();
    JLabel lblTotalSuperClicks = new JLabel("Total Super Clicks bought: 0");
    JLabel lblNewSuperClick = new JLabel("New Super Click Rate: 20");
    JLabel lblTotalClickFactory = new JLabel("Total Click Factory Bought: 0");
    JLabel lblNewClickFactory = new JLabel("New Click Factory Rate: 100");
    JLabel lblTotalClickMultipliers = new JLabel("Total Multiplier Bought: 0");
    JLabel lblNewMultiplierRate = new JLabel("New Multiplier Rate: 1000");
    JLabel lblTotalMachinesBought = new JLabel("Total Machines Bought: 0");
    JLabel lblNewMachineRate = new JLabel("New Machine Rate: 10000");
    static JLabel lblPoints = new JLabel("Points: 0.0");
    JButton btnEarnPoints = new JButton("Earn Points");

    static int totalboughtsc = 1, totalboughtcf = 0, totalboughtmultiplier = 0, totalboughtmachine = 0;
    static double cpoint = 0, superclickprice = 20, clickfactoryprice = 100, clickmultiplierprice = 1000, clickmachineprice = 10000;

    public QClicker() {
        Font f = new Font("Stencil", Font.PLAIN, 13);
        Font f2 = new Font("Stencil", Font.PLAIN, 16);
        Color c = new Color(255, 204, 255);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 980, 500);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(102, 0, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        shopPanel.setBackground(new Color(102, 0, 153));
        shopPanel.setBounds(636, 21, 299, 429);
        contentPane.add(shopPanel);
        shopPanel.setLayout(null);

        lblShop.setForeground(c);
        lblShop.setBackground(new Color(30, 200, 200));
        lblShop.setFont(f2);
        lblShop.setHorizontalAlignment(SwingConstants.CENTER);
        lblShop.setBounds(10, 11, 279, 26);
        shopPanel.add(lblShop);

        panel.setBackground(new Color(204, 204, 255));
        panel.setBounds(10, 39, 279, 128);
        shopPanel.add(panel);
        panel.setLayout(null);

        btnSuperClick.setBounds(10, 11, 125, 44);
        btnSuperClick.setEnabled(false);
        panel.add(btnSuperClick);
        btnSuperClick.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                totalboughtsc++;
                lblTotalSuperClicks.setText("Total Super Clicks bought: " + (totalboughtsc - 1));
                cpoint = cpoint - superclickprice;
                lblPoints.setText("Points: " + (int) cpoint);
                superclickprice = superclickprice * 1.2;
                lblNewSuperClick.setText("New Super Click Rate: " + (int) superclickprice);
                
                if (cpoint >= superclickprice) {
                    btnSuperClick.setEnabled(true);
                } else {
                    btnSuperClick.setEnabled(false);
                }

                if (cpoint >= clickfactoryprice) {
                    btnFactory.setEnabled(true);
                } else {
                    btnFactory.setEnabled(false);
                }

                if (cpoint >= clickmultiplierprice) {
                    btnMultiplier.setEnabled(true);
                } else {
                    btnMultiplier.setEnabled(false);
                }

                if (cpoint >= clickmachineprice) {
                    btnMachine.setEnabled(true);
                } else {
                    btnMachine.setEnabled(false);
                }
            }
        });

        btnMultiplier.setBounds(10, 73, 125, 44);
        panel.add(btnMultiplier);
        btnMultiplier.setEnabled(false);
        btnMultiplier.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                totalboughtmultiplier++;
                lblTotalClickMultipliers.setText("Total Super Clicks bought: " + (totalboughtmultiplier));
                cpoint = cpoint - clickmultiplierprice;
                lblPoints.setText("Points: " + (int) cpoint);
                clickmultiplierprice = clickmultiplierprice * 2;
                lblNewMultiplierRate.setText("New Super Click Rate: " + (int) clickmultiplierprice);
                
                if (cpoint >= superclickprice) {
                    btnSuperClick.setEnabled(true);
                } else {
                    btnSuperClick.setEnabled(false);
                }

                if (cpoint >= clickfactoryprice) {
                    btnFactory.setEnabled(true);
                } else {
                    btnFactory.setEnabled(false);
                }

                if (cpoint >= clickmultiplierprice) {
                    btnMultiplier.setEnabled(true);
                } else {
                    btnMultiplier.setEnabled(false);
                }

                if (cpoint >= clickmachineprice) {
                    btnMachine.setEnabled(true);
                } else {
                    btnMachine.setEnabled(false);
                }
            }
        });

        btnFactory.setBounds(145, 11, 124, 44);
        panel.add(btnFactory);
        btnFactory.setEnabled(false);
        btnFactory.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {

                if (arg0.getSource() == btnFactory) {
                    totalboughtcf++;
                    lblTotalClickFactory.setText("Total Click Factory Bought: " + totalboughtcf);

                    cpoint = cpoint - clickfactoryprice;
                    lblPoints.setText("Points: " + (int) (cpoint));

                    clickfactoryprice = clickfactoryprice * 1.5;
                    lblNewClickFactory.setText("New Click Factory Rate: " + (int) clickfactoryprice);
                }
                TimerForClickFactory tfcf = new TimerForClickFactory(10);
                cpoint-=1;
                lblPoints.setText("Points: " + (int) (cpoint));
                if (cpoint >= superclickprice) {
                    btnSuperClick.setEnabled(true);
                } else {
                    btnSuperClick.setEnabled(false);
                }

                if (cpoint >= clickfactoryprice) {
                    btnFactory.setEnabled(true);
                } else {
                    btnFactory.setEnabled(false);
                }

                if (cpoint >= clickmultiplierprice) {
                    btnMultiplier.setEnabled(true);
                } else {
                    btnMultiplier.setEnabled(false);
                }

                if (cpoint >= clickmachineprice) {
                    btnMachine.setEnabled(true);
                } else {
                    btnMachine.setEnabled(false);
                }
            }
        });

        btnMachine.setBounds(145, 73, 124, 44);
        panel.add(btnMachine);
        btnMachine.setEnabled(false);
        btnMachine.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {

                if (arg0.getSource() == btnMachine) {
                    totalboughtmachine++;
                    lblTotalMachinesBought.setText("Total Click Machine Bought: " + totalboughtmachine);

                    cpoint = cpoint - clickmachineprice;
                    lblPoints.setText("Points: " + (int) (cpoint));

                    clickmachineprice = clickmachineprice * 1.5;
                    lblNewMachineRate.setText("New Click Machine Rate: " + (int) clickmachineprice);
                }
                TimerForClickMachine tfcm = new TimerForClickMachine(5);
                cpoint-=2;
                lblPoints.setText("Points: " + (int) (cpoint));
                if (cpoint >= superclickprice) {
                    btnSuperClick.setEnabled(true);
                } else {
                    btnSuperClick.setEnabled(false);
                }

                if (cpoint >= clickfactoryprice) {
                    btnFactory.setEnabled(true);
                } else {
                    btnFactory.setEnabled(false);
                }

                if (cpoint >= clickmultiplierprice) {
                    btnMultiplier.setEnabled(true);
                } else {
                    btnMultiplier.setEnabled(false);
                }

                if (cpoint >= clickmachineprice) {
                    btnMachine.setEnabled(true);
                } else {
                    btnMachine.setEnabled(false);
                }
            }
        });

        panel_1.setBackground(new Color(102, 204, 255));
        panel_1.setBounds(10, 216, 279, 184);
        shopPanel.add(panel_1);
        panel_1.setLayout(null);

        btnEfficientWorkers.setBounds(10, 11, 259, 43);
        btnEfficientWorkers.setEnabled(false);
        panel_1.add(btnEfficientWorkers);

        btnWeAllClick.setBounds(10, 68, 259, 43);
        btnWeAllClick.setEnabled(false);
        panel_1.add(btnWeAllClick);

        btnNewManagement.setBounds(10, 122, 259, 43);
        btnNewManagement.setEnabled(false);
        panel_1.add(btnNewManagement);

        lblPowerUps.setForeground(c);
        lblPowerUps.setHorizontalAlignment(SwingConstants.CENTER);
        lblPowerUps.setFont(f2);
        lblPowerUps.setBounds(10, 179, 279, 26);
        shopPanel.add(lblPowerUps);

        panel_2.setBackground(new Color(102, 0, 0));
        panel_2.setBounds(10, 52, 276, 262);
        contentPane.add(panel_2);
        panel_2.setLayout(null);

        lblTotalSuperClicks.setForeground(c);
        lblTotalSuperClicks.setFont(f);
        lblTotalSuperClicks.setBounds(10, 11, 214, 14);
        panel_2.add(lblTotalSuperClicks);

        lblNewSuperClick.setForeground(c);
        lblNewSuperClick.setFont(f);
        lblNewSuperClick.setBounds(10, 36, 256, 14);
        panel_2.add(lblNewSuperClick);

        lblTotalClickFactory.setFont(f);
        lblTotalClickFactory.setForeground(c);
        lblTotalClickFactory.setBounds(10, 74, 256, 14);
        panel_2.add(lblTotalClickFactory);

        lblNewClickFactory.setForeground(c);
        lblNewClickFactory.setFont(f);
        lblNewClickFactory.setBounds(10, 99, 256, 14);
        panel_2.add(lblNewClickFactory);

        lblTotalClickMultipliers.setFont(f);
        lblTotalClickMultipliers.setForeground(c);
        lblTotalClickMultipliers.setBounds(10, 137, 256, 14);
        panel_2.add(lblTotalClickMultipliers);

        lblNewMultiplierRate.setFont(f);
        lblNewMultiplierRate.setForeground(c);
        lblNewMultiplierRate.setBounds(10, 162, 256, 14);
        panel_2.add(lblNewMultiplierRate);

        lblTotalMachinesBought.setForeground(c);
        lblTotalMachinesBought.setFont(f);
        lblTotalMachinesBought.setBounds(10, 206, 256, 14);
        panel_2.add(lblTotalMachinesBought);

        lblNewMachineRate.setFont(f);
        lblNewMachineRate.setForeground(c);
        lblNewMachineRate.setBounds(10, 231, 256, 14);
        panel_2.add(lblNewMachineRate);

        lblPoints.setFont(f2);
        lblPoints.setForeground(c);
        lblPoints.setBackground(c);
        lblPoints.setBounds(10, 11, 328, 30);
        contentPane.add(lblPoints);

        btnEarnPoints.setBackground(new Color(153, 102, 204));
        btnEarnPoints.setForeground(c);
        btnEarnPoints.setFont(f);
        btnEarnPoints.setBounds(349, 101, 237, 213);
        btnEarnPoints.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (totalboughtmultiplier == 0) {
                    cpoint = cpoint + totalboughtsc;
                } else {
                    cpoint = cpoint + (totalboughtsc * 2);
                }
                lblPoints.setText("Points: " + cpoint);

                if (cpoint >= superclickprice) {
                    btnSuperClick.setEnabled(true);
                } else {
                    btnSuperClick.setEnabled(false);
                }

                if (cpoint >= clickfactoryprice) {
                    btnFactory.setEnabled(true);
                } else {
                    btnFactory.setEnabled(false);
                }

                if (cpoint >= clickmultiplierprice) {
                    btnMultiplier.setEnabled(true);
                } else {
                    btnMultiplier.setEnabled(false);
                }

                if (cpoint >= clickmachineprice) {
                    btnMachine.setEnabled(true);
                } else {
                    btnMachine.setEnabled(false);
                }
            }
        });
        contentPane.add(btnEarnPoints);
    }
}
