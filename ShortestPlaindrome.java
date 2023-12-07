//ShortestPalindrome.java
public class ShortestPalindrome {

    public static String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + rev;
        int[] lps = computeLPSArray(combined);

        int len = lps[combined.length() - 1];
        String suffix = rev.substring(0, s.length() - len);

        return suffix + s;
    }

    private static int[] computeLPSArray(String str) {
        int n = str.length();
        int[] lps = new int[n];
        int len = 0;
        int i = 1;

        while (i < n) {
            if (str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    public static void main(String[] args) {
        String s = "abcd";
        String result = shortestPalindrome(s);
        System.out.println("Shortest Palindrome: " + result);
    }
}
