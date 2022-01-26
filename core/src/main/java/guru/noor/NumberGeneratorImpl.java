package guru.noor;

import guru.noor.qualifier.MaxNumber;
import guru.noor.qualifier.MinNumber;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component // not needed with Java Annotation Configurations (AppConfig)
public class NumberGeneratorImpl implements NumberGenerator {
    private final Random random = new Random();

    private final int maxNumber;
    private final int minNumber;

    public NumberGeneratorImpl(@MaxNumber int maxNumber, @MinNumber int minNumber) {
        this.maxNumber = maxNumber;
        this.minNumber = minNumber;
    }

    @Override
    public int next() {
        return random.nextInt(minNumber, maxNumber + 1);
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }

    @Override
    public int getMinNumber() {
        return minNumber;
    }
}
