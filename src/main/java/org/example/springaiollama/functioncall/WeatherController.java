package org.example.springaiollama.functioncall;

import jakarta.annotation.Resource;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 天气服务
 *
 * @author houbw
 * @date 2024/12/10
 */
@RestController
public class WeatherController {

    @Resource
    private OllamaChatModel ollamaChatModel;

    @GetMapping("/ai/function/weather")
    public Map<String, String> weather() {
       UserMessage userMessage = new UserMessage("What's the weather like in San Francisco, Tokyo, and Paris?");
        ChatResponse chatResponse = ollamaChatModel.call(new Prompt(userMessage, OllamaOptions.builder().withFunction("CurrentWeather").build()));
        System.out.println(chatResponse);
        return Map.of("weather", chatResponse.toString());
    }
}
