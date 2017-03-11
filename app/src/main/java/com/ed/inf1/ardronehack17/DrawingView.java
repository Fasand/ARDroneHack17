package com.ed.inf1.ardronehack17;

import android.app.AlertDialog;
import  android.content.DialogInterface;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;

/*

ENDED HERE, NEED TO ADD PHOTO POINTS

 */

import java.util.ArrayList;

class Tuple{
    float x,y;
    public boolean takePhoto;

    public Tuple(float x, float y){
        this.x = x;
        this.y = y;
        takePhoto = false;
    }
}

public class DrawingView extends View {

    private ArrayList<Tuple> tuples;

    private boolean drawingAllowed;

    private Path drawPath;
    private Paint drawPaint, canvasPaint;
    private int paintColor = 0xFF660000;
    private Canvas drawCanvas;
    private Bitmap canvasBitmap;

    public DrawingView(Context context, AttributeSet attrs){
        super(context, attrs);
        setupDrawing();
    }

    private void setupDrawing(){

        drawingAllowed = true;

        drawPath = new Path();
        drawPaint = new Paint();

        drawPaint.setAntiAlias(true);
        drawPaint.setStrokeWidth(20);
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);

        canvasPaint = new Paint(Paint.DITHER_FLAG);

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

            if(!drawingAllowed)
                return false;

            float touchX = event.getX();
            float touchY = event.getY();

            tuples.add(new Tuple(touchX, touchY));

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN://

                    drawPath.moveTo(touchX, touchY);
                    break;
                case MotionEvent.ACTION_MOVE:
                    drawPath.lineTo(touchX, touchY);
                    break;
                case MotionEvent.ACTION_UP:
                    drawCanvas.drawPath(drawPath, drawPaint);
                    drawPath.reset();

                    this.drawingAllowed = false;

                    new AlertDialog.Builder(getContext())
                            .setTitle("What to do next")
                            .setMessage("Do you want to add photo points?")
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {



                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // do nothing
                                }
                            })
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();




                    break;
                default:
                    return false;
            }

            invalidate();////
            return true;
        }
}
