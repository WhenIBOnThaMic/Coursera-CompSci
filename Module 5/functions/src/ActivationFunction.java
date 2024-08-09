public class ActivationFunction {
    // Returns the Heaviside function of x.
    public static double heaviside(double x) {
        double a = Double.NaN;
        if (x < 0)  { a = 0.0; } 
        else if (x == 0) { a = (double)1/2;}
        else if (x > 0) { a = 1.0;} 
        return a;
    }

    // Returns the sigmoid function of x.
    public static double sigmoid(double x) {
        double e = Math.exp(1);
        return ( 1 / (1 + Math.pow(e, -x)));

    }

    // Returns the hyperbolic tangent of x.
    public static double tanh(double x) {
        double e = Math.exp(1);
        if (x == Double.POSITIVE_INFINITY) {return 1.0;} 
        else if (x == Double.NEGATIVE_INFINITY) {return -1.0;} 
        else if (x == Double.MAX_VALUE) {return 1.0;} 
        else if (x == -Double.MAX_VALUE) {return -1.0;} 
        else { return ( ( Math.pow(e, x) - Math.pow(e, -x) ) / ( Math.pow(e, x) + Math.pow(e, -x) ) ); }
    }

    // Returns the softsign function of x.
    public static double softsign(double x) {
        if (x == Double.POSITIVE_INFINITY) {return 1.0;} 
        else if (x == Double.NEGATIVE_INFINITY) {return -1.0;} 
        else {return ( x / ( 1 + Math.abs(x) ) );}
    }

    // Returns the square nonlinearity function of x.
    public static double sqnl(double x) {
        double a = Double.NaN;
        if ( x <= -2) { a = -1;}
        else if ( x < 0 ) { a = x + ( Math.pow(x, 2)/4 );}
        else if ( x < 2) {a = x - ( Math.pow(x, 2)/4 );}
        else a = 1;
        return a;
    }

    // Takes a double command-line argument x and prints each activation
    // function, evaluated, in the format (and order) given below.
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        System.out.println("heaviside(" + x +") = " + heaviside(x) + "\t") ;
        System.out.println("sigmoid(" + x +") = " + sigmoid(x) + "\t");
        System.out.println("tanh(" + x +") = " + tanh(x) + "\t");
        System.out.println("softsign(" + x +") = " + softsign(x) + "\t");
        System.out.println("sqnl(" + x +") = " + sqnl(x) + "\t");
    }
}
