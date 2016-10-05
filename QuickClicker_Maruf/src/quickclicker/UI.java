/*
 * To change frame license header, choose License Headers in Project Properties.
 * To change frame template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quickclicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static quickclicker.AllActions.getPrevalPointCounter;
import static quickclicker.UI.pe;
import static quickclicker.UI.setOutput;

/**
 *
 * @author Mainul35
 */
public class UI {

    protected static JButton btnBigButton,btnSuperClick,
    btnClickFactory,btnClickMultiplier,btnClickMachine,btnDisplayResult;
    
    protected static JButton workers,clickTogether,management;
   
    private JPanel pnlMainPanel,pnlLeftPanel,pnlRightPanel,
    pnlTopPanel,pnlLeftTopPanel,pnlLeftBottomPanel,pnlPowerUps;
    
    private static JLabel lbl1, lbl2, lbl3, lbl4, lbl5, lbl6, lbl7, lbl8;
    static JLabel lblDisplayTime,totalSuperClicks,
    totalClickMultipliers,lblTotalClickFactories,
    lblTotalClickMachines, lblNewSuperClickRate,
    lblNewClickMultiplierRate, lblNewClickFactoryRate,
    lblNewClickMachineRate;
   
    private JLabel lblClickEnhancement,lblPassiveClick,lblShop;
   
    static JLabel lblDisplayOutput;
    private JLabel copyRight;
    
    static String output = "";
    static MainFrame mf = new MainFrame();
    
    static JMenuBar menubar = new JMenuBar();
    static JMenu file = new JMenu("File");
    static JMenuItem menuExit = new JMenuItem("Exit");    
    
    static ClickEnhancements ce = new ClickEnhancements();
    static PassiveEnhancements pe = new PassiveEnhancements();
    static int c = 0;

