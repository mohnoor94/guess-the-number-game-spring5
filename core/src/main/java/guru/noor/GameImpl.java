package guru.noor;

import guru.noor.qualifier.GuessCount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component // not needed with Java Annotation Configurations (AppConfig)
public class GameImpl implements Game {
    private static final Logger log = LoggerFactory.getLogger(GameImpl.class);

    private final NumberGenerator numberGenerator;
    private final int guessCount;

    private int number;
    private int guess;
    private int smallest;
    private int biggest;
    private int remainingGuesses;
    private boolean validNumberRange = true;

    public GameImpl(NumberGenerator numberGenerator, @GuessCount int guessCount) {
        this.numberGenerator = numberGenerator;
        this.guessCount = guessCount;
    }

    @PostConstruct
    // Should we use this annotation?
    // Stop Using @PostConstruct in Your Java Applications::
    // https://levelup.gitconnected.com/stop-using-postconstruct-in-your-java-applications-2a66fb202cb8
    @Override
    public void reset() {
        smallest = numberGenerator.getMinNumber();
        guess = smallest;
        remainingGuesses = guessCount;
        biggest = numberGenerator.getMaxNumber();
        number = numberGenerator.next();
        log.debug("The number is {}", number);
    }

    @Override
    public void check() {
        checkValidNumberRange();

        if (validNumberRange) {
            if (guess > number) biggest = guess - 1;
            else if (guess < number) smallest = guess + 1;
        }

        remainingGuesses--;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public int getGuess() {
        return guess;
    }

    @Override
    public void setGuess(int guess) {
        this.guess = guess;
    }

    @Override
    public int getSmallest() {
        return smallest;
    }

    @Override
    public int getBiggest() {
        return biggest;
    }

    @Override
    public int getRemainingGuesses() {
        return remainingGuesses;
    }

    @Override
    public int getGuessCount() {
        return guessCount;
    }

    @Override
    public boolean isValidNumberRange() {
        return validNumberRange;
    }

    @Override
    public boolean isGameWon() {
        return guess == number;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && remainingGuesses <= 0;
    }

    private void checkValidNumberRange() {
        validNumberRange = (guess >= smallest) && (guess <= biggest);
    }
}
