package guru.noor.config;

import guru.noor.qualifier.GuessCount;
import guru.noor.qualifier.MaxNumber;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfig {
    @Bean
    @MaxNumber
    public int maxNumber() {
        return 100;
    }

    @Bean
    @GuessCount
    public int guessCount() {
        return 10;
    }
}
