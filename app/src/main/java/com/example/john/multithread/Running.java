package com.example.john.multithread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by John on 5/31/15.
 */
public class Running implements Runnable {


    private volatile boolean stillRunning = true;

    public void terminate() {
        stillRunning = false;
    }


    @Override
    public void run() {


        while (stillRunning) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Running.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("Running");

        }
    }
}
