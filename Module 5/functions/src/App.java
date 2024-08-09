public class App {
    public static void main(String[] args) throws Exception {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int lcm = 0;
        for ( int i = a; lcm == 0; i += a ) {
             if (i % b == 0) {
                  lcm = i;
                  break;
             }
        }
        System.out.println(lcm);
}
}
