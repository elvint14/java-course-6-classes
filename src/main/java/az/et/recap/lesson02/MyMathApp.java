package az.et.recap.lesson02;

public class MyMathApp {

    public int multiply(int a, int b) {
        return a * b;
    }

    public boolean isEven(int a) {
        return a % 2 == 0;
    }

    public void isNotNull(Object o) {
        if (o == null) throw new NullPointerException();
    }

}
