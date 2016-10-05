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
public class ClickEnhancements {

    SuperClick sc = new SuperClick();
    ClickMultiplier cm = new ClickMultiplier();

    public ClickEnhancements() {

    }
    protected static class SuperClick implements AbstractMethods {

        private static int purchaseCounter = 1;
        private static int baseRate = 20;

        @Override
        public void newPurchaseRate() {
            baseRate *= 1.2;
        }

        @Override
        public void incrementPurchaseCounter() {
            purchaseCounter++;
//            System.out.print(purchaseCounter + " ");
        }

        @Override
        public int getPurchaseCounter() {
            return purchaseCounter;
        }

        @Override
        public double getPurchaseRate() {
            return baseRate;
        }

        @Override
        public void setPurchaseRate(int rate) {
            baseRate = rate;
        }
    }

    static class ClickMultiplier implements AbstractMethods {

        private static int purchaseCounter = 1;
        private static int baseRate = 1000;
        SuperClick sc = new SuperClick();
        
        static int c = 0;
        
        @Override
        public void newPurchaseRate() {
            baseRate *= 2;
        }

        @Override
        public void incrementPurchaseCounter() {
            purchaseCounter *= 2;
//            System.out.print(purchaseCounter+" ");
        }
        
        public int getCounter(){
            return ++c;
        }
        
        @Override
        public int getPurchaseCounter() {
            return sc.getPurchaseCounter() * purchaseCounter;
        }

        @Override
        public double getPurchaseRate() {
            return baseRate;
        }

        @Override
        public void setPurchaseRate(int rate) {
            baseRate = rate;
        }
    }
}
