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
public class ClickMachine extends Counter{
    private int sellRate=10000;
    private int sellCounter=0;
    private final double incrementRate=1.2;
    
    @Override
    public void incrementBaseRate() {
        sellRate*=incrementRate;
    }

    @Override
    public int getBaseRate() {
        return sellRate;
    }

    @Override
    public void incrementSellCounter() {
        sellCounter++;
    }

    @Override
    public int getSellCounter() {
        return sellCounter;
    }
}
