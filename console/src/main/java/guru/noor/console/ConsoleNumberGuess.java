package guru.noor.console;

import guru.noor.Game;
import guru.noor.MessageGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.context.ApplicationListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@SuppressWarnings("CommentedOutCode")
@Component
public class ConsoleNumberGuess /*implements ApplicationListener<ContextRefreshedEvent> */ {
    private static final Logger log = LoggerFactory.getLogger(ConsoleNumberGuess.class);

    @Autowired
    private Game game;

    @Autowired
    private MessageGenerator messageGenerator;


//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent event) {
//        log.info("ConsoleNumberGuess - Container is ready for use!");
//    }

//    @EventListener
//    public void start(ContextRefreshedEvent event) {
//        log.info("ConsoleNumberGuess (start) - Container is ready for use!");
//    }

    @EventListener(ContextRefreshedEvent.class)
    public void start() {
        log.info("ConsoleNumberGuess (start) - Container is ready for use!");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            log.info(messageGenerator.getMainMessage());
            log.info(messageGenerator.getResultMessage());

            int guess = scanner.nextInt();
            scanner.nextLine();
            game.setGuess(guess);
            game.check();

            if (game.isGameWon() || game.isGameLost()) {
                log.info(messageGenerator.getResultMessage());
                log.info("Play again y/[n]?");

                String playAgainString = scanner.nextLine().trim();
                if (!playAgainString.equalsIgnoreCase("y")) {
                    break;
                }

                game.reset();
            }
        }
    }
}
