/**
 * Created by fasand on 11/03/17.
 */

public class Location {
    private int x;
    private int y;
    private boolean takePhoto;

    public Location(int xi, int yi) {
        x = xi;
        y = yi;
        takePhoto = false;
    }

    public Location(int xi, int yi, boolean takePhotoi) {
        x = xi;
        y = yi;
        takePhoto = takePhotoi;
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
}
