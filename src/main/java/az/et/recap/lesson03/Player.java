package az.et.recap.lesson03;

import java.util.Objects;

public class Player implements Comparable<Player> {

    private int id;
    private int score;
    private String name;

    public Player(int score, String name) {
        this.score = score;
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player that = (Player) o;
        return this.score == that.score && Objects.equals(this.name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(score, name);
    }

    @Override
    public String toString() {
        return String.format("{score=%d, name='%s'}", score, name);
    }

    @Override
    public int compareTo(Player that) {
        return Integer.compare(this.id, that.id);
    }

}
