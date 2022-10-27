package az.et.recap;

public class EqualsHashcodeApp {
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person);
        System.out.println(person.hashCode());
        System.out.println("1".hashCode());
        Person person2 = new Person();
        System.out.println(person2);
        System.out.println(person2.hashCode());
    }

    static class Person {
        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }

        @Override
        public int hashCode() {
            return 1;
        }
    }
}
