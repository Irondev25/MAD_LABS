package com.irondev25.lab5b;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.text.PrecomputedText;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class FetchData extends AsyncTask<Void,Void,Integer> {
    private static final String TAG = "FetchData";
    MainActivity m =null;
    String line="";
    String data = "";
    String lineParsedData = "";
    String parsedData = "";

    public FetchData(MainActivity m) {
        this.m = m;
    }
    Integer userID, id;
    String title, body;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        m.progressDialog.show();
    }
    @Override
    protected Integer doInBackground(Void... params) {
        try{
            URL url = new URL("https://jsonplaceholder.typicode.com/posts?userId=1");
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            while(line!=null) {
                line = br.readLine();
                data += line;
            }
            Log.d(TAG, "doInBackground: "+data);
            JSONArray JA = new JSONArray(data);
            for(int i=0; i<JA.length(); i++) {
                JSONObject jo = (JSONObject) JA.get(i);
                userID = (Integer) jo.get("userId");
                id = (Integer) jo.get("id");
                title = (String)jo.get("title");
                body = (String) jo.get("body");
            }
            return null;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
        m.dataView.setText("User ID: "+userID+"\nID: "+id+"\nTitle: "+title
        +"\nBody: \n"+body);
        m.progressDialog.dismiss();
    }
}
