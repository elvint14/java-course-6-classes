package az.et.web.spring.lesson13;

public class AnnotationApp {

    public static void main(String[] args) {
        new Human().go();
        new Teacher().go();
    }

    static class Human {
        private int age;

        public void go() throws RuntimeException {
            System.out.println("Human going...");
        }
    }

    static class Teacher extends Human {

        @Override
        public void go() throws ArrayIndexOutOfBoundsException {
            System.out.println("Teacher going...");
        }
    }
}
