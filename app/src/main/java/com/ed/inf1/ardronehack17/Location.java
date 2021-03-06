package com.ed.inf1.ardronehack17;

/**
 * Created by fasand on 11/03/17.
 */

/**
 * MIN_BOUND = Location(0, 0)
 * MAX_BOUND = Location(100, 100)
 */

public class Location {
    private float x;
    private float y;
    private boolean takePhoto;

    // Inclusive ==> can have location (0,0) or (100,100)
    private int MIN_BOUND = 0;
    private int MAX_BOUND = 100;

    public Location(float xi, float yi) throws Exception {
        if(isWithinBounds(xi, yi)) {
            x = xi;
            y = yi;
            takePhoto = false;
        } else throw new Exception("Location out of bounds!");
    }

    public void takePhoto(){

        takePhoto = true;

    }

    public Location(float xi, float yi, boolean takePhotoi){
        if(isWithinBounds(xi, yi)) {
            x = xi;
            y = yi;
            takePhoto = takePhotoi;
        }
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public void setX(float x)  { this.x=x; }

    public void setY(float y)  { this.y=y; }

    public void takePhoto(boolean t) {takePhoto = t;}


    public boolean shouldTakePhoto() {
        return takePhoto;
    }

    private boolean isWithinBounds(float xi, float yi) {
        return !(xi > MAX_BOUND || xi < MIN_BOUND || yi > MAX_BOUND || yi < MIN_BOUND);
    }
}
