package az.et.recap.lesson04;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SimpleApp {

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(findAllEvenNumsV1(null))
        );
        System.out.println(
                Arrays.toString(findAllEvenNumsV1(new int[]{1, 2, 3}))
        );
    }

    private static int[] findAllEvenNumsV1(final int[] nums) {
        // NEVER TRUST USER INPUT!!!
        int[] evens = new int[nums.length];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                evens[j++] = nums[i];
            }
        }
        return evens;
    }

    private static int[] findAllEvenNumsV2Template(final int[] nums) {
        // input (validation, etc.) - controller

        // process (business processes & logic) - service

        // output (result) - file, database, another service
        return null;
    }

    private static int[] findAllEvenNumsV2(final int[] nums) {
        // input (validation, etc.) - controller
        if (nums == null) return new int[]{};

        // process (business processes & logic) - service
        final int[] evens = Arrays.stream(nums)
                .filter(num -> num % 2 == 0)
                .toArray();

        // output (result) - file, database, another service
        return evens;
    }

}
