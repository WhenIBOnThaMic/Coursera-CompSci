public class ShannonEntropy {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        double[] Integers = new double[m + 1];
        double count = 0;
        double ShannonEntropy = 0;
        
        while (!StdIn.isEmpty()) {
            Integers[StdIn.readInt()] += 1;
            count += 1;
        }
        
        for (int comb = 1; comb <= m; comb++) {
            double x = (Integers[comb]);
            if (x != 0.0) ShannonEntropy += -( ( x/count ) * ( Math.log(x/count) / Math.log(2) ) );
        }
        StdOut.printf("%.4f",ShannonEntropy);
        
        
    }
}
