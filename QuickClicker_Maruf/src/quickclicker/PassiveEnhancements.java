/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quickclicker;

/**
 *
 * @author Mainul35
 */
public class PassiveEnhancements {

    ClickFactory cf = new ClickFactory();
    static ClickMachine cm = new ClickMachine();

    static class ClickFactory extends Thread implements AbstractMethods {

        
        static int purchaseCounter = 1;
        static int baseRate = 100;
        static int autoClicker = 0;

        static int c = 0;
        
        public int getCounter(){
            return ++c;
        }
        
        @Override
        public void newPurchaseRate() {
            baseRate *= 1.5;
        }

        @Override
        public void incrementPurchaseCounter() {
            purchaseCounter++;
           
        }

        @Override
        public int getPurchaseCounter() {

            return purchaseCounter;
        }

        public void startPurchaseCounter() {
            this.start();
        }

        @Override
        public double getPurchaseRate() {
            return baseRate;
        }

        @Override
        public void setPurchaseRate(int rate) {
            baseRate = rate;
        }

        @Override
        public void run() {
            AllActions aac = new AllActions();
            try {
                while (true) {
                    super.sleep(10000);
//                    System.out.print(purchaseCounter+" ");
                    if (aac.getPrevalPointCounter() > getPurchaseRate()) {
                        UI.btnClickFactory.setEnabled(true);
                    } else {
                        UI.btnClickFactory.setEnabled(false);
                    }
                    aac.setPrevalPointCounter(purchaseCounter);
                }
            } catch (Exception e) {
            }
        }
    }

    static class ClickMachine extends Thread implements AbstractMethods {

        static int purchaseCounter = 1;
        static int baseRate = 10000;
        static int autoClicker = 0;

        static int c = 0;
        
        public int getCounter(){
            return ++c;
        }

        @Override
        public void newPurchaseRate() {
            baseRate *= 1.2;
        }

        @Override
        public void incrementPurchaseCounter() {
            purchaseCounter++;
        }

        @Override
        public int getPurchaseCounter() {
            return purchaseCounter;
        }

        public void startPurchaseCounter() {
            try {
                super.start();
            } catch (Exception e) {
            }
        }

        @Override
        public double getPurchaseRate() {
            return baseRate;
        }

        @Override
        public void setPurchaseRate(int rate) {
            baseRate = rate;
        }

        @Override
        public void run() {
            AllActions aac = new AllActions();
            try {
                while (true) {
                    super.sleep(5000);
                    if (aac.getPrevalPointCounter() > getPurchaseRate()) {
                        UI.btnClickMachine.setEnabled(true);
                    } else {
                        UI.btnClickMachine.setEnabled(false);
                    }
                    aac.setPrevalPointCounter(purchaseCounter * 2);
                }
            } catch (Exception e) {
            }
        }
    }
}
