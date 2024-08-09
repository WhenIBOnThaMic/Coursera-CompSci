public class MaximumSquareSubmatrix {
        // Returns the size of the largest contiguous square submatrix
    // of a[][] containing only 1s.
    public static int size(int[][] a) {
        int n = a.length;
        int biggie = 0;

        for (int y = n - 2; y >= 0; y--) {
            for (int x = n - 2; x >= 0; x--) {
                if (a[x][y] != 0) a[x][y] += Math.min(a[x+1][y], Math.min(a[x+1][y+1], a[x][y+1]));
                biggie = Math.max(biggie, a[x][y]);
            }
        }

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n ; x++) {
                    System.out.println(a[x][y]);
            }
        }

        return biggie;

       
    }

    // Reads an n-by-n matrix of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s.
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[][] a = new int[n][n];
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                a[x][y] = StdIn.readInt();
            }
        }

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n ; x++) {
                    System.out.println(a[x][y]);
            }
        }
        int returnThis = size(a);
        System.out.println( "\n" + returnThis);


    }
}
