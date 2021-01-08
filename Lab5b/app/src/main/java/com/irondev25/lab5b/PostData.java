package com.irondev25.lab5b;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class PostData extends AsyncTask<Void,Void,Integer> {
    private static final String TAG = "PostData";
    int res;
    MainActivity m = null;

    public PostData(MainActivity m){
        this.m = m;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        m.progressDialog.show();
    }

    @Override
    protected Integer doInBackground(Void... voids) {
        try{
            URL url = new URL("https://jsonplaceholder.typicode.com/posts");
            HttpURLConnection hurl = (HttpURLConnection)url.openConnection();
            hurl.setRequestMethod("POST");
            hurl.setRequestProperty("Content-Type","application/json");
            hurl.setDoOutput(true);
            hurl.setDoInput(true);

            hurl.connect();
            DataOutputStream dataOutputStream = new DataOutputStream(hurl.getOutputStream());
            JSONObject jo = new JSONObject();
            jo.put("userId","1");
            jo.put("title","Foo Bar");
            jo.put("body","Foo Bar's body");
            Log.d(TAG, "doInBackground: " + jo.toString());
            dataOutputStream.writeBytes(jo.toString());
            dataOutputStream.close();
            res = hurl.getResponseCode();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
        Toast.makeText(m, "Response Code: "+res, Toast.LENGTH_SHORT).show();
        m.progressDialog.dismiss();
    }
}
