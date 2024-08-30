public class App {
    public static long count(int[] a) {
        int inversions = 0;
        for (int i = 0; i < a.length; i++ ) {
            for (int k = a.length - 1; k > i; k--) {
                if (a[i] > a[k]) inversions++;
            }
        }
        return inversions;
    }
    public static void main(String[] args) throws Exception {
        int[] a = { 1, 0 };
       System.out.print(count(a));


}
}