package az.et.recap.lesson02;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class LetterCountApp {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findSymbolCount("abca")));
        System.out.println(Arrays.toString(findSymbolCount("abcabaabc")));
        System.out.println(Arrays.toString(findSymbolCount("abcabaabcabcabaabcabcabaabcabcabaabcaaaaa")));
        System.out.println(Arrays.toString(findSymbolCount("")));
        System.out.println(findSymbolCountV2("abcabaabc"));
        System.out.println(findSymbolCountV2("ababa"));
    }

    private static int[] findSymbolCount(final String input) {
        if (input == null || input.trim().length() == 0)
            throw new IllegalStateException("Invalid input!");

        final int[] counts = new int[26];
        // a, b, c, ... , z
        // 0, 1, 2, ... , 25
        // 2, 1, 1, ... , 0
        // 97,98,99 ... , 122

        for (int i = 0; i < input.length(); i++) {
            int idxOfChar = input.charAt(i) - 97;
            counts[idxOfChar] = counts[idxOfChar] + 1;
        }

        return counts;
    }

    private static Map<Integer, Long> findSymbolCountV2(final String input) {
        return input.chars()
                .boxed()
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
    }

}
