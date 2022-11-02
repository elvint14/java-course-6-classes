package az.et.recap.lesson02;

import java.util.IntSummaryStatistics;
import java.util.List;

public class StreamApp {

    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 1, 3);

        IntSummaryStatistics statistics = nums.stream()
                .mapToInt(integer -> integer)
                .summaryStatistics();

        System.out.println(statistics.getMax());
        System.out.println(statistics.getMin());
    }
}
