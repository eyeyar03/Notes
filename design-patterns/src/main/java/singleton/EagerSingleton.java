package singleton;

import java.sql.SQLOutput;

public class EagerSingleton {

    private static EagerSingleton instance = new EagerSingleton();

    private static long delay = 0L;

    private EagerSingleton() {}

    public static EagerSingleton getInstance() throws InterruptedException {
        Thread.sleep(delay); // delay
        System.out.println("After some delay, just return the instance..");

        return instance;
    }

    public static void setDelay(long instantiationDelay) {
        delay = instantiationDelay;
    }
}
