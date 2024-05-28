package com.amacandili.notes.tdd.unittest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;

class ArgumentCaptorTest {

  private static final List<LineItem> ORDERS =
      List.of(new LineItem("Eggs", 24.5), new LineItem("Rice", 150.075), new LineItem("Apple", 13.09));

  @Captor private ArgumentCaptor<String> errorMessageCaptor = ArgumentCaptor.forClass(String.class);

  @Test
  void testCaptor() {
    Consumer<String> mockedLogger = Mockito.mock(Consumer.class);

    ReceiptService receiptService = new ReceiptService(mockedLogger);
    receiptService.logReceipt(ORDERS);

    Mockito.verify(mockedLogger).accept(errorMessageCaptor.capture());

    assertThat(
        errorMessageCaptor.getValue(),
        is(equalTo("[Item: Eggs, Price: 24.50]&[Item: Rice, Price: 150.08]&[Item: Apple, Price: 13.09]")));
  }

  private class ReceiptService {

    private final Consumer<String> logger;

    ReceiptService(Consumer<String> logger) {
      this.logger = logger;
    }

    void logReceipt(List<LineItem> orders) {
      String receipt = orders.stream().map(this::generateLineItem).collect(Collectors.joining("&"));

      logger.accept(receipt);
    }

    private String generateLineItem(LineItem lineItem) {
      return String.format("[Item: %s, Price: %,.2f]", lineItem.product(), lineItem.amount());
    }
  }

  private class Logger implements Consumer<String> {
    @Override
    public void accept(String receipt) {
      System.out.println(receipt);
    }
  }

  private record LineItem(String product, double amount) {}
}
