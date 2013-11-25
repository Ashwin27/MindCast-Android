package com.mindcast;

import android.content.Context;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import java.util.List;

/**
 * Created by Ashwin on 11/24/13.
 */
public class StatusFeed {

    private List<Status> statusList;

    public StatusFeed(){
        getStatuses();
    }

    private boolean getStatuses(){
        // TODO: Create HttpRequest object here and pass it to populateStatusList()
        boolean success = populateStatusList();

        return success;
    }

    private boolean populateStatusList(){
        boolean success = true;

        try{
            statusList.add( new Status("SampleUser", "SampleStatus") );
        }

        catch(Exception ex){
            success = false;
        }

        return success;
    }


}

