package singleton;

public class SynchronizedClassicSingleton {

    private static SynchronizedClassicSingleton instance;

    private static long delay = 0;


    private SynchronizedClassicSingleton() {}


    public static synchronized SynchronizedClassicSingleton getInstance() throws InterruptedException {

        Thread.sleep(delay); // delay

        if(instance == null) {
            System.out.println("Instantiating SynchronizedClassicSingleton...");
            instance = new SynchronizedClassicSingleton();
        }

        return instance;
    }

    public static void setDelay(long instantiationDelay) {
        delay = instantiationDelay;
    }
}
