public class BandMatrix {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int width = Integer.parseInt(args[1]);
        for (int columns = 1; columns <= n; columns++) {
            String row = "";
            for (int elements = 1; elements <= n; elements++) {
                if ( elements >= (columns - width) && elements <= (columns + width) ) {
                    row += "*  ";
                } else row += "0  ";
            }
            System.out.println(row);
        }   
    }
}
