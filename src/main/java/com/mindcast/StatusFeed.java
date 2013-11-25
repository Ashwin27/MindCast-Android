package com.mindcast;

import android.content.Context;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

/**
 * Created by Ashwin on 11/24/13.
 */
public class StatusFeed {

    public StatusFeed(){

    }

    private Status getStatuses(){
        return new Status("SampleUser", "SampleStatus");
    }


}

