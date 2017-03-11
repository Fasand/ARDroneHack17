package com.ed.inf1.ardronehack17;

import android.app.AlertDialog;
import  android.content.DialogInterface;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.widget.Toast;
import android.os.Handler;
import java.lang.Runnable;



/*

ENDED HERE, NEED TO ADD PHOTO POINTS

 */

import java.util.ArrayList;

class Tuple{
    float x,y;

    public Tuple(float x, float y){
        this.x = x;
        this.y = y;

    }
}

public class DrawingView extends View {

    private Handler handler;
    private Runnable runnable;
    private static ArrayList<Tuple> pointsOnDisplay;

    private boolean drawingAllowed;
    private boolean takingPhotoPoints;

    private Path drawPath;
    private Paint drawPaint, canvasPaint;
    private Canvas drawCanvas;
    private Bitmap canvasBitmap;


    public DrawingView(Context context, AttributeSet attrs){
        super(context, attrs);
        setupDrawing();
    }

    public static ArrayList<Tuple> getTuples(){

        return pointsOnDisplay;

    }

    private void setupDrawing(){

        handler = new Handler();
        runnable = new Runnable() {
            public void run() {

                takingPhotoPoints = false;
                SpyStart.start( TuplesToLocations.getCorrectedLocations());
            }
        };


        drawingAllowed = true;
        takingPhotoPoints = false;

        drawPath = new Path();
        drawPaint = new Paint();

        drawPaint.setAntiAlias(true);
        drawPaint.setStrokeWidth(20);
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);

        canvasPaint = new Paint(Paint.DITHER_FLAG);

        pointsOnDisplay = new ArrayList<Tuple>();


    }

    @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {

            super.onSizeChanged(w, h, oldw, oldh);
            canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
            drawCanvas = new Canvas(canvasBitmap);

        }

        @Override
        protected void onDraw(Canvas canvas) {

            canvas.drawBitmap(canvasBitmap, 0, 0, canvasPaint);
            canvas.drawPath(drawPath, drawPaint);

        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {

            if(!drawingAllowed && !takingPhotoPoints)
                return false;

            float touchX = event.getX();
            float touchY = event.getY();

            if(drawingAllowed)
                pointsOnDisplay.add(new Tuple(touchX, touchY));

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN://
                    if(drawingAllowed)
                        drawPath.moveTo(touchX, touchY);

                    if(takingPhotoPoints) {

                        TuplesResult tr = TuplesToLocations.addPhoto(touchX, touchY, pointsOnDisplay);
                        if(tr.onLine){

                            drawPath.addCircle(tr.x, tr.y, 10f, Path.Direction.CW);
                            handler.removeCallbacks(runnable);
                            handler.postDelayed(runnable, 2000);
                        }
                    }


                    break;
                case MotionEvent.ACTION_MOVE:
                    if(drawingAllowed)
                        drawPath.lineTo(touchX, touchY);
                    break;
                case MotionEvent.ACTION_UP:

                    if(drawingAllowed) {

                        drawCanvas.drawPath(drawPath, drawPaint);
                        drawPath.reset();

                        this.drawingAllowed = false;

                        new AlertDialog.Builder(getContext())
                                .setTitle(
                                        "What to do next")
                                .setMessage("Do you want to add photo points?")
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {

                                        Toast.makeText(getContext(), "Select photo points!", Toast.LENGTH_SHORT).show();
                                        drawPaint.setColor(new Color().argb(255,255,0,0));
                                        drawPaint.setStrokeWidth(30);
                                        canvasPaint.setStyle(Paint.Style.FILL);
                                        takingPhotoPoints = true;


                                    }
                                })
                                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        // do nothing
                                    }
                                })
                                .setIcon(android.R.drawable.ic_dialog_alert)
                                .show();

                    }else{ //photo Taking

                    }


                    break;
                default:
                    return false;
            }

            invalidate();
            return true;
        }
}
