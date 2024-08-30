public class Huntingtons {
    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
        int i = 0;
        int counterMax = 0;
        int tempCounter = 0;
        while (i < dna.length()) {
            if (i+2 >= dna.length()) {break;}
            if (dna.charAt(i) == 'C' && dna.charAt(i+1) == 'A' && dna.charAt(i+2) == 'G' ) {
                tempCounter++;
                counterMax = Math.max(counterMax, tempCounter);
                i+= 3;
            } else { 
                tempCounter = 0;
                i++;
            }
        }
        return counterMax;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s) {
        s = s.replace("\n", "");
        s = s.replace("\t", "");
        s = s.replace(" ", "");
        return s;
    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
        if (maxRepeats < 10) { return "not human";}
        else if (maxRepeats < 36) { return "normal";}
        else if (maxRepeats < 40) {return "high risk";}
        else if (maxRepeats < 181) {return "Huntington's";}
        else {return "not human";}
    }

    // Sample client (see below).
    public static void main(String[] args) {
        String name = args[0];
        In in = new In(name);
        String s = in.readAll();
        String dna = removeWhitespace(s);
        int repeats = maxRepeats(dna);
        StdOut.println("max repeats = " + repeats);
        StdOut.println(diagnose(repeats));
    }
}
