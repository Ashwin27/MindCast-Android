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
public class StatusFeed extends View {

    public StatusFeed(Context context){
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Rect bkgd = new Rect();
        bkgd.set(0, 0, canvas.getWidth(), canvas.getHeight());

        Paint bkgdImg = new Paint();
        bkgdImg.setColor(Color.BLUE);
        bkgdImg.setStyle(Paint.Style.FILL);

        canvas.drawRect(bkgd, bkgdImg);
    }

    private Status getStatuses(){
        return new Status("SampleUser", "SampleStatus");
    }


}

