package com.example.checkinternet;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class InternetCheck extends AsyncTask<Void, Void, Boolean> {
    private final NetListener netListener;

    public InternetCheck(NetListener netListener) {
        this.netListener = netListener;

    }
    @Override
    protected Boolean doInBackground(Void... voids) {
        try {

            Socket sock = new Socket();
            sock.connect(new InetSocketAddress("8.8.8.8", 53), 1500);
            sock.close();
            return true;

        } catch (IOException e)
        {
            return false;
        }
    }
    @Override
    protected void onPostExecute(Boolean internet) {
        netListener.onNetChange(internet);
    }

    public interface NetListener {
        void onNetChange(boolean isInternet);
    }
}