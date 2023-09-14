package utilities;

public class Utilities {
    public static boolean inRange(int start, int end, int val) {
        if (val < start || val >= end) {
            return false;
        }
        return true;
    }
}
