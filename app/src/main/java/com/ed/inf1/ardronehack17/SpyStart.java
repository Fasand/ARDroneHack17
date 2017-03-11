package com.ed.inf1.ardronehack17;


import java.util.ArrayList;

/**
 * Created by kali on 11/03/17.
 */

public class SpyStart {

    public static ArrayList<Location> directions;

    public static void start(ArrayList<Location> locations) {
        directions = new ArrayList<>();
        for (int i = 1; i < locations.size(); i++) {
            float[] lengthangle = Direction.TurnTime(locations.get(i - 1).getX(), locations.get(i - 1).getY(), locations.get(i).getX(), locations.get(i).getY());
            directions.get(i - 1).setX(lengthangle[0]);
            directions.get(i - 1).setY(lengthangle[1]);
            directions.get(i - 1).takePhoto(locations.get(i - 1).shouldTakePhoto());
        }

    }
    public static ArrayList<Location> getDirections() { return directions;}
}