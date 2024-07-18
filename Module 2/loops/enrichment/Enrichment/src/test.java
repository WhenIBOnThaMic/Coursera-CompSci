public class test {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        for (int nscan = n; n > 1; n--) {
            double firstNum = 1;
            double secondNum = n - 1;
            int satisfyingPairs = 0;
            for (double combinations = Math.floor( (n - 2) / 2); combinations > 0; combinations--) {
                firstNum++;
                secondNum--;
                
            }
        }
    }
}
