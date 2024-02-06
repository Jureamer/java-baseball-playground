package study;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String[] splited = "1,2".split(",");
        assertThat(splited).contains("1");
        assertThat(splited).contains("2");

        String[] otherSplited = "1".split(",");
        assertThat(otherSplited).containsExactly("1");
    }

    @Test
    void substring() {
        String actual = "(1,2)";
        String substring = actual.substring(1, actual.length() - 1);
        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    void charAt() {
        String actual = "abc";
        assertThat(actual.charAt(0)).isEqualTo('a');
        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> {
            actual.charAt(3);
        }).withMessage("String index out of range: 3");

    }
}
