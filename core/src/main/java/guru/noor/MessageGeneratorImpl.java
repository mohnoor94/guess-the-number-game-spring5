package guru.noor;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
@AllArgsConstructor
public class MessageGeneratorImpl implements MessageGenerator {

    private final Game game;

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
