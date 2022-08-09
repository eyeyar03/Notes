package singleton;

public class ClassicSingleton {

    private static ClassicSingleton instance;

    private static long delay = 0L;


    private ClassicSingleton() {}

    public static ClassicSingleton getInstance() throws InterruptedException {

        Thread.sleep(delay); // delay

        if(instance == null) {
            System.out.println("Instantiating ClassicSingleton...");
            instance =  new ClassicSingleton(); // LAZY instantiation
        }

        return instance;
    }

    public static void setDelay(long instantiationDelay) {
        delay = instantiationDelay;
    }
}
