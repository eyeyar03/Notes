package com.amacandili.notes.tdd.unittest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

import java.util.function.Function;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;

class ArgumentMatcherTest {

  private PetTrainer petTrainer;

  private Function<Pet, String> petGreeterFunction;

  private Function<InterestingPet, String> interestingPetGreeterFunction;

  @Test
  void testWithoutMock() {
    petGreeterFunction = new PetGreeterFunction();

    petTrainer = new PetTrainer(petGreeterFunction, interestingPetGreeterFunction);

    assertThat(
        petTrainer.trainPetToGreet("Latte", 2),
        is(equalTo("Hello! I am Latte. And I am 2 years old.")));
  }

  @Test
  void testWithMockButWithoutArgumentMatcher() {
    petGreeterFunction = Mockito.mock(Function.class);

    Pet pet = new Pet("Kofi", 3);

    Mockito.when(petGreeterFunction.apply(pet))
        .thenReturn("Hello! I am Kofi. And I am 3 years old.");

    petTrainer = new PetTrainer(petGreeterFunction, interestingPetGreeterFunction);

    /* null because the object used in mock is not equal to the
    actual object created and passed to petGreeterFunction. */
    assertThat(petTrainer.trainPetToGreet("Kofi", 3), is(nullValue()));
  }

  @Test
  void testWithMockButWithoutArgumentMatcherAndUsingInterestingPet() {
    interestingPetGreeterFunction = Mockito.mock(Function.class);

    InterestingPet pet = new InterestingPet("Kofi", 3);

    Mockito.when(interestingPetGreeterFunction.apply(pet))
        .thenReturn("Hello! I am Kofi. And I am 3 years old.");

    petTrainer = new PetTrainer(petGreeterFunction, interestingPetGreeterFunction);

    // For context, compare this with testWithMockButWithoutArgumentMatcher() test.
    assertThat(
        petTrainer.trainInterestingPetToGreet("Kofi", 3),
        is(equalTo("Hello! I am Kofi. And I am 3 years old.")));
  }

  @Test
  void testWithMockAndArgumentMatcher() {
    petGreeterFunction = Mockito.mock(Function.class);

    Pet pet = new Pet("Kofi", 3);

    Mockito.when(petGreeterFunction.apply(Mockito.argThat(new PetArgumentMatcher(pet))))
        .thenReturn("Hello! I am Kofi. And I am 3 years old.");

    petTrainer = new PetTrainer(petGreeterFunction, interestingPetGreeterFunction);

    assertThat(
        petTrainer.trainPetToGreet("Kofi", 3),
        is(equalTo("Hello! I am Kofi. And I am 3 years old.")));
  }

  private static class Pet {

    private final String name;

    private final int age;

    public Pet(String name, int age) {
      this.name = name;
      this.age = age;
    }

    public String name() {
      return name;
    }

    public int age() {
      return age;
    }
  }

  /**
   * This is an "Interesting Pet" because it is a record. And because it is a record, 2 instantiated
   * pet created with the same field values are still equal. Because of this, use of ArgumentMatcher
   * isn't needed anymore. (Another good reason for using record.)
   */
  private record InterestingPet(String name, int age) {}

  private record PetTrainer(
      Function<Pet, String> petGreeterFunction,
      Function<InterestingPet, String> interestingPetGreeterFunction) {
    public String trainPetToGreet(String name, int age) {
      Pet pet = new Pet(name, age);

      return petGreeterFunction.apply(pet);
    }

    public String trainInterestingPetToGreet(String name, int age) {
      InterestingPet pet = new InterestingPet(name, age);

      return interestingPetGreeterFunction.apply(pet);
    }
  }

  private record PetGreeterFunction() implements Function<Pet, String> {

    @Override
    public String apply(Pet pet) {
      return String.format("Hello! I am %s. And I am %d years old.", pet.name(), pet.age());
    }
  }

  private record InterestingPetGreeterFunction() implements Function<InterestingPet, String> {

    @Override
    public String apply(InterestingPet pet) {
      return String.format(
          "Hello! I am %s. And I am %d years old. And I am interesting because I don't seem to need ArgumentMatcher anymore!",
          pet.name(), pet.age());
    }
  }

  private record PetArgumentMatcher(Pet mockedPetArgument) implements ArgumentMatcher<Pet> {

    @Override
    public boolean matches(Pet pet) {
      return mockedPetArgument.name().equals(pet.name()) && mockedPetArgument.age() == pet.age();
    }
  }
}
