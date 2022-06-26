package com.movsisyan.model;

import java.util.*;

public class StringManipulation {

    /**
     * 2. isDigit/isLetter/hasDigit/hasLetter
     */
    public static boolean isDigit(String s) {
        return s.matches("[0-9]");
    }

    public static boolean isLetter(String s) {
        return s.matches("[a-zA-Z]");
    }

    public static boolean hasDigit(String s) {
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasLetter(String s) {
        String[] split = s.split("[- /]");
        for (String value : split) {
            if (isLetter(value) && !value.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    /**
     * 3. hasUpperCase
     */
    public static boolean hasUpperCase(String s) {
        return s.equals(s.toUpperCase());
    }

    public static boolean hasLowerCase(String s) {
        return s.equals(s.toLowerCase());
    }

    /**
     * 8. erase
     */
    public static String erase(String s, int i, int k) {
        if (i < 0 || k < 0 || i >= s.length()) {
            return s;
        }
        return s.substring(0, i) + s.substring(i + k);
    }

    public static String eraseSB(String s, int i, int k) {
        StringBuilder sb = new StringBuilder(s);
        StringBuilder newSb = new StringBuilder();
        if (i < 0 || k < 0 || i >= s.length()) {
            return s;
        }
        if (i + k >= s.length()) {
            k = s.length() - 1;
        }
        newSb.append(sb.substring(i, k + 1));
        return newSb.toString();
    }

    /**
     * 9. insert
     */
    public static String insert(String s, int i, String f) {
        StringBuilder sb = new StringBuilder(s);
        if (i < 0 || i > s.length()) {
            return s;
        }
        sb.insert(i, f);
        return sb.toString();
    }

    public static String insertC(String s, int i, String f) {
        if (i < 0 || i > s.length()) {
            return s;
        }
        return s.substring(0, i) + f + s.substring(i);
    }

    /**
     * 10.1 randomString
     */
    public static String randomString(boolean f, boolean k, int n) {
        StringBuilder sb = new StringBuilder(n);
        if (f) {
            for (int i = 0; i < sb.capacity(); i++) {
                char c = (char) ('a' + Math.random() * ('z' - 'a' + 1));
                sb.append(c);
            }
        } else if (k) {
            for (int j = 0; j < sb.capacity(); j++) {
                int i = (int) (Math.random() * 10);
                sb.append(i);
            }
        }
        return sb.toString();
    }

    /**
     * 11. getStringDigit
     */
    public static String getStringDigit(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                stringBuilder.append(s.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 12. parseInt
     */
    public static int parseInt(String s) {
        return Integer.parseInt(getStringDigit(s));
    }

    /**
     * 13. parseIntegers
     */
    public static Integer[] parseIntegers(String s) {
        String[] split = s.split("[^0-9]");
        List<Integer> nums = new ArrayList<>();
        for (String value : split) {
            if (!value.isEmpty()) {
                nums.add(parseInt(value));
            }
        }
        return nums.toArray(new Integer[0]);
    }

    /**
     * 14. isPalindrome
     */
    public static boolean isPolindrom(String s) {
        StringBuilder sb = new StringBuilder(s);
        return s.equals(sb.reverse().toString());
    }

    /**
     * get chars
     */
    public static Character[] getChars(String s) {
        ArrayList<Character> chars = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (c == '+' || c == '-') {
                chars.add(c);
            }
        }
        return chars.toArray(new Character[0]);
    }

    /**
     * 15. evaluate
     */
    public static int evaluate(String s) {
        if (!s.startsWith("-") && !s.startsWith("+"))
            s = "+" + s;
        Integer[] integers = parseIntegers(s);
        Character[] chars = getChars(s);
        int sum = 0;
        for (int i = 0; i < integers.length; i++) {
            if (chars[i] == '+') {
                sum += integers[i];
            } else if (chars[i] == '-') {
                sum -= integers[i];
            }
        }
        return sum;
    }

    /**
     * 18. caesarСipher
     */
    public static char caesarCipher(char c) {
        if (Character.isLetter(c)) {
            c += 3;
            if (!Character.isLetter(c))
                c -= 26;
        }
        return c;
    }

    public static String caesarCipher(String s) {
        String f = "";
        for (int i = 0; i < s.length(); i++) {
            f += caesarCipher(s.charAt(i));
        }
        return f;
    }

    /**
     * 19. countWords
     */
    public static int count(String s) {
        int count = 0;
        String[] split = s.split("[ /.,]");
        for (String s1 : split) {
            if (!s1.isEmpty()) {
                count++;
            }
        }
        return count;
    }

    /**
     * 20. getLongestWord
     */
    public static String getLongestWord(String s) {
        String[] split = s.split("[ /.,]");
        String f = split[0];
        for (int i = 1; i < split.length; i++) {
            if (f.length() < split[i].length()) {
                f = split[i];
            }
        }
        return f;
    }

    /**
     * 21. capitalization
     */
    public static String capitalizationWord(String s) {
        char c = Character.toUpperCase(s.charAt(0));
        return c + s.substring(1);
    }

    public static String capitalization(String s) {
        String[] split = s.split("[ /,.]");
        StringBuilder sb = new StringBuilder();
        for (String value : split) {
            if (!value.isEmpty()) {
                sb.append(capitalizationWord(value)).append(" ");
            }
        }
        return sb.toString();
    }

    /**
     * 23. getSubstringIndexes
     */
    public static Set<Integer> getSubstringIndexes(String s, String sub) {
        Set<Integer> index = new LinkedHashSet<>();
        int i = 0;
        while (s.indexOf(sub, i) != -1) {
            index.add(s.indexOf(sub, i));
            i += sub.length() + 1;
        }
        return index;
    }

    /**
     * 25. pickUpPinCode
     */
    // TODO 4 цикла
    public static String pickUpPinCode(String s) {
        for (char i = '0'; i <= '9'; i++) {
            for (char j = '0'; j <= '9'; j++) {
                for (char k = '0'; k <= '9'; k++) {
                    for (char l = '0'; l <= '9'; l++) {
                        String s1 = i + "" + j + k + l;
                        if (s.contains(s1)) {
                            return s1;
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * PickUpPassword
     */
    public static String pickUpPassword(String s) {
        for (char c = '0'; c <= 'z'; c++) {
            for (char d = '0'; d <= 'z'; d++) {
                for (char f = '0'; f <= 'z'; f++) {
                    for (char g = '0'; g <= 'z'; g++) {
                        String s1 = c + "" + d + f + g;
                        if (s.contains(s1)) {
                            return s1;
                        }
                    }
                }
            }
        }
        return null;
    }
}
