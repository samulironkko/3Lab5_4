package com.example.a3lab5_4;

import android.content.Context;
import android.content.Intent;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class MyThread extends Thread {
  private int progress = 0;
  Context context;



  public MyThread(Context c) {
    context = c;
  }

  public void run() {
    try {
      while (progress < 100) {
        progress = progress + 10;
        progressChanged(progress);
        sleep(3000);
      }
    }catch (Exception e){
      e.printStackTrace();
    }
  }

  private void progressChanged(int progress) {
    Intent intent = new Intent("Progress");
    intent.putExtra("progress", progress);
    LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
  }

}
