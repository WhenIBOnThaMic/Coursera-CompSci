
public class ThueMorse {
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        String[][] ThueMorse = new String[n][n];
        ThueMorse[0][0] = "+  ";
        ThueMorse[0][1] = "-  ";

        for (int initialSeq = 2; initialSeq < 2*n; initialSeq*=2) {
            for (int checkAndAssign = initialSeq/2; checkAndAssign < initialSeq; checkAndAssign++ ) {
                if (checkAndAssign == n) break;
                if (ThueMorse[0][checkAndAssign - initialSeq/2] == "+  ") ThueMorse[0][checkAndAssign] = "-  ";
                if (ThueMorse[0][checkAndAssign - initialSeq/2] != "+  ") ThueMorse[0][checkAndAssign] = "+  ";
            }
        }
        
        for (int row = 1; row < n; row++) {
            for (int index = 0; index < n; index++) {
                if (ThueMorse[0][row] == ThueMorse[0][index]) ThueMorse[row][index] = "+  ";
                else ThueMorse[row][index] = "-  ";
            }
        }

        for (int printRow = 0;  printRow < n;  printRow++) {
            String rowToPrint = "";
            for (int printIndex = 0;  printIndex < n;  printIndex++){
                rowToPrint += ThueMorse[printRow][printIndex] + "  ";
            }  
            System.out.println(rowToPrint);
        }
    }
}
