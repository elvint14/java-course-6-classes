package az.et.recap;

public class SearchApp {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9}; // average case

        int[] num1 = {7, 1, 2, 3, 4, 5, 6, 7, 8}; // best case
        int[] num3 = {1, 2, 3, 4, 5, 6, 8, 9, 0}; // worst case

        //notation -> best & worst cases

        // worst case -> Big-O notation =>
        // linear search -> O(n) -> time complexity

        // linear search
        for (int num : nums) {
            if (num == 7) {
                System.out.println("found!");
                break;
            }
        }

    }
}
