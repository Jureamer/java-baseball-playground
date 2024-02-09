package baseball;

import java.util.ArrayList;
import java.util.List;

public class Generator {
    private Validation validation;

    public Generator(Validation validation) {
        this.validation = validation;
    }
    List<Ball> generateThreeRandomBalls() {
        List<Ball> listOfBalls = new ArrayList<Ball>();
        List<Integer> listOfNumbers = new ArrayList<Integer>();
        int position = 1;

        while (listOfNumbers.size() < 3) {
            int randomNumber = (int) Math.round(Math.random() * 100 / 10) + 1;
            if (!validation.isDuplicate(listOfNumbers, randomNumber) && validation.isValidateNumber(randomNumber)) {
                Ball newBall = new Ball(position, randomNumber);
                listOfBalls.add(newBall);
                listOfNumbers.add(randomNumber);
                position++;
            }
        }
        return listOfBalls;
    }

    List<Ball> convertNumbersToBall(List<Integer> numbers) {
        int position = 1;
        List<Ball> newBall = new ArrayList<Ball>();

        for (int number : numbers) {
            newBall.add(new Ball(position, number));
            position++;
        }
        return newBall;
    }
}
