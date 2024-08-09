public class Divisors {
     // Returns the greatest common divisor of a and b.
     public static int gcd(int a, int b) {
        /*
        int gcd = 0;
        for ( int i = Math.max(Math.abs(a), Math.abs(b)); i > 0; i-- ) {
          if ( a % i == 0) {
               if (b % i == 0) {
                    gcd = i;
                    break;
               }
          }
        }
        return gcd;
        */
          if (b==0) return Math.abs(a);
          return gcd(b, a%b);
     }

     // Returns the least common multiple of a and b.
     public static int lcm(int a, int b) {
          int lcm = 0;
          for ( int i = a; lcm == 0; i += a ) {
               if (i % b == 0) {
                    lcm = i;
                    break;
               }
          }
          return lcm;
     }
 
     // Returns true if a and b are relatively prime; false otherwise.
     public static boolean areRelativelyPrime(int a, int b) {
          boolean temp = false;
          if (gcd(a, b) == 1) {
               temp = true;
          }
          return temp;

     }
 
     // Returns the number of integers between 1 and n that are
     // relatively prime with n.
     public static int totient(int n) {
          int numberOfInts = 0;
          for (int i = 0; i < n; i++) {
               if (areRelativelyPrime(i, n)) {
                    numberOfInts += 1;
               }
          }
          return numberOfInts;
     }
 
     // Takes two integer command-line arguments a and b and prints
     // each function, evaluated in the format (and order) given below.
     public static void main(String[] args) {
          int a = Integer.parseInt(args[0]);
          int b = Integer.parseInt(args[1]);
          System.out.println("gcd(" + a + ", " + b + ") = " + gcd(a, b));
          System.out.println("lcm(" + a + ", " + b + ") = " + lcm(a, b));
          System.out.println("areRelativelyPrime(" + a + ", " + b + ") = " + areRelativelyPrime(a, b));
          System.out.println("totient(" + a + ") = " + totient(a));
          System.out.println("totient(" + b + ") = " + totient(b));
     }
}
