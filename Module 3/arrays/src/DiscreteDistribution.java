public class DiscreteDistribution {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int cumSum = 0;
        for (int argsCounter = 1; argsCounter < args.length; argsCounter++) {
            cumSum += Integer.parseInt(args[argsCounter]);
        }
        String output = "";
        for (int randIntCounter = 0; randIntCounter < m; randIntCounter++) {
            double randInt = Math.random()*cumSum;
            int SMark = 0;
            for (int marks = 1; marks < args.length; marks++){
                SMark += Integer.parseInt(args[marks]);
                if ((int)randInt < SMark) {
                    output += marks + " ";
                    break;
                } 
            }
        }
        System.out.println(output);
    }
}