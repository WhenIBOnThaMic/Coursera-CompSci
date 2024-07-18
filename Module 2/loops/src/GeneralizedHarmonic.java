public class GeneralizedHarmonic {
    public static void main(String[] args) {
        int r  = Integer.parseInt(args[1]);
        double GeneralizedHarmonicNumber = 0;
        for (int n = 1; n <= Integer.parseInt(args[0]); n++) {
            GeneralizedHarmonicNumber += ( 1 / Math.pow((double)n, (double)r) );
        }
        System.out.println(GeneralizedHarmonicNumber );
    }
}
