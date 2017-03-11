package com.ed.inf1.ardronehack17;

import java.util.ArrayList;
import android.view.WindowManager;
import android.view.Display;
import  android.graphics.Point;

/**
 * Created by milos on 3/11/17.
 */

public class TuplesToLocations {

    private static final int SAMPLING_FREQUENCY = 20;
    private static int maxX;
    private static int maxY;
    private static ArrayList<Location> locations;


    public static void init(WindowManager vm){

        Display display = vm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        maxX = size.x;
        maxY = size.y;

    }

    public static void setTuples(ArrayList<Tuple> locs){

        for(int i = 0; i < locs.size(); ++i){

            if(i % 20 == 0){

                try {
                    locations.add(new Location(absToRelX(locs.get(i).x), absToRelY(locs.get(i).y),locs.get(i).takePhoto));
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }


        }

    }

    private static float absToRelX(float x){

        return x/maxX * 100;

    }

    private static float absToRelY(float y){

        return y/maxY * 100;

    }

}
