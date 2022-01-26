package guru.noor;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component // not needed with Java Annotation Configurations (AppConfig)
@Getter
@AllArgsConstructor
public class NumberGeneratorImpl implements NumberGenerator {
    @Getter(AccessLevel.NONE)
    private final Random random = new Random();

    private final int maxNumber;
    private final int minNumber;

    @Override
    public int next() {
        return random.nextInt(minNumber, maxNumber + 1);
    }
}
