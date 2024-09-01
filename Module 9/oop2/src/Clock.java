public class Clock {
    private int hour;
    private int minute;
    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) throws IllegalArgumentException {
        if (h < 0 || h > 23 || m < 0 || m > 59) throw new IllegalArgumentException();
        hour = h;
        minute = m;
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s) throws IllegalArgumentException {
        if (s.length() > 5) throw new IllegalArgumentException();
        if ( Integer.parseInt(s.substring(0, 2)) < 0 || Integer.parseInt(s.substring(0, 2)) > 23 ) throw new IllegalArgumentException();
        if ( Integer.parseInt(s.substring(3, 5)) < 0 || Integer.parseInt(s.substring(3, 5)) > 59 ) throw new IllegalArgumentException();
        if (s.charAt(2) != ':') throw new IllegalArgumentException();
        hour = Integer.parseInt(s.substring(0,2));
        minutes = Integer.parseInt(s.substring(3, 5));

    }

    
    // Returns a string representation of this clock, using the format HH:MM.
    public String toString(){
        String hour2;
        String minute2;
        if (hour < 10) {hour2 = "0" + hour;}
        if (minute < 10) {minute2 = "0" + hour;}

        String a = "";
        return a;
    }
    /*
    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {

    }

    // Adds 1 minute to the time on this clock.
    public void tic() {

    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta) {

    }
    */
    // Test client (see below).
    public static void main(String[] args) {
        String sus = "01:03";
        Clock a = new Clock(1, 3);
        Clock b = new Clock(sus);
        System.out.println(a.toString());
        System.out.println(b.toString());

    }
}