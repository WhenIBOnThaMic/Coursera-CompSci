public class RandomWalkers {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        long totalSteps = 0;
        for (int a = 1; a <= trials; a++) {
                int Xcoords = 0;
                int Ycoords = 0;
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
                    if (Math.abs(Xcoords) + Math.abs(Ycoords) == r) {
                        totalSteps += steps;
                        break;
                    }
                }
                if (a == trials) {
                    System.out.println(totalSteps);
                    System.out.println("avg " + (double)totalSteps/(double)trials);
                }
        }
    }
}
