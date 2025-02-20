package org.example.springaiollama.functioncall;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

/**
 * 配置
 *
 * @author houbw
 * @date 2024/12/10
 */
@Configuration
public class Config {

    @Bean
    public Function<MockWeatherService.Request, MockWeatherService.Response> CurrentWeather() {
        return new MockWeatherService();
    }
}
