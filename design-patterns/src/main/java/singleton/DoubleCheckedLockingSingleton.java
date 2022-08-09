package singleton;

public class DoubleCheckedLockingSingleton {

    /*
     * The volatile keyword ensures that multiple threads handle the instance variable correctly when it is being
     * initialized to the DoubleCheckedLockingSingleton instance.
     */
    private volatile static DoubleCheckedLockingSingleton instance;

    private static long delay = 0L;

    private DoubleCheckedLockingSingleton(){}

    public static DoubleCheckedLockingSingleton getInstance() throws InterruptedException {
        Thread.sleep(delay); // delay

        if(instance ==  null) {
            System.out.println("Null checked #1...");
            synchronized (DoubleCheckedLockingSingleton.class) {
                if(instance == null) {
                    System.out.println("Null checked #2 (inside synchronized block)...");
                    instance = new DoubleCheckedLockingSingleton();
                }
            }
        }

        return instance;
    }

    public static void setDelay(long instantiationDelay) {
        delay = instantiationDelay;
    }
}
