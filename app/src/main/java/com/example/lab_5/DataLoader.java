package com.example.lab_5;

import android.os.AsyncTask;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class DataLoader extends AsyncTask<String, Void, String> {

    private OnDataLoadedListener listener;

    public interface OnDataLoadedListener {
        void onDataLoaded(String data);
    }

    public void setOnDataLoadedListener(OnDataLoadedListener listener) {
        this.listener = listener;
    }

    @Override
    protected String doInBackground(String... urls) {
        try {
            URL url = new URL(urls[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = connection.getInputStream();
            Scanner scanner = new Scanner(inputStream, "UTF-8").useDelimiter("\\A");
            return scanner.hasNext() ? scanner.next() : "";
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onPostExecute(String data) {
        if (listener != null && data != null) {
            listener.onDataLoaded(data);
        }
    }
}
