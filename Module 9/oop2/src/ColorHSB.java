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
    
    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) throws IllegalArgumentException{
        if (that == null) throw new IllegalArgumentException();
        int hueDiff = hue - that.hue;
        int saturationDiff = saturation - that.saturation;
        int brightnessDiff = brightness - that.brightness;
        int squaredDistance = Math.min( hueDiff*hueDiff, (360 - (Math.abs(hueDiff)))*(360 - (Math.abs(hueDiff))) ) + saturationDiff*saturationDiff + brightnessDiff*brightnessDiff;
        //squared distance formula
        return squaredDistance;
    }
    
    // Sample client (see below).
    public static void main(String[] args) {
        ColorHSB referenceColor = new ColorHSB(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
        In input = new In();
        String[] allColorsArray = input.readAllStrings(); //a string of everything the input read
        int amountOfColors = allColorsArray.length/4; //each color has 4 inputs, so # of colors = # of inputs/4

        String[] colorNamesArray = new String[amountOfColors]; //array of color names in their corresponding positions ( 1 - 16 )
        ColorHSB[] ColorHSBsArray = new ColorHSB[amountOfColors]; //array of ColorHSB objects in their corresponding positions ( 1 - 16 )

        int distanceToReferenceColor = 148881; //the max distance that two colors can have i.e (0, 0, 0) to (359, 100, 100)
        String closestToReferenceColor = ""; //to print
        for (int i = 0; i < amountOfColors; i++) {
            colorNamesArray[i] = allColorsArray[4*i];
            ColorHSBsArray[i] = new ColorHSB(Integer.parseInt(allColorsArray[4*i + 1]), Integer.parseInt(allColorsArray[4*i + 2]), Integer.parseInt(allColorsArray[4*i + 3]));
            //initializing namesArray and HSBsArray
            if (referenceColor.distanceSquaredTo(ColorHSBsArray[i]) < distanceToReferenceColor) {
                distanceToReferenceColor = referenceColor.distanceSquaredTo(ColorHSBsArray[i]);
                closestToReferenceColor = colorNamesArray[i] + " " + ColorHSBsArray[i].toString();
            }
            //scan all colors to find closest
        } 


        System.out.print(closestToReferenceColor);



    }

}