package guru.noor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfig {
    @Bean
    public int maxNumber() {
        return 100;
    }

    @Bean
    public int guessCount() {
        return 10;
    }
}
