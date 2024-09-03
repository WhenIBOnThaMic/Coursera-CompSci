public class Clock {
    private int hour;
    private int minute;
    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) {
        if (h < 0 || h > 23 || m < 0 || m > 59) throw new IllegalArgumentException();
        hour = h;
        minute = m;
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s) {
        if (s.length() != 5) throw new IllegalArgumentException();
        if ( Integer.parseInt(s.substring(0, 2)) < 0 || Integer.parseInt(s.substring(0, 2)) > 23 ) throw new IllegalArgumentException();
        if ( Integer.parseInt(s.substring(3, 5)) < 0 || Integer.parseInt(s.substring(3, 5)) > 59 ) throw new IllegalArgumentException();
        if (s.charAt(2) != ':') throw new IllegalArgumentException();
        hour = Integer.parseInt(s.substring(0,2));
        minute = Integer.parseInt(s.substring(3, 5));

    }

    
    // Returns a string representation of this clock, using the format HH:MM.
    public String toString(){
        String a = "";
        if (hour < 10 && minute < 10) {
            a = "0" + hour + ":" + "0" + minute;
            return a;
        } else 
        if (hour < 10) {
            a = "0" + hour + ":" + minute;
            return a;
        } else
        if (minute < 10) {
            a = hour + ":" + "0" + minute;
            return a;
        } else {
            a = hour + ":" + minute;
            return a;
        }
    }
    
    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        if (hour == that.hour) {return (minute < that.minute);}
        else {return (hour < that.hour);}
    }
    
    // Adds 1 minute to the time on this clock.
    public void tic() {
        minute += 1;
        if (minute > 59) {
            minute -= 60;
            hour += 1;
        }
        if (hour > 23) {
            hour -= 24;
        }
    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta) {
        if (delta < 0) throw new IllegalArgumentException();

        minute += delta;
        while(minute > 59) {
            hour += Math.floor((double)minute/60);
            minute = minute%60;
            if (hour > 23) {hour = hour%24;}
        }

    }
    
    // Test client (see below).
    public static void main(String[] args) {
        Clock a = new Clock(3, 0);
        String sus = "02:03";
        Clock b = new Clock(sus);
        String a2 = a.toString();
        String b2 = b.toString();
        System.out.println(b2);
        System.out.println(a2);
        a.tic();
        System.out.print(a.toString() + "\n");

        a.toc(1450);
        System.out.print(a.toString() + "\n");

        boolean earlier = true;
        earlier = a.isEarlierThan(b);
        System.out.println(earlier);
    }
}