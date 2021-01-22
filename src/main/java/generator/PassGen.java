package generator;

import java.util.Random;

public class PassGen {
    private static String[] s = {"A", "B", "C", "D", "E", "F", "G", "H", "K", "J", "L", "M", "N", "B", "V",
            "C", "X", "Z", "Q", "W", "E", "R", "T", "Y", "U", "P",
            "2", "3", "4", "5", "6", "7", "8", "9", "0", "q", "w", "e", "r", "t",
            "y", "u", "p", "a", "S", "d", "S", "d", "f", "g", "h", "j", "k", "z", "x", "c", "v", "b", "n", "m" };
    private static Random random = new Random(System.nanoTime());

    public static String passGen(){
        String pass = new String();
        for (int i = 0; i < 8; i++) {
            int b = random.nextInt(s.length);
            pass += s[b];
        }
        return pass;
    }


}
