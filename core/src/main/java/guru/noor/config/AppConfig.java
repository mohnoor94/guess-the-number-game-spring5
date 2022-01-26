package guru.noor.config;

// Java Annotation Configuration
// This is to replace "beans.xml" file

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@SuppressWarnings("CommentedOutCode")
@Configuration
@Import(GameConfig.class)
@ComponentScan(basePackages = "guru.noor")
public class AppConfig {

//    @Bean
//    // Needed for certain configs - otherwise using @Component on the class itself is good enough.
//    public NumberGenerator numberGenerator() {
//        return new NumberGeneratorImpl();
//    }

}
