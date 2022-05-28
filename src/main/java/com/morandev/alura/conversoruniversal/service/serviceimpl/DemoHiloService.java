package com.morandev.alura.conversoruniversal.service.serviceimpl;

import javax.swing.JProgressBar;

public class DemoHiloService extends Thread {
    
    JProgressBar bar;
    private int barCompletedPercent;
    
    public DemoHiloService() {
        this.barCompletedPercent = 0;
    }
    
    public void run() {
        
        while( true ) {
            
            try {

                barCompletedPercent++;

                if( barCompletedPercent <= 45 ) {
                    bar.setValue( barCompletedPercent );
                    this.sleep(10);
                }
                
                if( barCompletedPercent > 45 && barCompletedPercent < 55 ) {
                    bar.setValue( barCompletedPercent );
                    this.sleep(100);
                }
                
                if( barCompletedPercent >= 55 ) {
                    bar.setValue( barCompletedPercent );
                    this.sleep(10);
                }
                
                System.out.println( barCompletedPercent );
                
                if( barCompletedPercent == 100) {
                    stop();
                }

            } catch (InterruptedException ex) {
                System.out.println( ex.getMessage() );
                ex.printStackTrace();
            }
            
        }
        
        
    }

    public void setBar(JProgressBar bar) {
        this.bar = bar;
    }
    
}
