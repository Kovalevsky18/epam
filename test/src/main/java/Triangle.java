import java.util.stream.Stream;

public class Triangle {
    protected static final String MESSAGE_ERROR = "ide can't be lass than 0";

    public boolean triangle(double a, double b, double c) {
        boolean flag = Stream
                .of(a, b, c)
                .anyMatch(side -> side <= 0);
        if (flag) {
            throw new IllegalArgumentException(MESSAGE_ERROR);
        }
        return a + b > c && a + c > b && c + b > a;
    }
}

