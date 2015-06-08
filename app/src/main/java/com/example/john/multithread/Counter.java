/*package com.example.john.multithread;


import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
//import android.view.View;
import android.widget.ProgressBar;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by John on 5/30/15.
 */
/*

public class Counter extends ActionBarActivity implements Runnable {

    Handler handler;
    public int progress = 0;


    public int SetItUp() {

        return progress;
    }

    @Override
    public void run() {

        for (int i = 0; i <= 110; i += 10) {   //Read in the file here
            //i = i % 110;
            final int value = i;

            try {

                Thread.sleep(200);

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

            handler.post(new Runnable() {

                @Override

                public void run() {

                    mProgress.setProgress(value);

                    if(value == 110) {
                        mProgress.setProgress(0);
                    }

                }

            });

        }
    }


}

*/