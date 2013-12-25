package com.mindcast;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

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
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ashwin on 11/24/13.
 */
public class StatusFeed {

    private ArrayList<Status> statusList;
    private StatusAdapter statusArrayAdapter;
    private MainActivity viewClass;
    private String url, domain, protocol, path;


    public StatusFeed(MainActivity mainActivity, ArrayList<Status> statusList, StatusAdapter statusArrayAdapter) {
        this.viewClass = mainActivity;
        this.statusList = statusList;
        this.statusArrayAdapter = statusArrayAdapter;

        domain = "192.168.0.102:80";
        protocol = "http";
        path = "/MindCast/scripts/php/chat.php";

        url = protocol + "://" + domain + path;

        getStatuses();
    }

    private void getStatuses() {
        HttpObject serverAccessObject = new HttpObject(this);
        serverAccessObject.execute(url);

        // TODO: Create HttpRequest object here and pass it to populateStatusList()
        }

    public boolean populateStatusList(String response) throws JSONException {
        boolean success = true;

        JSONObject json = new JSONObject(response);
        JSONArray messageList = json.getJSONArray("");

        for(int i=0; i<messageList.length(); i++){
            JSONObject message = messageList.getJSONObject(i);
            statusList.add(new Status(message.getString("sender"), message.getString("message")));
        }

        try {
            statusArrayAdapter.notifyDataSetChanged();
        }

        catch (Exception ex) {
            success = false;
        }

        return success;
    }

    private void UpdateUI() {
        for (Status status : statusList) {
            Button myButton = new Button(viewClass);
            myButton.setText(status.getStatus());
            myButton.setHeight(LayoutParams.WRAP_CONTENT);
            myButton.setWidth(LayoutParams.MATCH_PARENT);

            //LinearLayout ll = (LinearLayout) viewClass.findViewById(R.id.statusList);
            //LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
            //ll.addView(myButton, lp);
        }
    }

    public void parseStatus(InputStream in) throws XmlPullParserException, IOException{
        XmlPullParser parser = XmlPullParserFactory.newInstance().newPullParser();
        parser.setInput(in, null);
        Status status;

        int event = parser.getEventType();

        while(event != XmlPullParser.END_DOCUMENT){
            switch(event){
                case XmlPullParser.START_TAG:
                    if(parser.getName().equals("strong")){
                        status = new Status();
                        status.setUserID(parser.nextText().trim());
                    }
                    break;

                default:
                    break;
            }


        }
    }
}

