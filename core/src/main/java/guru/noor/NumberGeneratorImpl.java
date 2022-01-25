package guru.noor;

import java.util.Random;

//@Component // not needed with Java Annotation Configurations (AppConfig)
public class NumberGeneratorImpl implements NumberGenerator {
    private final Random random = new Random();
    private static final int MAX_NUMBER = 100;

    @Override
    public int next() {
        return random.nextInt(MAX_NUMBER);
    }

    @Override
    public int getMaxNumber() {
        return MAX_NUMBER;
    }
}
