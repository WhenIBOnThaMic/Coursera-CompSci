public class Birthday {
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        
        int[] peopleAmount = new int[n];
        double cumPeople = 0;

        for (int trialsCount = 0; trialsCount < trials; trialsCount++){
            boolean[] birthdaysArray = new boolean[n];
            for (int birthdaysCount = 0; birthdaysCount < n; birthdaysCount++) {
                int randBirthday = (int)(Math.random()*n);
                if (birthdaysArray[randBirthday] == false) {
                    birthdaysArray[randBirthday] = true;
                } else { 
                    peopleAmount[birthdaysCount] += 1;
                    break; 
                }
            }           
        }
            
        for (int row = 0; row < n - 1; row++) {
            cumPeople += peopleAmount[row];
            System.out.println((row + 1) + "\t" + peopleAmount[row] + "\t" + cumPeople/trials);
            if (cumPeople/trials > 0.5) break;
        }

    }
}
