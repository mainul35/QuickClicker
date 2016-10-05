/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Increment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author root
 */
public class ButtonAction implements ActionListener {

    boolean multiplierclicked = false;
    boolean factoryclicked = false;
    boolean machineclicked = false;

    SuperClick superClick = new SuperClick();
    ClickMultiplier clickMultiplier = new ClickMultiplier();
    ClickFactory clickFactory = new ClickFactory();
    ClickMachine clickMachine = new ClickMachine();

    static String status = "";

    Timer timer = new Timer(1000, this);

    static int count = 0;

    public ButtonAction() {
        timer.start();
        timer.setRepeats(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == Gui.getPlayButton()) {
            if (multiplierclicked == false) {
                Gui.addPoint(superClick.getSellCounter());
                Gui.getPointLabel().setText("" + Gui.getPoint());
//                System.err.println(superClick.getSellCounter());
            } else {
                Gui.addPoint(superClick.getSellCounter() * 2);
                Gui.getPointLabel().setText("" + Gui.getPoint());
            }

            if (Gui.getPoint() < superClick.getBaseRate()) {
                Gui.getSuperClickButton().setEnabled(false);
            } else {
                Gui.getSuperClickButton().setEnabled(true);
            }

            if (Gui.getPoint() < clickMultiplier.getBaseRate()) {
                Gui.getClickMultiplierButton().setEnabled(false);
            } else {
                Gui.getClickMultiplierButton().setEnabled(true);
            }

            if (Gui.getPoint() < clickFactory.getBaseRate()) {
                Gui.getClickFactoryButton().setEnabled(false);
            } else {
                Gui.getClickFactoryButton().setEnabled(true);
            }

            if (Gui.getPoint() < clickMachine.getBaseRate()) {
                Gui.getClickMachineButton().setEnabled(false);
            } else {
                Gui.getClickMachineButton().setEnabled(true);
            }

        } else if (e.getSource() == Gui.getSuperClickButton()) {

            Gui.reducePoint(superClick.getBaseRate());
            superClick.incrementSellCounter();
            superClick.incrementBaseRate();

            if (Gui.getPoint() < superClick.getBaseRate()) {
                Gui.getSuperClickButton().setEnabled(false);
            } else {
                Gui.getSuperClickButton().setEnabled(true);
            }

            if (Gui.getPoint() < clickMultiplier.getBaseRate()) {
                Gui.getClickMultiplierButton().setEnabled(false);
            } else {
                Gui.getClickMultiplierButton().setEnabled(true);
            }

            if (Gui.getPoint() < clickFactory.getBaseRate()) {
                Gui.getClickFactoryButton().setEnabled(false);
            } else {
                Gui.getClickFactoryButton().setEnabled(true);
            }

            if (Gui.getPoint() < clickMachine.getBaseRate()) {
                Gui.getClickMachineButton().setEnabled(false);
            } else {
                Gui.getClickMachineButton().setEnabled(true);
            }

            Gui.getPointLabel().setText("" + Gui.getPoint());

            status = "<html>"
                    + "Total Super Click purchaed: <br/>" + (superClick.getSellCounter() - 1) + "<br/>"
                    + "<br/>Next Super Click purchase rate: <br/>" + superClick.getBaseRate() + " Points<br/><br/>"
                    + "Total Click Factory purchased: <br/>0<br/>"
                    + "<br/>Next Click Factory rate: <br/>100 Points<br/><br/>"
                    + "Total Click Multiplier purchased: <br/>" + (clickMultiplier.getSellCounter() - 1) + "<br/>"
                    + "<br/>Next Click Multiplier purchase <br/>rate: <br/>" + clickMultiplier.getBaseRate() + " Points<br/><br/>"
                    + "Total Click Machine purchased: <br/>0<br/>"
                    + "<br/>Next Click Machine purchase <br/>rate: <br/>10000 Points<br/>"
                    + "</html>";

            Gui.getStatusLabel().setText(status);

        } else if (e.getSource() == Gui.getClickMultiplierButton()) {

            multiplierclicked = true;
            Gui.reducePoint(clickMultiplier.getBaseRate());
            clickMultiplier.incrementBaseRate();
            clickMultiplier.incrementSellCounter();

            if (Gui.getPoint() < superClick.getBaseRate()) {
                Gui.getSuperClickButton().setEnabled(false);
            } else {
                Gui.getSuperClickButton().setEnabled(true);
            }

            if (Gui.getPoint() < clickMultiplier.getBaseRate()) {
                Gui.getClickMultiplierButton().setEnabled(false);
            } else {
                Gui.getClickMultiplierButton().setEnabled(true);
            }

            if (Gui.getPoint() < clickFactory.getBaseRate()) {
                Gui.getClickFactoryButton().setEnabled(false);
            } else {
                Gui.getClickFactoryButton().setEnabled(true);
            }

            if (Gui.getPoint() < clickMachine.getBaseRate()) {
                Gui.getClickMachineButton().setEnabled(false);
            } else {
                Gui.getClickMachineButton().setEnabled(true);
            }

            status = "<html>"
                    + "Total Super Click purchaed: <br/>" + (superClick.getSellCounter() - 1) + "<br/>"
                    + "<br/>Next Super Click purchase rate: <br/>" + superClick.getBaseRate() + " Points<br/><br/>"
                    + "Total Click Factory purchased: <br/>" + clickFactory.getSellCounter() + "<br/>"
                    + "<br/>Next Click Factory rate: <br/>" + clickFactory.getBaseRate() + " Points<br/><br/>"
                    + "Total Click Multiplier purchased: <br/>" + (clickMultiplier.getSellCounter() - 1) + "<br/>"
                    + "<br/>Next Click Multiplier purchase <br/>rate: <br/>" + clickMultiplier.getBaseRate() + " Points<br/><br/>"
                    + "Total Click Machine purchased: <br/>0<br/>"
                    + "<br/>Next Click Machine purchase <br/>rate: <br/>10000 Points<br/>"
                    + "</html>";

            Gui.getStatusLabel().setText(status);
            Gui.getPointLabel().setText("" + Gui.getPoint());

        } else if (e.getSource() == Gui.getClickFactoryButton()) {
            factoryclicked = true;
            clickFactory.incrementSellCounter();
            Gui.reducePoint(clickFactory.getBaseRate());
            Gui.getPointLabel().setText("" + Gui.getPoint());

            clickFactory.incrementBaseRate();

            if (Gui.getPoint() < superClick.getBaseRate()) {
                Gui.getSuperClickButton().setEnabled(false);
            } else {
                Gui.getSuperClickButton().setEnabled(true);
            }

            if (Gui.getPoint() < clickMultiplier.getBaseRate()) {
                Gui.getClickMultiplierButton().setEnabled(false);
            } else {
                Gui.getClickMultiplierButton().setEnabled(true);
            }

            if (Gui.getPoint() < clickFactory.getBaseRate()) {
                Gui.getClickFactoryButton().setEnabled(false);
            } else {
                Gui.getClickFactoryButton().setEnabled(true);
            }

            if (Gui.getPoint() < clickMachine.getBaseRate()) {
                Gui.getClickMachineButton().setEnabled(false);
            } else {
                Gui.getClickMachineButton().setEnabled(true);
            }
            status = "<html>"
                    + "Total Super Click purchaed: <br/>" + (superClick.getSellCounter() - 1) + "<br/>"
                    + "<br/>Next Super Click purchase rate: <br/>" + superClick.getBaseRate() + " Points<br/><br/>"
                    + "Total Click Factory purchased: <br/>" + clickFactory.getSellCounter() + "<br/>"
                    + "<br/>Next Click Factory rate: <br/>" + clickFactory.getBaseRate() + " Points<br/><br/>"
                    + "Total Click Multiplier purchased: <br/>" + (clickMultiplier.getSellCounter() - 1) + "<br/>"
                    + "<br/>Next Click Multiplier purchase <br/>rate: <br/>" + clickMultiplier.getBaseRate() + " Points<br/><br/>"
                    + "Total Click Machine purchased: <br/>0<br/>"
                    + "<br/>Next Click Machine purchase <br/>rate: <br/>10000 Points<br/>"
                    + "</html>";

            Gui.getStatusLabel().setText(status);

        } else if (e.getSource() == Gui.getClickMachineButton()) {
            machineclicked = true;
            clickMachine.incrementSellCounter();
            Gui.reducePoint(clickMachine.getBaseRate());
            Gui.getPointLabel().setText("" + Gui.getPoint());

            clickMachine.incrementBaseRate();

            if (Gui.getPoint() < superClick.getBaseRate()) {
                Gui.getSuperClickButton().setEnabled(false);
            } else {
                Gui.getSuperClickButton().setEnabled(true);
            }

            if (Gui.getPoint() < clickMultiplier.getBaseRate()) {
                Gui.getClickMultiplierButton().setEnabled(false);
            } else {
                Gui.getClickMultiplierButton().setEnabled(true);
            }

            if (Gui.getPoint() < clickFactory.getBaseRate()) {
                Gui.getClickFactoryButton().setEnabled(false);
            } else {
                Gui.getClickFactoryButton().setEnabled(true);
            }

            if (Gui.getPoint() < clickMachine.getBaseRate()) {
                Gui.getClickMachineButton().setEnabled(false);
            } else {
                Gui.getClickMachineButton().setEnabled(true);
            }

            status = "<html>"
                    + "Total Super Click purchaed: <br/>" + (superClick.getSellCounter() - 1) + "<br/>"
                    + "<br/>Next Super Click purchase rate: <br/>" + superClick.getBaseRate() + " Points<br/><br/>"
                    + "Total Click Factory purchased: <br/>" + clickFactory.getSellCounter() + "<br/>"
                    + "<br/>Next Click Factory rate: <br/>" + clickFactory.getBaseRate() + " Points<br/><br/>"
                    + "Total Click Multiplier purchased: <br/>" + (clickMultiplier.getSellCounter() - 1) + "<br/>"
                    + "<br/>Next Click Multiplier purchase <br/>rate: <br/>" + clickMultiplier.getBaseRate() + " Points<br/><br/>"
                    + "Total Click Machine purchased: <br/>" + clickMachine.getSellCounter() + "<br/>"
                    + "<br/>Next Click Machine purchase <br/>rate: <br/>" + clickMachine.getBaseRate() + " Points<br/>"
                    + "</html>";

            Gui.getStatusLabel().setText(status);

        }

        if (timer.isRepeats()) {

            if (factoryclicked == true || machineclicked == true) {
                count++;
                if (count == 10) {
                    count = 0;
                }
            }
            if (factoryclicked == true) {

                if (count == 9) {
//                    System.err.println(count);
                    Gui.addPoint(clickFactory.getSellCounter());
                    Gui.getPointLabel().setText("" + (Gui.getPoint()));

                    if (Gui.getPoint() < superClick.getBaseRate()) {
                        Gui.getSuperClickButton().setEnabled(false);
                    } else {
                        Gui.getSuperClickButton().setEnabled(true);
                    }

                    if (Gui.getPoint() < clickMultiplier.getBaseRate()) {
                        Gui.getClickMultiplierButton().setEnabled(false);
                    } else {
                        Gui.getClickMultiplierButton().setEnabled(true);
                    }

                    if (Gui.getPoint() < clickFactory.getBaseRate()) {
                        Gui.getClickFactoryButton().setEnabled(false);
                    } else {
                        Gui.getClickFactoryButton().setEnabled(true);
                    }

                    if (Gui.getPoint() < clickMachine.getBaseRate()) {
                        Gui.getClickMachineButton().setEnabled(false);
                    } else {
                        Gui.getClickMachineButton().setEnabled(true);
                    }
                }
            }
            if (machineclicked == true) {
                if (count == 4 || count==9) {
                    System.out.println(count);
                    Gui.addPoint(clickMachine.getSellCounter()*2);
                    Gui.getPointLabel().setText("" + (Gui.getPoint()));

                    if (Gui.getPoint() < superClick.getBaseRate()) {
                        Gui.getSuperClickButton().setEnabled(false);
                    } else {
                        Gui.getSuperClickButton().setEnabled(true);
                    }

                    if (Gui.getPoint() < clickMultiplier.getBaseRate()) {
                        Gui.getClickMultiplierButton().setEnabled(false);
                    } else {
                        Gui.getClickMultiplierButton().setEnabled(true);
                    }

                    if (Gui.getPoint() < clickFactory.getBaseRate()) {
                        Gui.getClickFactoryButton().setEnabled(false);
                    } else {
                        Gui.getClickFactoryButton().setEnabled(true);
                    }

                    if (Gui.getPoint() < clickMachine.getBaseRate()) {
                        Gui.getClickMachineButton().setEnabled(false);
                    } else {
                        Gui.getClickMachineButton().setEnabled(true);
                    }
                }
            }
        }
    }
}
