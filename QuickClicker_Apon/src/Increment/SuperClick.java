/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Increment;

/**
 *
 * @author root
 */
public class SuperClick extends Counter{

    private static int sellRate=20;
    private static int sellCounter=1;
    private final double incrementRate=1.2;
    
    @Override
    public void incrementBaseRate() {
        sellRate*=incrementRate;
    }

    @Override
    public int getBaseRate() {
        return this.sellRate;
    }

    @Override
    public void incrementSellCounter() {
        sellCounter+=1;
    }

    @Override
    public int getSellCounter() {
        return sellCounter;
    }
    
}
