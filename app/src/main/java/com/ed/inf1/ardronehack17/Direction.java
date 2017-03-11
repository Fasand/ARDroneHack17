package com.ed.inf1.ardronehack17;

/**
 * Created by kali on 10/03/17.
 */

public class Direction {
    /*private static float roll, pitch, yaw, x1, y1, wait;
    public static float[] Move (float startx, float starty,float x,float y){
            x1 = Math.abs(startx-x);
            y1 = Math.abs(starty-y);
        if (x>startx)
            roll = ((x1+y1)/x1);
        if (x<startx)
            roll = ((x1+y1)/x1)+1;
        if (y>starty)
            pitch = ((x1+y1)/y1);
        if (y<starty)
            pitch = ((x1+y1)/y1)+1;
        int[] directions =new float[]{roll, pitch,wait};*/
    private static float angle, x , y;
    public static float[] TurnTime(float startx, float starty,float x1,float y1){
        x = x1-startx;
        y = y1-starty;
        float length = Math.sqrt(x*x+y*y);
        if (x >= 0) {
            if (y >= 0) {
                float angle = 90-(Math.atan2(y, x) / Math.PI * 180);
                System.out.println(angle);
            }
            if (y < 0) {
                float angle = 90-(Math.atan2(y, x) / Math.PI * 180);
                System.out.println(angle);
            }
        }
        if (x < 0) {
            if (y >= 0) {
                float angle = 450-(Math.atan2(y, x) / Math.PI * 180);
                System.out.println(angle);
            }
            if (y < 0) {
                float angle = 90-(Math.atan2(y, x) / Math.PI * 180);
                System.out.println(angle);
            }
        }
        float[] info = {length,angle};
        return info;

    }
}
