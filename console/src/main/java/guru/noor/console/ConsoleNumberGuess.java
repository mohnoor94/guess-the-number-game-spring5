package guru.noor.console;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ConsoleNumberGuess /*implements ApplicationListener<ContextRefreshedEvent> */ {
    private static final Logger log = LoggerFactory.getLogger(ConsoleNumberGuess.class);


////    @Override
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
    }
}
