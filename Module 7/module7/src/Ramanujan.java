public class Ramanujan {
    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n) {
        int count = 0;
        for (long a = 1; a < Math.cbrt(n); a++) {
            double b = Math.cbrt(n - a*a*a);
            if (b%(int)b == 0) { count++;}
        }
        return count >= 4;
    }
    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args) {
        System.out.println( isRamanujan( Long.parseLong(args[0]) ) );
    }
}
