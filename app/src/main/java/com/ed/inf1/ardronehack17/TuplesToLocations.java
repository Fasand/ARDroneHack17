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

        locations = new ArrayList<Location>();

    }

    public static boolean addPhoto( float x, float y , ArrayList<Tuple> pointsOnDisplay){

        final float offset = 10.0f;
        float dX, dY;

        for(int i = 0; i < pointsOnDisplay.size(); ++i){

            dX = pointsOnDisplay.get(i).x;
            dY = pointsOnDisplay.get(i).y;

            if(Math.abs(dX - x) <= offset && Math.abs(dY - y) <= offset){

                for(int i2 = 0; i2 < locations.size(); ++i2){

                    if(dX == locations.get(i2).getX() && dY == locations.get(i2).getY())
                        locations.get(i2).takePhoto();
                    else{

                       try {
                           locations.add(new Location( dX, dY, true ));
                       } catch (Exception e) {
                           e.printStackTrace();
                       }

                     }
                }
                return true;

            }
        }

        return false;
    }

    public static void setTuples(ArrayList<Tuple> locs){

        for(int i = 0; i < locs.size(); ++i){

            if(i % 20 == 0){

                try {
                    locations.add(new Location(absToRelX(locs.get(i).x), absToRelY(locs.get(i).y)));
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
