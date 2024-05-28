package com.amacandili.notes.java.snippets.validator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;

class CountryValidatorTest {

  private ConstraintValidator<ValidCountry, String> constraintValidator;

  private ConstraintValidatorContext constraintValidatorContext;

  private ConstraintValidatorContext.ConstraintViolationBuilder constraintViolationBuilder;

  @Captor private ArgumentCaptor<String> errorMessageCaptor = ArgumentCaptor.forClass(String.class);

  @BeforeEach
  void setup() {
    constraintValidatorContext = Mockito.mock(ConstraintValidatorContext.class);
    constraintViolationBuilder =
        Mockito.mock(ConstraintValidatorContext.ConstraintViolationBuilder.class);

    Mockito.when(
            constraintValidatorContext.buildConstraintViolationWithTemplate(Mockito.anyString()))
        .thenReturn(constraintViolationBuilder);

    constraintValidator = new CountryValidator();
  }

  @Test
  void shouldBeValid() {
    boolean isValid = constraintValidator.isValid("Philippines", constraintValidatorContext);

    assertTrue(isValid);

    Mockito.verify(constraintValidatorContext, Mockito.times(0))
        .buildConstraintViolationWithTemplate(Mockito.anyString());

    Mockito.verify(constraintViolationBuilder, Mockito.times(0)).addConstraintViolation();
  }

  @Test
  void shouldBeInvalid() {
    boolean isValid = constraintValidator.isValid("Metro Manila", constraintValidatorContext);

    assertFalse(isValid);

    Mockito.verify(constraintValidatorContext, Mockito.times(1))
        .buildConstraintViolationWithTemplate(errorMessageCaptor.capture());

    assertThat(errorMessageCaptor.getValue(), is(equalTo("Metro Manila is an invalid country.")));

    Mockito.verify(constraintViolationBuilder, Mockito.times(1)).addConstraintViolation();
  }
}
