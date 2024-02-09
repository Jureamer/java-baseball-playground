package baseball;

import java.util.List;

public class Validation {
    public boolean isValidateNumber(int num) {
        int MIN_NUMBER = 1;
        int MAX_NUMBER = 9;

        return num >= MIN_NUMBER && num <= MAX_NUMBER;
    }

    public boolean isDuplicate(List<Integer> list, int num1) {
        return list.contains(num1);
    }
    
    public BallStatus compare(Ball ball1, Ball ball2) {
        if(ball1.isStrike(ball2)) {
            return BallStatus.STRIKE;
        }

        if (ball1.isBall(ball2)) {
            return BallStatus.BALL;
        }
        return BallStatus.OUT;
        }
    }