package com.ed.inf1.ardronehack17;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.String;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.util.StringTokenizer;
import android.util.Log;


/**
 * Created by kali on 11/03/17.
 */

public class SpyStart {

    public ArrayList<Location> directions;

    public void start(ArrayList<Location> locations) {
        directions = new ArrayList<>();
        for (int i = 1; i < locations.size(); i++) {
            float[] lengthangle = Direction.TurnTime(locations.get(i - 1).getX(), locations.get(i - 1).getY(), locations.get(i).getX(), locations.get(i).getY());
            directions.get(i - 1).setX(lengthangle[0]);
            directions.get(i - 1).setY(lengthangle[1]);
            directions.get(i - 1).takePhoto(locations.get(i - 1).shouldTakePhoto());
        }
for(int i = 0; i < directions.size(); ++i)
        Log.d("soyamilk", String.valueOf( directions.get(i).getX())+" "+String.valueOf( directions.get(i).getY())+" "+String.valueOf( directions.get(i).shouldTakePhoto()),null);




    }
    public ArrayList<Location> getDirections() { return directions;}
}