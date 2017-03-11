package com.ed.inf1.ardronehack17;


import java.util.ArrayList;

/**
 * Created by kali on 11/03/17.
 */

public class SpyStart {

    private static float[][] locationFloats;

    public static float[][] getLocationFloats(){

        return locationFloats;

    }

    public static void start(ArrayList<Location> locations){

        float[][] allinfo = new float[locations.size()][2];
        for (int i=1;i<locations.size();i++){
            float[] info = Direction.TurnTime(locations.get(i-1).getX(),locations.get(i-1).getY(),locations.get(i).getX(),locations.get(i).getY());
            allinfo[i-1][0] = info[0];
            allinfo[i-1][1] = info[1];
        }
        locationFloats = allinfo;
    }
}
