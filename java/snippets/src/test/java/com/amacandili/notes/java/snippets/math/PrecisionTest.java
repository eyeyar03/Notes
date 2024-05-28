package com.amacandili.notes.java.snippets.math;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.commons.math3.util.Precision;
import org.junit.jupiter.api.Test;

class PrecisionTest {

  @Test
  void testEquality() {
    double d1 = 0.1 * 8;
    double d2 = 0;
    for (int i = 1; i <= 8; i++) {
      d2 += 0.1;
    }

    System.out.printf("d1 = %s | d2 = %s | gap: %s", d1, d2, Math.abs(d1 - d2));

    assertFalse(d1 == d2);
  }

  @Test
  void testEqualityWithPrecision() {
    double d1 = 0.1 * 8;
    double d2 = 0;
    for (int i = 1; i <= 8; i++) {
      d2 += 0.1;
    }

    System.out.printf("d1 = %s | d2 = %s | gap: %s", d1, d2, Math.abs(d1 - d2));

    assertTrue(Precision.equals(d1, d2));
  }

  @Test
  void compareDoublesWithPrecisionAndEpsilon() {
    double epsilon1 = 0.0010d;
    double epsilon2 = 0.0012d;
    var double1 = 500.500;
    var double2 = 500.5011;

    double gap = Math.abs(double1 - double2);

    System.out.printf("double1: %s | double2: %s | Gap: %s", double1, double2, gap);

    assertFalse(Precision.equals(double1, double2, epsilon1));
    assertTrue(Precision.equals(double1, double2, epsilon2));
  }
}
