public class RandomWalker {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int Xcoords = 0;
        int Ycoords = 0;
        System.out.println("(0, 0)");
        for (int steps = 1; Math.abs(Xcoords) + Math.abs(Ycoords) <= r; steps++) {
            double random = Math.random();
            if (random < 0.25) {
                Xcoords++ ; 
            } else if (random < 0.5) {
                Xcoords-- ; 
            } else if (random < 0.75) {
                Ycoords++ ; 
            } else {
                Ycoords-- ; 
            } 
            System.out.println("(" + Xcoords + ", " + Ycoords + ")");
            if (Math.abs(Xcoords) + Math.abs(Ycoords) == r) {
                System.out.println("steps = " + steps);
                break;
            }
        }
    }
}
