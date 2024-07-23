public class Checkerboard {
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        StdDraw.setScale(0, n);
        boolean blue = true;
        if (n % 2 == 0) blue = false;
        //setting up stuff
        for (int row = 0; row < n; row++) {
            for (int column = 0; column < n; column++) {
                if (blue == true) StdDraw.setPenColor(StdDraw.BLUE);
                else StdDraw.setPenColor(StdDraw.GRAY);
                StdDraw.filledRectangle(row + 0.5, column + 0.5, 0.5, 0.5);
                blue = !blue;
            }
        } //if last square blue this square grey and vice versa
    }
}
