/**
 * Created by fasand on 11/03/17.
 */

/**
 * MIN_BOUND = Location(0, 0)
 * MAX_BOUND = Location(100, 100)
 */

public class Location {
    private int x;
    private int y;
    private boolean takePhoto;

    // Inclusive ==> can have location (0,0) or (100,100)
    private int MIN_BOUND = 0;
    private int MAX_BOUND = 100;

    public Location(int xi, int yi) throws Exception {
        if(isWithinBounds(xi, yi)) {
            x = xi;
            y = yi;
            takePhoto = false;
        } else throw new Exception("Location out of bounds!");
    }

    public Location(int xi, int yi, boolean takePhotoi) throws Exception {
        if(isWithinBounds(xi, yi)) {
            x = xi;
            y = yi;
            takePhoto = takePhotoi;
        } else throw new Exception("Location out of bounds! x="+xi+"; y="+yi);
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean shouldTakePhoto() {
        return takePhoto;
    }

    private boolean isWithinBounds(int xi, int yi) {
        if(xi > MAX_BOUND || xi < MIN_BOUND || yi > MAX_BOUND || yi < MIN_BOUND) {
            return false;
        }
        return true;
    }
}
