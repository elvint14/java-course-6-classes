package az.et.recap.lesson03;

import java.util.Comparator;

public class PlayerComparator implements Comparator<Player> {

    @Override
    public int compare(Player p1, Player p2) {
        if (p1.getScore() != p2.getScore()) return Integer.compare(p2.getScore(), p1.getScore());
        return p1.getName().compareTo(p2.getName());
    }

}
