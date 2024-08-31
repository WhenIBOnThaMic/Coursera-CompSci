public class ColorHSB {
    private final int hue;
    private final int saturation;
    private final int brightness;

    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) throws IllegalArgumentException {
        if (h > 359 || h < 0) throw new IllegalArgumentException();
        if (s < 0 || s > 100) throw new IllegalArgumentException();
        if (s < 0 || s > 100) throw new IllegalArgumentException();
        //conditions 
        hue = h;
        saturation = s;
        brightness = b;        

    }
    
    // Returns a string representation of this color, using the format (h, s, b).
    public String toString() {
        String stringRep = "(" + hue + ", " + saturation + ", " + brightness + ")";
        return stringRep; 
    }
    
    // Is this color a shade of gray?
    public boolean isGrayscale() {
        if (saturation == 0 || brightness == 0) {return true;}
        else {return false;}
    }
    /*
    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
    }
    */
    // Sample client (see below).
    public static void main(String[] args) {
        ColorHSB a = new ColorHSB(0, 0, 50);
    }

}