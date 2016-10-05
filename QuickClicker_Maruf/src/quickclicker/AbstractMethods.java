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
public interface AbstractMethods {

    public void incrementPurchaseCounter();

    public void newPurchaseRate();

    /**
     *
     * @return an integer value
     */
    public int getPurchaseCounter();
    
    public double getPurchaseRate();
    
    public void setPurchaseRate(int rate);
    
}
