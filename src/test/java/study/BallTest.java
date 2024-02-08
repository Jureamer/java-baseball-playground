package study;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class BallTest {

    private BallStatus check(Balls computerBall, Balls userBall) {
        return BallStatus.NOTHING;
    }
    @Test
    void strike() {
        Balls computerBall = new Balls(2, 3);
        Balls userBall = new Balls(2, 3);
        assertThat(comparing(computerBall, userBall)).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ball() {
        Balls computerBall = new Balls(2, 3);
        Balls userBall = new Balls(3, 3);
        assertThat(comparing(computerBall, userBall)).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing() {
        Balls computerBall = new Balls(2, 3);
        Balls userBall = new Balls(1, 1);
        assertThat(comparing(computerBall, userBall)).isEqualTo(BallStatus.NOTHING);
    }

    private BallStatus comparing(Balls computerBall, Balls userBall) {
        if (computerBall.getPosition() == userBall.getPosition() &&
                computerBall.getNumber() == userBall.getNumber()) {
            return BallStatus.STRIKE;
        }

        if (computerBall.getNumber() == userBall.getNumber()) {
            return BallStatus.BALL;
        }

        return BallStatus.NOTHING;
    }
}
