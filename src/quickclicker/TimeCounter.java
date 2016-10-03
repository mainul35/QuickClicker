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
public class TimeCounter extends Thread{
    static int hh=0, mm=0, ss=0;
    
    @Override
    public void run(){
        while(true){
            try {
                Thread.sleep(1000);
                ss++;
                if(ss==60){
                    mm++;
                    ss=0;
                    if(mm==60){
                        hh++;
                        mm=0;
                    }
                }
                UI.lblDisplayTime.setText(""+hh+":"+mm+":"+ss);
            } catch (Exception e) {
            }
        }
    }
}
