package singleton;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {

    @Test
    public void testClassicSingleton() throws InterruptedException {
        ClassicSingleton instanceOne = ClassicSingleton.getInstance();
        ClassicSingleton instanceTwo = ClassicSingleton.getInstance();

        assertThat(instanceOne).isEqualTo(instanceTwo);
    }

    @Test
    public void problemWithClassicSingleton() throws InterruptedException {
        ClassicSingletonThread threadOne = new ClassicSingletonThread(1000L);
        ClassicSingletonThread threadTwo = new ClassicSingletonThread(1000L);

        threadOne.start();
        threadTwo.start();

        Thread.sleep(2000L);
        ClassicSingleton instanceOne = threadOne.getClassicSingleton();
        ClassicSingleton instanceTwo = threadTwo.getClassicSingleton();

        /*
         * Note that because to multithreading this assertion will fail sometimes due to 2 instances of ClassicSingleton that were instantiated.
         * Example: singleton.ClassicSingleton@430fa81d and singleton.ClassicSingleton@74f3403d
         */
        assertThat(instanceOne).isEqualTo(instanceTwo);

        ClassicSingleton.setDelay(0L);
    }

    /*
     * Note that this test is almost similar to problemWithClassicSingleton() test. In this test, we're using
     * a synchronized getInstance() method version of ClassicSingleton. This approach is guaranteed to create only a
     * single instance but this synchronization is expensive and an unneeded overhead. This will not be needed on the
     * succeeding calls to getInstance() anymore once we acquired an instance.
     */
    @Test
    public void resolvingMultiThreadingRelatedIssueWithSynchronizedClassicSingleton() throws InterruptedException {
        SynchronizedClassicSingletonThread threadOne = new SynchronizedClassicSingletonThread(1000L);
        SynchronizedClassicSingletonThread threadTwo = new SynchronizedClassicSingletonThread(1000L);

        threadOne.start();
        threadTwo.start();

        Thread.sleep(4000L);

        SynchronizedClassicSingleton instanceOne = threadOne.getSynchronizedClassicSingleton();
        SynchronizedClassicSingleton instanceTwo = threadTwo.getSynchronizedClassicSingleton();

        assertThat(instanceOne).isEqualTo(instanceTwo);

        SynchronizedClassicSingleton.setDelay(0L);
    }

    /*
     * Note that this test is also almost similar to problemWithClassicSingleton() test. In this test, we're using
     * a singleton class that eagerly creates instance. By relying to the JVM on creating the instance, it is guaranteed
     * that a single instance is already created before any thread calls the getInstance() method.
     */
    @Test
    public void testEagerSingleton() throws InterruptedException {
        EagerSingletonThread threadOne = new EagerSingletonThread(1000L);
        EagerSingletonThread threadTwo = new EagerSingletonThread(1000L);

        threadOne.start();
        threadTwo.start();

        Thread.sleep(4000L);

        EagerSingleton instanceOne = threadOne.getEagerSingleton();
        EagerSingleton instanceTwo = threadTwo.getEagerSingleton();

        assertThat(instanceOne).isEqualTo(instanceTwo);

        EagerSingleton.setDelay(0L);
    }

    /*
     * Note that this test is also almost similar to problemWithClassicSingleton() test. In this test, we're using
     * double-checked locking Singleton. This is a better solution of SynchronizedClassicSingleton's approach.
     */
    @Test
    public void testDoubleCheckedLockingSingleton() throws InterruptedException {
        DoubleCheckedLockingSingletonThread threadOne = new DoubleCheckedLockingSingletonThread(1000L);
        DoubleCheckedLockingSingletonThread threadTwo = new DoubleCheckedLockingSingletonThread(1000L);

        threadOne.start();
        threadTwo.start();

        Thread.sleep(4000L);

        DoubleCheckedLockingSingleton instanceOne = threadOne.getDoubleCheckedLockingSingleton();
        DoubleCheckedLockingSingleton instanceTwo = threadTwo.getDoubleCheckedLockingSingleton();

        assertThat(instanceOne).isEqualTo(instanceTwo);

        DoubleCheckedLockingSingleton.setDelay(0L);
    }

    private class ClassicSingletonThread extends Thread {

        private ClassicSingleton classicSingleton;

        private long delay = 0;

        private ClassicSingletonThread(long delay) {
            this.delay = delay;
        }

        @Override
        public void run() {
            System.out.println("Running " + this.getName() + "[" + this.getId() + "]");

            try {
                ClassicSingleton.setDelay(delay);
                classicSingleton = ClassicSingleton.getInstance();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        public ClassicSingleton getClassicSingleton() {
            return classicSingleton;
        }
    }

    private class SynchronizedClassicSingletonThread extends Thread {

        private SynchronizedClassicSingleton synchronizedClassicSingleton;

        private long delay = 0;

        private SynchronizedClassicSingletonThread(long delay) {
            this.delay = delay;
        }

        @Override
        public void run() {
            System.out.println("Running " + this.getName() + "[" + this.getId() + "]");

            try {
                SynchronizedClassicSingleton.setDelay(delay);
                synchronizedClassicSingleton = SynchronizedClassicSingleton.getInstance();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public SynchronizedClassicSingleton getSynchronizedClassicSingleton() {
            return synchronizedClassicSingleton;
        }
    }

    private class EagerSingletonThread extends Thread {

        private EagerSingleton eagerSingleton;

        private long delay = 0;

        private EagerSingletonThread(long delay) {
            this.delay = delay;
        }

        @Override
        public void run() {
            System.out.println("Running " + this.getName() + "[" + this.getId() + "]");

            try {
                EagerSingleton.setDelay(delay);
                eagerSingleton = EagerSingleton.getInstance();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public EagerSingleton getEagerSingleton() {
            return eagerSingleton;
        }
    }

    private class DoubleCheckedLockingSingletonThread extends Thread {

        private DoubleCheckedLockingSingleton doubleCheckedLockingSingleton;

        private long delay = 0;

        private DoubleCheckedLockingSingletonThread(long delay) {
            this.delay = delay;
        }

        @Override
        public void run() {
            System.out.println("Running " + this.getName() + "[" + this.getId() + "]");

            try {
                EagerSingleton.setDelay(delay);
                doubleCheckedLockingSingleton = DoubleCheckedLockingSingleton.getInstance();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public DoubleCheckedLockingSingleton getDoubleCheckedLockingSingleton() {
            return doubleCheckedLockingSingleton;
        }
    }
}
