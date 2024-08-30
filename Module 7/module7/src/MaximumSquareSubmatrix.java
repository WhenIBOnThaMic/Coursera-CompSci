public class MaximumSquareSubmatrix {
        // Returns the size of the largest contiguous square submatrix
    // of a[][] containing only 1s.
    public static int size(int[][] a) {
        int n = a.length;
        int biggie = 0;
        int[][] b = a;

        for (int y = n - 2; y >= 0; y--) {
            for (int x = n - 2; x >= 0; x--) {
                if (b[x][y] != 0) b[x][y] += Math.min(b[x+1][y], Math.min(b[x+1][y+1], b[x][y+1]));
                //biggie = Math.max(biggie, b[x][y]);
            }
        }
        for (int y = n - 1; y >= 0; y--) {
            for (int x = n - 1; x >= 0; x--) {
                biggie = Math.max(biggie, b[x][y]);
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

        int returnThis = size(a);
        System.out.println(returnThis);


    }
}
