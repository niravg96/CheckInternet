package com.example.checkinternet;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class NetworkChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent sendIntent = new Intent("InternetAvailability");
        LocalBroadcastManager.getInstance(context).sendBroadcast(sendIntent);
    }
}
