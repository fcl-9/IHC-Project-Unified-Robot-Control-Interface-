/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.ihc;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.text.Text;

/**
 *
 * @author vmcba
 */
public class ApresentaTempo implements Runnable{
    
    private Thread t;
    private Text tempo;
    private boolean running;

    public void setRunning(boolean running) {
        this.running = running;
    }
    
    public ApresentaTempo (Text tempo) {
        this.tempo = tempo;
        this.running = true;
        start();
    }
    
    public void run() {
        ContaTempo apresentaTempo = new ContaTempo();
        SimpleDateFormat ft = new SimpleDateFormat ("HH:mm:ss");
        while (running) {
            ft.setTimeZone(TimeZone.getTimeZone("GMT"));
            tempo.setText(ft.format(apresentaTempo.getTempoPassado()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ApresentaTempo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
   
    public void start ()
    {
        if (t == null)
        {
            t = new Thread (this);
            t.setDaemon(true);
            t.start ();
        }
    }
}
