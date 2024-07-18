import java.util.Arrays;

public class Minesweeper {
    public static void main(String[] args) {

        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);
        boolean[][] minefield = new boolean[m][n]; 
        int[][] toPrint = new int[m+2][n+2]; //to print
        int[] toPick = new int[m*n]; //array for rand position picker

        for (int i = 0; i < toPick.length; i++){
            toPick[i] = i;
        } //assign values from 1 - 20 to toPick

        for (int i = 0; i < k; i++){
            int index = i + (int)( Math.random()*(toPick.length - i) );
            int temp = toPick[i];
            toPick[i] = toPick[index];
            toPick[index] = temp;
            minefield[toPick[i]/n][toPick[i]%n] = true;
        } //randomize the first k values inside toPick, flip corresponding k indexes to "true"
        
        for (int row = 0; row < m; row++) {
            for (int column = 0; column < n; column++ ) {
                if (minefield[row][column] == true) { //comb through the minefield to check for "true"s (mines)
                    for (int rowToPrint = row; rowToPrint < row + 3; rowToPrint++) {
                        for (int columnToPrint = column; columnToPrint < column + 3; columnToPrint++){
                            toPrint[rowToPrint][columnToPrint] += 1;
                        } //comb through the 8 (9) indexes around the mine and add 1 to each
                    }
                    toPrint[row + 1][column + 1] = 9; //set the mine's spot on toPrint to 9 (unreachable through normal means)
                }
            }
        }

        
        for (int row = 1; row < m + 1; row ++) {
            String printThisLine = "";
            for (int column = 1; column < n + 1; column++) {
                if (toPrint[row][column] >= 9) {
                    printThisLine += "*  ";
                } else { printThisLine += toPrint[row][column] + "  "; }
            } 
            System.out.println(printThisLine);
        }//going through stuff that need to be printed in the toPrint array
    }
}
