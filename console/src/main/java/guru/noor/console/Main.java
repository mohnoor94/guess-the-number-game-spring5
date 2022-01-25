package guru.noor.console;

import guru.noor.AppConfig;
import guru.noor.MessageGenerator;
import guru.noor.NumberGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    //    private static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args) {
        log.info("Guess the Number Game!");

        // Create the context(container)
        //        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Get the bean
        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);

        // Use the bean
        int number = numberGenerator.next();
        log.info("Number: {}", number);

        // ...
        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);
        log.info("getMainMessage = {}", messageGenerator.getMainMessage());
        log.info("getResultMessage = {}", messageGenerator.getResultMessage());

        // Close the context(container)
        context.close();
    }
}
