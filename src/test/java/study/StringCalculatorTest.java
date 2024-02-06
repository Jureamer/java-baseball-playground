package study;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
public class StringCalculatorTest {
    static final String[] MARK = {"+", "-", "*", "/"};
    static int calculate(int n1, int n2, String mark) {
        System.out.println("n1 = " + n1 + " n2 = " + n2 + " mark = " + mark);
        if (mark.equals("+")) return n1 + n2;
        else if (mark.equals("-")) return n1 - n2;
        else if (mark.equals("*")) return n1 * n2;
        else return n1 / n2;
    }

    Integer implementCalculator(String cal) {
        String[] splited = cal.split(" ");
        int n1 = 0;
        int n2 = 0;
        String mark = "";

        for (int i = 0; i < splited.length; i++) {
            System.out.println("splited[i] = " + splited[i]);
            if (splited[i].equals("+")  || splited[i].equals("-") || splited[i].equals("*") || splited[i].equals("/")) {
                mark = splited[i];
            } else if (n1 == 0) {
                n1 = Integer.parseInt(splited[i]);
            } else {
                n2 = Integer.parseInt(splited[i]);

                // 계산 후 초기화
                n1 = calculate(n1, n2, mark);
                n2 = 0;
                mark = "";
            }
        }
        return n1;
    }


    @Test
    void add() {
        String cal = "1 + 3";
        assertThat(implementCalculator(cal)).isEqualTo(4);
    }

    @Test
    void minus() {
        String cal = "1 - 3";
        assertThat(implementCalculator(cal)).isEqualTo(-2);
    }

    @Test
    void multiply() {
        String cal = "1 * 3";
        assertThat(implementCalculator(cal)).isEqualTo(3);
    }

    @Test
    void divide() {
        String cal = "6 / 2";
        assertThat(implementCalculator(cal)).isEqualTo(3);
    }
}
