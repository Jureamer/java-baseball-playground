package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class BaseballTest {
    private Validation validation;
    private Generator generator;

    @BeforeEach
    void setUp() {
        validation = new Validation();
        generator = new Generator(validation);
    }

    @Test
    void between_1_and_9_test() {
        int num1 = 9;
        int num2 = 0;

        assertThat(validation.isValidateNumber(num1)).isTrue();
        assertThat(validation.isValidateNumber(num2)).isFalse();
    }

    @Test
    void duplication_test() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        int num1 = 1;
        int num2 = 4;

        assertThat(validation.isDuplicate(list, num1)).isTrue();
        assertThat(validation.isDuplicate(list, num2)).isFalse();
    }

    @Test
    void strike_test() {
        Ball computerBall = new Ball(1, 3);
        Ball userBall = new Ball(1, 3);

        BallStatus result = validation.compare(computerBall, userBall);
        assertThat(result).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ball_test() {
        Ball computerBall = new Ball(1, 3);
        Ball userBall = new Ball(2, 3);

        BallStatus result = validation.compare(computerBall, userBall);
        assertThat(result).isEqualTo(BallStatus.BALL);
    }

    @Test
    void out_test() {
        Ball computerBall = new Ball(1, 3);
        Ball userBall = new Ball(2, 4);

        BallStatus result = validation.compare(computerBall, userBall);
        assertThat(result).isEqualTo(BallStatus.OUT);
    }

    @Test
    void three_digit_numbers_test() {
        List<Ball> generatedBall = generator.generateThreeRandomBalls();
        System.out.println(generatedBall);
        assertThat(generatedBall.size()).isEqualTo(3);
    }

    @Test
    void convert_number_to_ball_test() {
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        List<Ball> generatedBalls = generator.convertNumbersToBall(numbers);
        assertThat(generatedBalls.size()).isEqualTo(3);

        for (Ball ball : generatedBalls) {
            assertThat(ball).isInstanceOf(Ball.class);
        }
    }
}
