public class RevesPuzzle {
    public static void towerOfHanoi(int n, char from_rod, char to_rod, char aux_rod1, char aux_rod2)
    {   /*
        String from_rod = "A";
        String to_rod = "D";
        String aux_rod1 = "B";
        String aux_rod2 = "C";
        */
        if (n == 0)
            return;
        if (n == 1) {
            System.out.println("Move disk " + n +" from " + from_rod +" to " + to_rod);
            return;
        }
 
        towerOfHanoi(n - 2, from_rod, aux_rod1, aux_rod2, to_rod);
        System.out.println("Move disk " + (n - 1) + " from " + from_rod + " to " + aux_rod2);
        System.out.println("Move disk " + n + " from " + from_rod + " to " + to_rod);
        System.out.println("Move disk " + (n - 1) + " from " + aux_rod2 + " to " + to_rod);
        towerOfHanoi(n - 2, aux_rod1, to_rod, from_rod, aux_rod2);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        towerOfHanoi(n, 'A', 'D', 'B', 'C');
    }
}
