
package QClicker;

import java.util.Timer;
import java.util.TimerTask;


public class TimerForClickFactory {
    Timer timer;

    public TimerForClickFactory(int seconds) {
        timer = new Timer();
        timer.scheduleAtFixedRate(new RemindTask(), 0000, seconds*1000);
    }

    class RemindTask extends TimerTask {
        @Override
        public void run() {
            QClicker.cpoint=QClicker.cpoint+1;
            QClicker.lblPoints.setText("Points: "+QClicker.cpoint);
//            timer.cancel(); //Terminate the timer thread
        }
    }
}

