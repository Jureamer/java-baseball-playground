package baseball;

public class Ball {
    private int position;
    private int number;

    public Ball(int position, int number) {
        this.position = position;
        this.number = number;
    }

    public boolean isStrike(Ball ball) {
        return isSamePosition(ball) && isSameNumber(ball);

    }
    public boolean isBall(Ball ball) {
        return isSameNumber(ball);
    }

    public boolean isSamePosition(Ball ball) {
        return this.position == ball.position;
    }

    public boolean isSameNumber(Ball ball) {
        return this.number == ball.number;
    }




}
