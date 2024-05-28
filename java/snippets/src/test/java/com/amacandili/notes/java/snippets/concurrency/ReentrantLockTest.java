package com.amacandili.notes.java.snippets.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import org.junit.jupiter.api.Test;

class ReentrantLockTest {

  private static final int NUMBER_OF_THREADS = 2;

  @Test
  void testReentrantLock() throws Exception {
    ReentrantLock lock = new ReentrantLock(true);
    ExecutorService pool = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    Runnable worker1 = new Worker(lock, "Job1");
    Runnable worker2 = new Worker(lock, "Job2");
    Runnable worker3 = new Worker(lock, "Job3");
    Runnable worker4 = new Worker(lock, "Job4");

    pool.execute(worker1);
    pool.execute(worker2);
    pool.execute(worker3);
    pool.execute(worker4);
    pool.shutdown();
    pool.awaitTermination(100L, TimeUnit.SECONDS);
  }
}
