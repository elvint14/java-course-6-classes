package az.et.web.spring.lesson13;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        System.out.print("Enter a num: ");
        int num = new Scanner(System.in).nextInt();

        double pow = Math.pow(num, 5);
        System.out.println(pow);

        ObjectMapper ob = new ObjectMapper();
    }
}
