public class App {
    public static void main(String[] args) throws Exception {
        In input = new In(args[0]);
        String[] a = input.readAllStrings();
        System.out.println(a.length/4);
    }
}
