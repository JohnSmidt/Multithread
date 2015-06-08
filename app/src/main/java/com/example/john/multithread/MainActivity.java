package com.example.john.multithread;

import android.content.Context;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {
    private int progressStatus = 0;
    private Handler handler;
    ProgressBar mProgress;
    ArrayAdapter<String> m_adapter;
    ArrayList<String> m_listItems = new ArrayList<String>();
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler = new Handler();

        mProgress = (ProgressBar) findViewById(R.id.progressBar);

        lv = (ListView) findViewById(R.id.listView1);
        m_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, m_listItems);
        lv.setAdapter(m_adapter);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void load(View view) throws InterruptedException {

        new Thread(new Runnable() {
            public void run() {
                String s = "";
                try {
                    FileInputStream fileIn = openFileInput("numbers.txt");
                    InputStreamReader InputRead = new InputStreamReader(fileIn);

                    //char[] inputBuffer= new char[20];
                    //String s="";
                    //int charRead;

                    //while ((charRead=InputRead.read(inputBuffer))>0) {
                        // char to string conversion
                      //  String readstring=String.copyValueOf(inputBuffer,0,charRead);
                      //  s +=readstring;
                    //}
                    //InputRead.close();


                } catch (Exception e) {
                    e.printStackTrace();
                }
                while (progressStatus < 100) {
                    progressStatus += 10;
                    // Update the progress bar and display the

                    //current value in the text view
                    handler.post(new Runnable() {
                        public void run() {
                            mProgress.setProgress(progressStatus);
                        }
                    });
                    try {
                        // Sleep for 250 milliseconds.
                        //Just to display the progress slowly
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    mProgress.setProgress(0);
                }
                System.out.println(s);

            }
        }).start();
        progressStatus = 0;
    }

    public void create(View view) throws InterruptedException {

        new Thread(new Runnable() {
            public void run() {
                String s = "";

                while (progressStatus < 100) {
                    progressStatus += 10;
                    try {


                        FileOutputStream fileout = openFileOutput("numbers.txt", MODE_PRIVATE);
                        OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                        s += (progressStatus/10) + "\n";
                            outputWriter.write(s);

                        outputWriter.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    //progressStatus += 10;
                    // Update the progress bar and display the

                    //current value in the text view
                    handler.post(new Runnable() {
                        public void run() {
                            mProgress.setProgress(progressStatus);
                        }
                    });
                    try {
                        // Sleep for 250 milliseconds.
                        //Just to display the progress slowly
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                mProgress.setProgress(0);
            }
        }).start();

        progressStatus = 0;

    }







}
