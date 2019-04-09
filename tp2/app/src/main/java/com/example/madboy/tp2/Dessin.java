package com.example.madboy.tp2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;



class Point implements Parcelable {
    float x,y,width;
    int color;

    public Point (Parcel in ) {
        x = in.readFloat();
        y = in.readFloat();
        color = in.readInt();
        width = in.readFloat();
    }

    public Point(float x, float y, float width, int color){
        this.x=x;
        this.y=y;
        this.width=width;
        this.color=color;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel (Parcel  dest,int flags)  {
        dest.writeFloat(x);dest.writeFloat(y) ;
        dest.writeInt(color) ;
        dest.writeFloat(width) ;
    }
}

public class Dessin extends View {
    ArrayList<Point> pl;
    float width =10;
    int color = Color.BLACK;

    public Dessin(Context context, AttributeSet attrs){
        super(context, attrs);
        pl = new ArrayList<>();
    }

    public void setWidth(float width){
        this.width=width;
    }
    public void setColor(int couleur){
        switch (couleur) {
            case 1:
                this.color = Color.BLACK;
                break;
            case 2:
                this.color = Color.GREEN;
                break;
            case 3:
                this.color = Color.YELLOW;
                break;
            default:
                this.color = Color.GRAY;
        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        pl.add(new Point(event.getX(),event.getY(),width,color));
        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        for(Point p:pl){
            Paint paint = new Paint();
            paint.setColor(p.color);
            paint.setStrokeWidth(p.width);
            canvas.drawPoint(p.x,p.y,paint);
        }
    }
}
