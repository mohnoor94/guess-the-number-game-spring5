package guru.noor.config;

import guru.noor.qualifier.GuessCount;
import guru.noor.qualifier.MaxNumber;
import guru.noor.qualifier.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config/game.properties")
public class GameConfig {
    @Value("${game.maxNumber}")
    private int maxNumber;

    @Value("${game.minNumber}")
    private int minNumber;

    @Value("${game.guessCount:5}") // ":5" default value of this property!
    private int guessCount;

    @Bean
    @MaxNumber
    public int maxNumber() {
        return maxNumber;
    }

    @Bean
    @MinNumber
    public int minNumber() {
        return minNumber;
    }

    @Bean
    @GuessCount
    public int guessCount() {
        return guessCount;
    }
}