    UI() {
        initializeComponents();
    }
    public static void main(String[] args) {
        mf.setVisible(true);
//        new UI();
    }
    private void initializeComponents() {
        final JFrame frame = new JFrame("Quick Clicker");
        frame.setSize(500, 700);
        frame.setLayout(new BorderLayout());
        btnBigButton = new JButton("Click to earn points");
        btnBigButton.setBackground(new Color(0,128,128));
        btnBigButton.setForeground(Color.WHITE);
        btnBigButton.setFont(new Font("Calibri",Font.ROMAN_BASELINE,25));
  
        pnlMainPanel = new JPanel();
        pnlMainPanel.add(btnBigButton);
        pnlMainPanel.setLayout(new GridLayout());
        
//Button Action goes here
        btnBigButton.addActionListener(new AllActions());
        frame.add(btnBigButton);
        pnlLeftPanel = new JPanel();
        pnlLeftPanel.setBackground(new Color(25,25,112));

        pnlLeftPanel.setLayout(new GridLayout(4, 1));
        Font f = new Font("Calibri", Font.BOLD + Font.ITALIC, 16);
        Font f2 = new Font("Forte", Font.PLAIN,30);
        lblShop = new JLabel("     Shop");
        lblShop.setFont(f2);
        lblShop.setForeground(Color.WHITE);
        pnlLeftPanel.add(lblShop, 0);
        pnlLeftTopPanel = new JPanel();
        pnlLeftTopPanel.setLayout(new GridLayout(3, 1));
        lblClickEnhancement = new JLabel("  Click Enhancements  ");
        lblClickEnhancement.setForeground(Color.WHITE);
        lblClickEnhancement.setFont(f);
        pnlLeftTopPanel.add(lblClickEnhancement, 0);

        btnSuperClick = new JButton("Super Click");
        btnSuperClick.setEnabled(false);
        btnSuperClick.setToolTipText("Increases the number of points gained per click by 1");
        
//Button Action goes here
        btnSuperClick.addActionListener(new AllActions());
        pnlLeftTopPanel.setBackground(new Color(112,128,144));
        pnlLeftTopPanel.add(btnSuperClick, 1);

        btnClickMultiplier = new JButton("Click Multiplier");
        btnClickMultiplier.setEnabled(false);
        btnClickMultiplier.setToolTipText("Doubles the number of points gained for each click");
        
//Button Action goes here
        btnClickMultiplier.addActionListener(new AllActions());
        pnlLeftTopPanel.add(btnClickMultiplier, 2);
        pnlLeftPanel.add(pnlLeftTopPanel, 1);

        pnlLeftBottomPanel = new JPanel();
        pnlLeftBottomPanel.setBackground(new Color(112,128,144));
        pnlLeftBottomPanel.setLayout(new GridLayout(3, 1));
        lblPassiveClick = new JLabel("       Passive Clicks  ");
        lblPassiveClick.setForeground(Color.WHITE);
        lblPassiveClick.setFont(f);
        pnlLeftBottomPanel.add(lblPassiveClick, 0);

        btnClickFactory = new JButton("Click Factory");
        btnClickFactory.setEnabled(false);
        btnClickFactory.setToolTipText("Generates 1 point every ten seconds");
        btnClickFactory.addActionListener(new AllActions());
        pnlLeftBottomPanel.add(btnClickFactory, 1);

        btnClickMachine = new JButton("Click Machine");
        btnClickMachine.setEnabled(false);
        btnClickMachine.setToolTipText("Generates 2 points every five seconds");
        
//Button Action goes here
        btnClickMachine.addActionListener(new AllActions());
        pnlLeftBottomPanel.add(btnClickMachine, 2);

        pnlLeftPanel.add(pnlLeftBottomPanel, 2);

        pnlPowerUps = new JPanel();
        pnlPowerUps.setBackground(pnlLeftBottomPanel.getBackground());

        pnlPowerUps.setLayout(new GridLayout(4, 1));

        JLabel lblPowerUps = new JLabel("         Power Ups");
        lblPowerUps.setForeground(lblClickEnhancement.getForeground());
        lblPowerUps.setFont(f);

        pnlPowerUps.add(lblPowerUps, 0);

        workers = new JButton("Efficient workers");
        workers.setToolTipText("Increases the points generated by every factory by one. (Future Upgrade)");
        workers.setEnabled(false);
        workers.addActionListener(new AllActions());

//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        pnlPowerUps.add(workers, 1);

        clickTogether = new JButton("Click Together");
        clickTogether.setEnabled(false);
        clickTogether.addActionListener(new AllActions());
        clickTogether.setToolTipText("For every Click Factory you own, you increase the number of \n" +
"points gained for each click by one. (Future Upgrade)");
        pnlPowerUps.add(clickTogether);

        management = new JButton("New Managements");
        management.setToolTipText("Increases all points gained by 10% (Future Upgrade)");
        management.setEnabled(false);
        management.addActionListener(new AllActions());
        pnlPowerUps.add(management);

        pnlLeftPanel.add(pnlPowerUps);

        frame.add(pnlLeftPanel, BorderLayout.WEST);

        btnDisplayResult = new JButton();
        pnlTopPanel = new JPanel();
        lblDisplayOutput = new JLabel();
        lblDisplayOutput.setFont(new Font("Calibri", Font.BOLD, 24));
        setOutput(0);
        pnlTopPanel.setLayout(new GridLayout());
        pnlTopPanel.add(lblDisplayOutput);
        frame.add(pnlTopPanel, BorderLayout.NORTH);

//        lblDisplayTime = new JLabel();
        GridBagConstraints gbc = new GridBagConstraints();

        pnlRightPanel = new JPanel();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        pnlRightPanel.setLayout(new GridBagLayout());

        lblDisplayTime = new JLabel("0:0:0");
        new TimeCounter().start();

        pnlRightPanel.add(lblDisplayTime, gbc);
        lblDisplayTime.setForeground(Color.WHITE);
        lblDisplayTime.setFont(new Font("Forte",Font.PLAIN, 28));

//Displays total number of super clicks purchased
        lbl1 = new JLabel("Total Super Clicks");
        gbc.gridx = 0;
        gbc.gridy = 1;

        pnlRightPanel.add(lbl1, gbc);
        lbl1.setForeground(Color.WHITE);

        gbc.gridx = 0;
        gbc.gridy = 2;
        totalSuperClicks = new JLabel();
        totalSuperClicks.setText("0");
        totalSuperClicks.setForeground(Color.WHITE);
        gbc.anchor = GridBagConstraints.LINE_START;
        pnlRightPanel.add(totalSuperClicks, gbc);

//Displays the next purchase rate for super click        
        lbl5 = new JLabel("Point for next purchase");
        lbl5.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 3;
        pnlRightPanel.add(lbl5, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        lblNewSuperClickRate = new JLabel();
        lblNewSuperClickRate.setText(""+ce.sc.getPurchaseRate());
        lblNewSuperClickRate.setForeground(Color.white);
        gbc.anchor = GridBagConstraints.LINE_START;
        pnlRightPanel.add(lblNewSuperClickRate, gbc);

//Displays the number of total click multiplier  purchased
        lbl2 = new JLabel("Total Click Multipliers");
        gbc.gridx = 0;
        gbc.gridy = 5;
        pnlRightPanel.add(lbl2, gbc);
        lbl2.setForeground(Color.WHITE);
      
        totalClickMultipliers = new JLabel("0");
        gbc.gridx = 0;
        gbc.gridy = 6;
        pnlRightPanel.add(totalClickMultipliers, gbc);
        totalClickMultipliers.setForeground(Color.WHITE);

        lbl6 = new JLabel("Point for next purchase");
        lbl6.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 7;
        pnlRightPanel.add(lbl6, gbc);

//Displays the next purchase rate for click multipliers        
        gbc.gridx = 0;
        gbc.gridy = 8;
        lblNewClickMultiplierRate = new JLabel();
        lblNewClickMultiplierRate.setText(""+ce.cm.getPurchaseRate());
        lblNewClickMultiplierRate.setForeground(Color.white);
        gbc.anchor = GridBagConstraints.LINE_START;
        pnlRightPanel.add(lblNewClickMultiplierRate, gbc);

//Displays the number of total click factory purchased
        lbl3 = new JLabel("Total Click Factory");
        gbc.gridx = 0;
        gbc.gridy = 9;
        pnlRightPanel.add(lbl3, gbc);
        lbl3.setForeground(Color.WHITE);

        lblTotalClickFactories = new JLabel("0");
        gbc.gridx = 0;
        gbc.gridy = 10;
        pnlRightPanel.add(lblTotalClickFactories, gbc);
        lblTotalClickFactories.setForeground(Color.WHITE);
        
        lbl7 = new JLabel("Point for next purchase");
        lbl7.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 11;
        pnlRightPanel.add(lbl7, gbc);
        
//Displays the next purchase rate for click factory        
        gbc.gridx = 0;
        gbc.gridy = 12;
        lblNewClickFactoryRate = new JLabel();
        lblNewClickFactoryRate.setText(""+pe.cf.getPurchaseRate());
        lblNewClickFactoryRate.setForeground(Color.white);
        gbc.anchor = GridBagConstraints.LINE_START;
        pnlRightPanel.add(lblNewClickFactoryRate, gbc);
        
//Displays the number of total click machine purchased
        lbl4 = new JLabel("Total Click Machine");
        gbc.gridx = 0;
        gbc.gridy = 13;
        pnlRightPanel.add(lbl4, gbc);
        lbl4.setForeground(Color.WHITE);

        lblTotalClickMachines = new JLabel("0");
        gbc.gridx = 0;
        gbc.gridy = 14;
        pnlRightPanel.add(lblTotalClickMachines, gbc);
        lblTotalClickMachines.setForeground(Color.WHITE);

        lbl8 = new JLabel("Point for next purchase");
        lbl8.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 15;
        pnlRightPanel.add(lbl8, gbc);

//Displays the next purchase rate for click machine                
        gbc.gridx = 0;
        gbc.gridy = 16;
        lblNewClickMachineRate = new JLabel();
        lblNewClickMachineRate.setText(""+pe.cm.getPurchaseRate());
        lblNewClickMachineRate.setForeground(Color.white);
        gbc.anchor = GridBagConstraints.LINE_START;
        pnlRightPanel.add(lblNewClickMachineRate, gbc);
        
        pnlRightPanel.setSize(200, 100);
        pnlRightPanel.setBackground(new Color(65,105,225));
  
        frame.add(pnlRightPanel, BorderLayout.EAST);
        frame.setDefaultCloseOperation(3);
       
        
        menuExit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        file.add(menuExit);
        menubar.add(file);

        frame.setJMenuBar(menubar);
        
        String text = " Mainul Hasan";
        copyRight = new JLabel("<html><div style=\"text-align: center;\">" + text + "</div></html>");
        copyRight.setHorizontalAlignment(JLabel.CENTER);
        frame.add(copyRight, BorderLayout.SOUTH);
        frame.setVisible(true);
        frame.pack();
    }

    public static void setOutput(int output) {
        UI.lblDisplayOutput.setText("Total Points: " + Integer.toString(getPrevalPointCounter()));
    }
}

class AllActions implements ActionListener {
    static int ccc = 0;
    static int prevalPointCounter = 0;
    static boolean condition = true;
    void setPrevalPointCounter(int point) {
    	
        prevalPointCounter += point;
//        System.out.print(prevalPointCounter+" ");
        UI.setOutput(prevalPointCounter);
        
    }

