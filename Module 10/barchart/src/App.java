public class App {
    public static void main(String[] args) throws Exception {
        In a = new In();
        String first = a.readLine();
        String second = a.readLine();
        String third = a.readLine();


        String[] b = a.readAllLines();
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }
}
