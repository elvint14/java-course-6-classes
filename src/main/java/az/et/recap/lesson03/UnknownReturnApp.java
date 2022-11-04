package az.et.recap.lesson03;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class UnknownReturnApp {

    public static void main(String[] args) {
        // map -> manipulate;   f(x) -> f(y)
        String response = getValidNum()
                .map(num -> "YES: " + num)
                .orElse("NO");
        System.out.printf(response);
    }

    private static Optional<Integer> getValidNum() {
        try {
            int num = new Scanner(System.in).nextInt();
            if (num >= 0) return Optional.of(num);
        } catch (InputMismatchException e) {
            // e.printStackTrace();
        }
        return Optional.empty();
    }

}
