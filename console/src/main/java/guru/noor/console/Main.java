package guru.noor.console;

import guru.noor.config.GameConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {
    //    private static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args) {
        log.info("Guess the Number Game!");

        // Create the context(container)
        //        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(GameConfig.class);

//        // Get the bean
//        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);
//
//        // Use the bean
//        int number = numberGenerator.next();
//        log.info("Number: {}", number);
//
//        // ...
//        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);
//        log.info("getMainMessage = {}", messageGenerator.getMainMessage());
//        log.info("getResultMessage = {}", messageGenerator.getResultMessage());

        // Close the context(container)
        context.close();
    }
}
