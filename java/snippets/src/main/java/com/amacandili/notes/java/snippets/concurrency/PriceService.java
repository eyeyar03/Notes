package com.amacandili.notes.java.snippets.concurrency;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PriceService {

  private final ExecutorService executorService =
      Executors.newFixedThreadPool(
          10,
          r -> {
            Thread thread = Executors.defaultThreadFactory().newThread(r);
            thread.setDaemon(true);
            return thread;
          });

  private static final List<LineItem> LINE_ITEMS =
      List.of(
          new LineItem("Apple", 2, 3),
          new LineItem("TV", 2000, 1),
          new LineItem("Soap", 5, 7),
          new LineItem("Soda", 3, 12),
          new LineItem("Egg", 55, 12),
          new LineItem("Charger", 150, 2),
          new LineItem("Umbrella", 25, 5),
          new LineItem("Pillow", 12, 6),
          new LineItem("Glass", 6, 6));

  public int getTotal() {
    return LINE_ITEMS.stream()
        .mapToInt(l -> thirdPartySumCalculatorService(l.quantity(), l.price()))
        .sum();
  }

  public int getTotalAsync() {
    List<CompletableFuture<Integer>> asyncFutures =
        LINE_ITEMS.stream().map(this::createCompletableFuture).toList();

    return asyncFutures.stream().map(CompletableFuture::join).mapToInt(Integer::intValue).sum();
  }

  private CompletableFuture<Integer> createCompletableFuture(LineItem lineItem) {
    return CompletableFuture.supplyAsync(
        () -> thirdPartySumCalculatorService(lineItem.quantity(), lineItem.price()),
        executorService);
  }

  private int thirdPartySumCalculatorService(int quantity, int price) {
    sleep();

    return quantity * price;
  }

  private void sleep() {
    try {
      // Simulate call 3rd party service
      Thread.sleep(1000L);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
