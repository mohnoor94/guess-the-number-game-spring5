package guru.noor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    private static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args) {
        log.info("Guess the Number Game!");

        // Create the context(container)
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);

        // Get the bean
        NumberGenerator numberGenerator =
                context.getBean("numberGenerator", NumberGenerator.class); // by type and id(or name)

        // Use the bean
        int number = numberGenerator.next();
        log.info("Number: {}", number);

        // Same steps for the Game
        Game game = context.getBean(Game.class); // by type
        // game.reset();

        // Close the context(container)
        context.close();
    }
}
