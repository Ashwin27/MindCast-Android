package com.mindcast;

import android.content.Context;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

import java.util.List;

/**
 * Created by Ashwin on 11/24/13.
 */
public class StatusFeed {

    private List<Status> statusList;
    private MainActivity viewClass;

    public StatusFeed(MainActivity mainActivity) {
        getStatuses();
        this.viewClass = mainActivity;
    }

    private boolean getStatuses(){
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

