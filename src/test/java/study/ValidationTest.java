package study;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ValidationTest {
    static boolean is_validate_number(int number) {
        return number > 0 && number < 10;
    }
    @Test
    void is_number_validate_test() {
        int num1 = 9;
        int num2 = 0;

        assertThat(is_validate_number(num1)).isTrue();
        assertThat(is_validate_number(num2)).isFalse();
    }

    static boolean is_duplicate_number(List<Integer> list, int number) {
        return list.contains(number);

    }
    @Test
    void is_not_duplication_number_test() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int num1 = 2;

        if (!is_duplicate_number(list, num1)) {
            list.add(num1);
        }
        assertThat(list.size()).isEqualTo(2);
    }

    @Test
    void is_three_digit_validate_test() {
        List<Integer> list = new ArrayList<Integer>();
        while (list.size() < 3) {
            int randomNumber = (int)(Math.random() * 10) + 1;

            if (is_validate_number(randomNumber)) {
                list.add(randomNumber);
            }
        }

        assertThat(list.size()).isEqualTo(3);
    }

}
