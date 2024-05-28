package com.amacandili.notes.java.snippets.concurrency;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.locks.ReentrantLock;

public class Worker implements Runnable {

  private static final String TIME_FORMAT = "hh:mm:ss";

  private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(TIME_FORMAT);

  private final ReentrantLock lock;

  private final String name;

  public Worker(ReentrantLock lock, String name) {
    this.lock = lock;
    this.name = name;
  }

  @Override
  public void run() {

    boolean done = false;

    while (!done) {
      // Getting OUTER LOCK
      boolean lockIsFree = lock.tryLock();

      if (lockIsFree) {
        try {
          System.out.println(
              String.format(
                  "Worker %s has acquired OUTER LOCK at %s doing outer work",
                  name, LocalTime.now().format(FORMATTER)));

          sleep(1500L);

          // Getting INNER LOCK
          lock.lock();

          try {
            System.out.println(
                String.format(
                    "Worker %s has acquired INNER LOCK at %s doing inner work",
                    name, LocalTime.now().format(FORMATTER)));

            System.out.println("Lock hold count: " + lock.getHoldCount());

            sleep(1500L);
          } catch (Exception e) {
            e.printStackTrace();
          } finally {
            // INNER LOCK release
            System.out.println(String.format("Worker %s is releasing INNER LOCK...", name));

            lock.unlock();
          }

          System.out.println("Lock hold count: " + lock.getHoldCount());

          System.out.println(String.format("Worker %s is done.", name));

          done = true;

        } catch (Exception e) {
          e.printStackTrace();
        } finally {
          // OUTER LOCK release
          System.out.println(String.format("Worker %s is releasing OUTER LOCK...", name));

          lock.unlock();

          System.out.println("Lock hold count: " + lock.getHoldCount());
        }

      } else {
        System.out.println(String.format("Worker %s is waiting for lock...", name));

        sleep(1000L);
      }
    }
  }

  private void sleep(long milliseconds) {
    try {
      Thread.sleep(milliseconds);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
