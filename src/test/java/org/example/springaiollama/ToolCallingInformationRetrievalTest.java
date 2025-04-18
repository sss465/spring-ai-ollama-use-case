package org.example.springaiollama;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 工具调用：信息检索
 * @date 2025/2/25
 */
@Slf4j
@SpringBootTest
class ToolCallingInformationRetrievalTest {

    @Resource
    private OllamaChatModel ollamaChatModel;

    @Test
    void dateTimeTest() {
        // 这里模型可以识别“明天”的含义为当天的下一天
        String question = "明天是几号？";
        String result = ChatClient.create(ollamaChatModel).prompt(question).tools(new DateTimeTools()).call().content();
        log.info("{} {}", question, result);
    }
}
