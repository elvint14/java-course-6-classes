package az.et.web.spring.lesson14;

public class SingletonApp {

    private static final SingletonApp singletonApp = new SingletonApp();

    public static void main(String[] args) {
        singletonApp.doOp();
        singletonApp.doOp();
        singletonApp.doOp();
    }

    private void doOp() {
        System.out.println("doOp called.");
    }

}
