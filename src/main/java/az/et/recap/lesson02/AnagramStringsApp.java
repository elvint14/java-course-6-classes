package az.et.recap.lesson02;

import java.util.Map;
import java.util.stream.Collectors;

public class AnagramStringsApp {

    public static void main(String[] args) {
        System.out.println(isAnagram("abcda", "dbac"));
        System.out.println(isAnagram("abcd", "dbac"));
        // "abcda", "dbac"
    }

    public static boolean isAnagram(final String s1, final String s2) {
        Map<Integer, Long> s1map = s1.chars()
                .boxed()
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        // input -> intermediary operators -> terminal op.
        for (int i = 0; i < s2.length(); i++) {
            int c = s2.charAt(i);
            if (!s1map.containsKey(c)) return false;
            long count = s1map.get(c);
            s1map.put(c, --count);
        }

        return s1map.values()
                .stream()
                .noneMatch(count -> count != 0);
    }
    // O(n) + O(n) + O(n) = 3*O(n) -> O(n) <- time complexity

    /*
      public static void isAnagram(String s1, String s2) { -> O(nlogn)
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        if (s1.length() == s2.length()) {
            char[] ch1 = s1.toCharArray();
            char[] ch2 = s2.toCharArray();
            Arrays.sort(ch1); -> N*longN
            Arrays.sort(ch2); -> N*longN
            boolean result = Arrays.equals(ch1, ch2); -> O(n)
            if (result) {
                System.out.println(s1 + " ve " + s2 + " anagramdir");
            } else
                System.out.println(s1 + " ve " + s2 + " anagram deyil");
        }
    }
     */

}
