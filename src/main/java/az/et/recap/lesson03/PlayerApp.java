package az.et.recap.lesson03;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class PlayerApp {

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(Arrays.asList(4, -1, -2, 3, 4, 5));
        // Collections.sort(nums);
        System.out.println(nums);
        // primitive: 0, false, 'u\0000'
        // reference: null
        // ededler uchun:   ascending order
        // string:          a-z: alphabetical order

        // Collections.sort(nums, new IntegerComparator());
        Collections.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return 0;
            }
        });
        //                        (x, y) -> f(x,y)
        // Collections.sort(nums, (x, y) -> x > y ? -1 : (x == y ? 0 : 1));
        // Collections.sort(nums, (x, y) -> y.compareTo(x));
        // Collections.sort(nums, Comparator.reverseOrder());
        System.out.println(nums);

        List<Player> players = Arrays.asList(
                new Player(98, "Elvin"),
                new Player(98, "Ali"),
                new Player(77, "Heybet"),
                new Player(77, "Heshim")
        );
        System.out.println(players);
        Collections.sort(players, new PlayerComparator());
        // new Supplier<>()
        // new Consumer<>()
        // new Predicate<>()
        Collections.sort(players, new Comparator<Player>() {
            @Override
            public int compare(Player p1, Player p2) {
                if (p1.getScore() != p2.getScore()) return Integer.compare(p2.getScore(), p1.getScore());
                return p1.getName().compareTo(p2.getName());
            }
        });
        Collections.sort(players, (p1, p2) -> {
            if (p1.getScore() != p2.getScore()) return Integer.compare(p2.getScore(), p1.getScore());
            return p1.getName().compareTo(p2.getName());
        });
        System.out.println(players);

    }

}
