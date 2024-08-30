public class Inversions {
        // Return the number of inversions in the permutation a[].
    public static long count(int[] a) {
        int inversions = 0;
        for (int i = 0; i < a.length; i++ ) {
            for (int k = a.length - 1; k > i; k--) {
                if (a[k] > a[i]) inversions++;
            }
        }
        return inversions;
    }

    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k) {
        
        if (n == 1) {
            int[] permutation = {1};
            return permutation;
        }

        if (k == 0) {
            int[] permutation = new int[n];
            for (int i = 0; i < n; i++) {
                permutation[i] = i;                    
            }
            return permutation;
        }

        //where actual generation begins
        int[] permutation = new int[n];
        for (int i = 0; i < n; i++) {
            permutation[i] = i;
        } 

        int m = 0;
        for (int m2 = 0; m2 < n; m2++) {
            if (m2*(m2-1)/2 <= k) m = m2;
        }

        for (int i = 0; i < m/2; i++) {
            int temp = permutation[i];
            permutation[i] = permutation[m - 1 - i];
            permutation[m - 1 - i] = temp;
        }


        
        long inversionsLeft =  k - m*(m-1)/2;
        for (int i = n - 1; inversionsLeft > 0; i--) {
            int temp = permutation[i];
            permutation[i] = permutation[i-1];
            permutation[i-1] = temp;
            inversionsLeft--;
        }
        return permutation;

    }

    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);
        int[] tempArray = generate(n, k);
        String temp = "";
        for (int i = 0; i < n; i++) {
            temp = temp + tempArray[i] + " " ;
        }
        System.out.println(temp);
    }

}
