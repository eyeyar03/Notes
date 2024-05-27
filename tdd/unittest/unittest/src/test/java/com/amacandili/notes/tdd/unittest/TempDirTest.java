package com.amacandili.notes.tdd.unittest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Function;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

class TempDirTest {

  private static final String TEMPORARY_FILE = "temporary-file.txt";

  private Function<String, Boolean> deleteFileFunction = new DeleteFileFunction();

  @TempDir public Path tempDir;

  @Test
  void shouldSuccessfullyDeleteFile() throws Exception {
    Path temporaryPath = Files.createFile(tempDir.resolve(TEMPORARY_FILE));

    File temporaryFile = temporaryPath.toFile();

    String absolutePath = temporaryFile.getAbsolutePath();

    System.out.println("Absolute path: " + absolutePath);

    assertTrue(temporaryFile.exists());

    assertTrue(deleteFileFunction.apply(absolutePath));

    assertFalse(temporaryFile.exists());
  }

  @Test
  void shouldReturnFalseWhenExceptionIsEncountered() {
    try (MockedStatic<Files> files = Mockito.mockStatic(Files.class)) {
      files
              .when(() -> Files.deleteIfExists(Paths.get(TEMPORARY_FILE)))
              .thenThrow(IOException.class);
      assertFalse(deleteFileFunction.apply(TEMPORARY_FILE));

      files.verify(() -> Files.deleteIfExists(Paths.get(TEMPORARY_FILE)), Mockito.times(1));
    }
  }

  private static class DeleteFileFunction implements Function<String, Boolean> {

    @Override
    public Boolean apply(String absolutePath) {
      try {
        return Files.deleteIfExists(Paths.get(absolutePath));

      } catch (Exception e) {
        return false;
      }
    }
  }
}
