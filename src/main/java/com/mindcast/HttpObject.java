package com.mindcast;

import android.app.ProgressDialog;
import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class HttpObject extends AsyncTask<String, String, String> {

    StatusFeed statusFeed;
    //ProgressDialog dialog;

    public HttpObject(StatusFeed statusFeed){
        this.statusFeed = statusFeed;
    }

    @Override
    protected void onPreExecute()
    {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... uri) {
        HttpClient httpclient = new DefaultHttpClient();
        HttpResponse response;
        String responseString = null;
        try {
            try{
                response = httpclient.execute(new HttpGet(uri[0]));
            }

            catch(Exception ex){
                ex.getMessage();
                return null;
            }

            StatusLine statusLine = response.getStatusLine();
            if(statusLine.getStatusCode() == HttpStatus.SC_OK){
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                response.getEntity().writeTo(out);
                out.close();
                responseString = out.toString();
            } else{
                //Closes the connection.
                response.getEntity().getContent().close();
                throw new IOException(statusLine.getReasonPhrase());
            }
        }

        catch (ClientProtocolException e) {
            //TODO Handle problems..
            e.getMessage();
        }

        catch (IOException e) {
            //TODO Handle problems..

        }

        return responseString;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        //TODO: Send back data to populate status/chat message lists
        try {
            statusFeed.populateStatusList(result);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
