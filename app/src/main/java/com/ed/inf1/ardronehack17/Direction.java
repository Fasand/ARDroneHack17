package com.ed.inf1.ardronehack17;

/**
 * Created by kali on 10/03/17.
 */

public class Direction {
    private static int roll, pitch, yaw, x1, y1;
    public static int[] Move (int x,int y,int startx, int starty){
            x1 = Math.abs(startx-x);
            y1 = Math.abs(starty-y);
        if (x>startx)
            roll = ((x1+y1)/x1)*100;
        if (x<startx)
            roll = ((x1+y1)/x1)*(-100);
        if (y>starty)
            pitch = ((x1+y1)/y1)+100;
        if (y<starty)
            pitch = ((x1+y1)/y1)*(-100);
        int[] directions =new int[]{roll, pitch};
        return directions;

    }
}
