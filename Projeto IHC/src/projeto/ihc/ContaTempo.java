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
public class ContaTempo implements Runnable{
    private Thread t;
    private static float tempoPassado;
    
    /**
     *  This will return the time that has past since the mission start
     * @return 
     */
    public static float getTempoPassado() {
        return tempoPassado;
    }
   
    /**
     * This is the method that will be used by the running thread to update the mission time
     */
    public void run() {
        GregorianCalendar inicio = new GregorianCalendar();
        while (true) {
            GregorianCalendar dataAtual = new GregorianCalendar();
            tempoPassado = dataAtual.getTimeInMillis() - inicio.getTimeInMillis();
        }
    }
   
    /**
     * Starts the thread that will be updating the system time.
     */
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
