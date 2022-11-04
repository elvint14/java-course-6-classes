package az.et.recap.lesson03;

import java.util.Comparator;

public class IntegerComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer x, Integer y) {
        return x > y ? -1 : (x == y ? 0 : 1);
    }

}
