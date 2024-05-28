package com.amacandili.notes.java.snippets.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class CountryValidator implements ConstraintValidator<ValidCountry, String> {

  private static final Set<String> VALID_COUNTRIES =
      Set.of("Philippines", "USA", "Japan", "India", "Australia");

  @Override
  public boolean isValid(String country, ConstraintValidatorContext context) {
    Optional<String> optionalErrorMessage = validateCountry(country);

    boolean isValid = true;
    if (optionalErrorMessage.isPresent()) {
      isValid = false;
      context.disableDefaultConstraintViolation();
      context
          .buildConstraintViolationWithTemplate(optionalErrorMessage.get())
          .addConstraintViolation();
    }

    return isValid;
  }

  private Optional<String> validateCountry(String country) {
    return Objects.nonNull(country) && VALID_COUNTRIES.contains(country)
        ? Optional.empty()
        : Optional.of(String.format("%s is an invalid country.", country));
  }
}
