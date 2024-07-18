public class RightTriangle {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        int biggest = Math.max(a, Math.max(b , c));
        int smallest = Math.min(a, Math.min(b , c));
        int middle = a + b + c - biggest - smallest;
        System.out.println(c >= 0 && b >= 0 && a >= 0 && (smallest * smallest + middle*middle) == biggest*biggest);
    }
}
