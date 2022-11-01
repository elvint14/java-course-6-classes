package az.et.recap.lesson01;

public class Car {

    public static void main(String[] args) {
        Car car = new Bmw();
        Bmw bmw = new Bmw();
         bmw.doo();

        // sub      super
        // bmw is a car?
        // car is a bmw?

    }

    public void doo() {

    }


}

class Bmw extends Car {

    private int a() {
        return 1;
    }

    private int a(String s) {
        return 1;
    }

    @Override
    public void doo() {
        super.doo();
    }

}