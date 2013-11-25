package com.mindcast;

import android.content.Context;
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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ashwin on 11/24/13.
 */
public class StatusFeed {

    private List<Status> statusList;
    private MainActivity viewClass;
    private String url, domain, protocol, path;


    public StatusFeed(MainActivity mainActivity) {
        this.viewClass = mainActivity;
        statusList = new ArrayList<Status>();

        domain = "";
        protocol = "http";
        path = "/MindCast/scripts/php/chat.php";

        url = protocol + "://" + domain + path;

        getStatuses();
    }

    private boolean getStatuses(){
        new HttpObject().execute(url);

        // TODO: Create HttpRequest object here and pass it to populateStatusList()
        boolean success = populateStatusList();

        if(success)
        {
            for(Status status : statusList){
                Button myButton = new Button(viewClass);
                myButton.setText(status.getStatus());
                myButton.setHeight(LayoutParams.WRAP_CONTENT);
                myButton.setWidth(LayoutParams.MATCH_PARENT);

                LinearLayout ll = (LinearLayout)viewClass.findViewById(R.id.statusList);
                LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
                ll.addView(myButton, lp);
            }
        }
        else {
            success = false;
        }

        return success;
    }

    private boolean populateStatusList(){
        boolean success = true;

        try{
            statusList.add( new Status("SampleUser", "SampleStatus") );
            statusList.add( new Status("SampleUser", "SampleStatus") );
            statusList.add( new Status("SampleUser", "SampleStatus") );
            statusList.add( new Status("SampleUser", "SampleStatus") );
        }

        catch(Exception ex){
            success = false;
        }

        return success;
    }

}

