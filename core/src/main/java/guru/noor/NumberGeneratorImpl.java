package guru.noor;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

//@Component // not needed with Java Annotation Configurations (AppConfig)
public class NumberGeneratorImpl implements NumberGenerator {
    private final Random random = new Random();

    @Autowired
    private int maxNumber;

    @Override
    public int next() {
        return random.nextInt(maxNumber);
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }
}
