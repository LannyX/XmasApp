package com.apolis.lanny.xmasapp;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class MyIntentService extends IntentService {

    public MyIntentService(){
        super("myThread");

    }
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public MyIntentService(String name) {
        super(name);
    }

    //worker thread
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Toast.makeText(this, "IntentService onHandleIntent", Toast.LENGTH_LONG).show();

        int data = intent.getExtras().getInt("key");
        for(int i=0; i<data;i++){
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }

        for(int i=0; i<15;i++){
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }

    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "IntentService created", Toast.LENGTH_LONG).show();
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        Toast.makeText(this, "IntentService started", Toast.LENGTH_LONG).show();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "IntentService destroyed", Toast.LENGTH_LONG).show();

        super.onDestroy();
    }
}