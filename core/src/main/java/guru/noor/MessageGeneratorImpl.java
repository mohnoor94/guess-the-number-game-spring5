package guru.noor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MessageGeneratorImpl implements MessageGenerator {
    private static final Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);

    private final Game game;

    public MessageGeneratorImpl(Game game) {
        this.game = game;
    }

    @PostConstruct
    public void init() {
        log.info("game = {}", game);
    }

    @Override
    public String getMainMessage() {
        return "Number is between " +
                game.getSmallest() +
                " and " +
                game.getBiggest() +
                ". Can you guess it?";
    }

    @Override
    public String getResultMessage() {
        if (game.isGameWon()) return "You guessed it! The number was " + game.getNumber();

        if (game.isGameLost()) return "You lost. The number was " + game.getNumber();

        if (!game.isValidNumberRange()) return "Invalid number range!";

        if (game.getRemainingGuesses() == game.getGuessCount()) return "What is your first guess?";

        String direction = game.getGuess() < game.getNumber() ? "Higher" : "Lower";
        return direction + "! You have " + game.getRemainingGuesses() + " guesses left";
    }
}
