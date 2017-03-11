package com.ed.inf1.ardronehack17;

/**
 * Created by kali on 10/03/17.
 */

public class Direction {
    private static float roll, pitch, yaw, x1, y1, wait;
    /*public static float[] Move (float startx, float starty,float x,float y){
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
    private static double angle, x , y;
    public static double[] TurnTime(double startx, double starty,double x1,double y1){
        x = x1-startx;
        y = y1-starty;
        double length = Math.sqrt(x*x+y*y);
        if (x >= 0) {
            if (y >= 0) {
                double angle = 90-(Math.atan2(y, x) / Math.PI * 180);
                System.out.println(angle);
            }
            if (y < 0) {
                double angle = 90-(Math.atan2(y, x) / Math.PI * 180);
                System.out.println(angle);
            }
        }
        if (x < 0) {
            if (y >= 0) {
                double angle = 450-(Math.atan2(y, x) / Math.PI * 180);
                System.out.println(angle);
            }
            if (y < 0) {
                double angle = 90-(Math.atan2(y, x) / Math.PI * 180);
                System.out.println(angle);
            }
        }
        double[] info = {length,angle};
        return info;

    }
}
