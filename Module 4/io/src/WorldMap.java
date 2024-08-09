public class WorldMap {
    public static void main(String[] args) {
        int xScale = StdIn.readInt();
        int yScale = StdIn.readInt();
        StdDraw.setCanvasSize(xScale, yScale);
        StdDraw.setXscale(0, xScale);
        StdDraw.setYscale(0, yScale);

        while (!StdIn.isEmpty()) {
            String scrap = StdIn.readString(); //skip the name
            String a = scrap;
            scrap = a;
            int length = StdIn.readInt();
            double[] x = new double[length];
            double[] y = new double[length];
            for (int i = 0; i < length; i++) {
                x[i] = StdIn.readDouble();
                y[i] = StdIn.readDouble();
            }
            StdDraw.polygon(x, y);
        }
    }
}
