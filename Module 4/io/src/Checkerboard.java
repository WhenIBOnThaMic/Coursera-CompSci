public class Checkerboard {
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        StdDraw.setScale(0, n);
        StdDraw.setPenColor(StdDraw.GRAY);

        for (double y = 0; y < n; y++) {
            for (double x = 0; x < n; x++) {
                StdDraw.filledSquare(x + 0.5, y + 0.5, 0.5);
                if (StdDraw.getPenColor() == StdDraw.GRAY) {
                    StdDraw.setPenColor(StdDraw.BLUE);
                } else {StdDraw.setPenColor(StdDraw.GRAY);}
            }
            if (n%2 == 0) {
                if (StdDraw.getPenColor() == StdDraw.GRAY) {
                    StdDraw.setPenColor(StdDraw.BLUE);
                } else {StdDraw.setPenColor(StdDraw.GRAY);}

            }
        }
    }
}
