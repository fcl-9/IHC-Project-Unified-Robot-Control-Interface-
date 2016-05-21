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
    private static float tempoPassado;

    public static float getTempoPassado() {
        return tempoPassado;
    }
   
    public ApresentaTempo(){
    }
    
    public void run() {
        GregorianCalendar inicio = new GregorianCalendar();
        while (true) {
            GregorianCalendar dataAtual = new GregorianCalendar();
            tempoPassado = dataAtual.getTimeInMillis() - inicio.getTimeInMillis();
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