    static int getPrevalPointCounter() {
        return prevalPointCounter;
    }
    
    @Override
    public void actionPerformed(ActionEvent evt) {
    	  
        Object e = evt.getSource();
        ClickEnhancements ce = new ClickEnhancements();
        PassiveEnhancements pe = new PassiveEnhancements();
        if (e.equals(UI.btnBigButton)) {

            prevalPointCounter += ce.cm.getPurchaseCounter();
                    
            
            UI.setOutput(prevalPointCounter);
            
          
            if (prevalPointCounter < ce.sc.getPurchaseRate()) {
                UI.btnSuperClick.setEnabled(false);
                UI.lblNewSuperClickRate.setText(""+ce.sc.getPurchaseRate());
            } else {
                UI.btnSuperClick.setEnabled(true);               
            }

            if (prevalPointCounter < ce.cm.getPurchaseRate()) {
                UI.btnClickMultiplier.setEnabled(false);
                UI.lblNewClickMultiplierRate.setText(""+ce.cm.getPurchaseRate());
            } else {
                UI.btnClickMultiplier.setEnabled(true);
                UI.lblNewClickMultiplierRate.setText(""+ce.cm.getPurchaseRate());
            }

            if (prevalPointCounter < pe.cf.getPurchaseRate()) {
                UI.btnClickFactory.setEnabled(false);
            } else {
                UI.btnClickFactory.setEnabled(true);
            }

            if (prevalPointCounter < pe.cm.getPurchaseRate()) {
                UI.btnClickMachine.setEnabled(false);
            } else {
                UI.btnClickMachine.setEnabled(true);
            }
            
            if(prevalPointCounter>50 && condition==true){
                UI.workers.setEnabled(true);
                UI.clickTogether.setEnabled(true);
                UI.management.setEnabled(true);
                condition = false;
            }
            
        } else if (e.equals(UI.btnSuperClick)) {

            ce.sc.incrementPurchaseCounter();
            UI.totalSuperClicks.setText("" + (ce.sc.getPurchaseCounter() - 1));
            
            prevalPointCounter -= ce.sc.getPurchaseRate();
            ce.sc.newPurchaseRate();
            if (prevalPointCounter < ce.sc.getPurchaseRate()) {
                UI.btnSuperClick.setEnabled(false);
                UI.lblNewSuperClickRate.setText(""+ce.sc.getPurchaseRate());
            } else {
                UI.btnSuperClick.setEnabled(true);
                UI.lblNewSuperClickRate.setText(""+ce.sc.getPurchaseRate());
            }

            if (prevalPointCounter < ce.cm.getPurchaseRate()) {
                UI.btnClickMultiplier.setEnabled(false);
            } else {
                UI.btnClickMultiplier.setEnabled(true);
            }

            if (prevalPointCounter < pe.cf.getPurchaseRate()) {
                UI.btnClickFactory.setEnabled(false);
            } else {
                UI.btnClickFactory.setEnabled(true);
            }

            if (prevalPointCounter < pe.cm.getPurchaseRate()) {
                UI.btnClickMachine.setEnabled(false);
            } else {
                UI.btnClickMachine.setEnabled(true);
            }
            UI.setOutput(prevalPointCounter);

//            getInfo("btnSuperClick", isEnabled(UI.btnSuperClick));
        } else if (e.equals(UI.btnClickMultiplier)) {

            ce.cm.incrementPurchaseCounter();

            UI.totalClickMultipliers.setText("" + (ce.cm.getCounter()));

            prevalPointCounter -= ce.cm.getPurchaseRate();
            ce.cm.newPurchaseRate();
            if (prevalPointCounter < ce.sc.getPurchaseRate()) {
                UI.btnSuperClick.setEnabled(false);
            } else {
                UI.btnSuperClick.setEnabled(true);
            }

            if (prevalPointCounter < ce.cm.getPurchaseRate()) {
                UI.btnClickMultiplier.setEnabled(false);
                UI.lblNewClickMultiplierRate.setText(""+ce.cm.getPurchaseRate());
            } else {
                UI.btnClickMultiplier.setEnabled(true);
                UI.lblNewClickMultiplierRate.setText(""+ce.cm.getPurchaseRate());
            }

            if (prevalPointCounter < pe.cf.getPurchaseRate()) {
                UI.btnClickFactory.setEnabled(false);
            } else {
                UI.btnClickFactory.setEnabled(true);
            }

            if (prevalPointCounter < pe.cm.getPurchaseRate()) {
                UI.btnClickMachine.setEnabled(false);
            } else {
                UI.btnClickMachine.setEnabled(true);
            }
            UI.setOutput(prevalPointCounter);

//            getInfo("btnClickMultiplier", isEnabled(UI.btnClickMultiplier));
        } else if (e.equals(UI.btnClickFactory)) {

            pe.cf.startPurchaseCounter();
            prevalPointCounter -= pe.cf.getPurchaseRate();
            pe.cf.newPurchaseRate();
            ccc++;
            UI.lblTotalClickFactories.setText("" + (pe.cf.getCounter()));

            if (prevalPointCounter < ce.sc.getPurchaseRate()) {
                UI.btnSuperClick.setEnabled(false);
            } else {
                UI.btnSuperClick.setEnabled(true);                
            }

            if (prevalPointCounter < ce.cm.getPurchaseRate()) {
                UI.btnClickMultiplier.setEnabled(false);
            } else {
                UI.btnClickMultiplier.setEnabled(true);
            }

            if (prevalPointCounter < pe.cf.getPurchaseRate()) {
                UI.btnClickFactory.setEnabled(false);
                UI.lblNewClickFactoryRate.setText(""+pe.cf.getPurchaseRate());
                
            } else {
                UI.btnClickFactory.setEnabled(true);
                UI.lblNewClickFactoryRate.setText(""+pe.cf.getPurchaseRate());
                
            }

            if (prevalPointCounter < pe.cm.getPurchaseRate()) {
                UI.btnClickMachine.setEnabled(false);
            } else {
                UI.btnClickMachine.setEnabled(true);
            }
            UI.setOutput(prevalPointCounter);

//            getInfo("btnClickFactory", isEnabled(UI.btnClickFactory));
        } else if (e.equals(UI.btnClickMachine)) {

            pe.cm.startPurchaseCounter();
            
            UI.lblTotalClickMachines.setText("" + (pe.cm.getCounter()));

            prevalPointCounter -= pe.cm.getPurchaseRate();
            pe.cm.newPurchaseRate();
            if (prevalPointCounter < ce.sc.getPurchaseRate()) {
                UI.btnSuperClick.setEnabled(false);
            } else {
                UI.btnSuperClick.setEnabled(true);
            }

            if (prevalPointCounter < ce.cm.getPurchaseRate()) {
                UI.btnClickMultiplier.setEnabled(false);
            } else {
                UI.btnClickMultiplier.setEnabled(true);
            }

            if (prevalPointCounter < pe.cf.getPurchaseRate()) {
                UI.btnClickFactory.setEnabled(false);
            } else {
                UI.btnClickFactory.setEnabled(true);
            }

            if (prevalPointCounter < pe.cm.getPurchaseRate()) {
                UI.btnClickMachine.setEnabled(false);
                UI.lblNewClickMachineRate.setText(""+pe.cm.getPurchaseRate());
            } else {
                UI.btnClickMachine.setEnabled(true);
                UI.lblNewClickMachineRate.setText(""+pe.cm.getPurchaseRate());
            }
            UI.setOutput(prevalPointCounter);
        } else if(e.equals(UI.workers)){
                prevalPointCounter+=(ccc+ccc);
                System.err.println("Purchase Counter"+pe.cf.getPurchaseCounter());
                UI.setOutput(AllActions.prevalPointCounter);
                UI.workers.setEnabled(false);

        }else if(e.equals(UI.clickTogether)){
                prevalPointCounter+=(ccc*2);
                UI.setOutput(AllActions.prevalPointCounter);
                UI.clickTogether.setEnabled(false);
        }else if(e.equals(UI.management)){
                prevalPointCounter+=((AllActions.prevalPointCounter*10)/100);
                UI.setOutput(AllActions.prevalPointCounter);
                UI.management.setEnabled(false);
        }
    }
}
