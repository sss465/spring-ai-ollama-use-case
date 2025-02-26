package org.example.springaiollama;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 执行操作
 * @date 2025/2/26
 */
@Slf4j
@SpringBootTest
class ToolCallingTakeActionTest {

    @Resource
    private OllamaChatModel ollamaChatModel;

    @Test
    void setAlarmTest() {
        // 注意：在提问时“当前时间”这个关键词很重要，是用来提示模型调用获取当前时间的方法
        String question = "你能帮我设置一个当前时间之后10分钟的闹钟吗？";
        String result = ChatClient.create(ollamaChatModel).prompt(question).tools(new DateTimeTools()).call().content();
        log.info("{} {}", question, result);
    }
}
