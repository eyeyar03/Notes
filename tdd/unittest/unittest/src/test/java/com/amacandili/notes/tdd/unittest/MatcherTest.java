package com.amacandili.notes.tdd.unittest;

import static com.amacandili.notes.tdd.unittest.MatcherTest.HttpStatusMatcher.hasOkStatus;
import static com.amacandili.notes.tdd.unittest.MatcherTest.HttpStatusMatcher.hasUnauthorizedStatus;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Map;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.jupiter.api.Test;

class MatcherTest {

  @Test
  void shouldHaveOkStatus() {
    HttpServletResponse response = new HttpServletResponse(200);

    assertThat(response, hasOkStatus());
  }

  @Test
  void shouldHaveUnauthorizedStatus() {
    HttpServletResponse response = new HttpServletResponse(401);

    assertThat(response, hasUnauthorizedStatus());
  }

  static class HttpStatusMatcher extends TypeSafeMatcher<HttpServletResponse> {

    private final HttpStatus expectedHttpStatus;

    private HttpStatusMatcher(HttpStatus expectedHttpStatus) {
      this.expectedHttpStatus = expectedHttpStatus;
    }

    static Matcher<HttpServletResponse> hasStatusOf(HttpStatus httpStatus) {
      return new HttpStatusMatcher(httpStatus);
    }

    static Matcher<HttpServletResponse> hasOkStatus() {
      return hasStatusOf(new HttpStatus(200));
    }

    static Matcher<HttpServletResponse> hasUnauthorizedStatus() {
      return hasStatusOf(new HttpStatus(401));
    }

    @Override
    protected boolean matchesSafely(HttpServletResponse httpServletResponse) {
      return httpServletResponse.statusCode() == expectedHttpStatus.value();
    }

    @Override
    public void describeTo(Description description) {
      description.appendText(
          String.format("an http response with %s status", expectedHttpStatus.description()));
    }

    @Override
    protected void describeMismatchSafely(
        HttpServletResponse item, Description mismatchDescription) {
      mismatchDescription.appendText(
          String.format(
              "an http response with %s status",
              HttpStatus.valueOf(item.statusCode()).description()));
    }
  }

  private record HttpServletResponse(int statusCode) {}

  private record HttpStatus(int value) {

    private static final Map<Integer, String> STATUS_MAP =
        Map.of(200, "OK", 401, "Unauthorized", 500, "Internal Server Error");

    static HttpStatus valueOf(int statusCode) {
      return new HttpStatus(statusCode);
    }

    String description() {
      return String.format("%s[%d]", STATUS_MAP.get(value), value);
    }
  }
}
