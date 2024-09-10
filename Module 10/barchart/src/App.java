public class App {
    public static void main(String[] args) throws Exception {
        In a = new In();
        while (!a.isEmpty()) {
            int num = a.readInt();
            a.readLine();
            String text = a.readLine();
            System.out.println(num);
            System.out.println(text);
            //if (a.isEmpty()) {a.close(); }
        }
        a.close(); 
    }
}
