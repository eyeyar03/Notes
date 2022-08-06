package decorator;

import org.junit.jupiter.api.Test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LowerCaseInputStreamTest {

    @Test
    public void testRead() throws IOException {
        int c;
        InputStream inputStream = new LowerCaseInputStream(new BufferedInputStream(getClass().getClassLoader().getResourceAsStream("decorator.txt")));

        StringBuilder stringBuilder = new StringBuilder();
        while ((c = inputStream.read()) >= 0) {
            stringBuilder.append((char) c);
        }

        inputStream.close();

        assertThat(stringBuilder.toString()).isEqualTo("i know the decorator pattern therefore i rule!");
    }
}
