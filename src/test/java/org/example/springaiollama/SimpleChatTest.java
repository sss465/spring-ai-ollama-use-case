package org.example.springaiollama;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 简单对话测试
 * @date 2025/2/20
 */
@Slf4j
@SpringBootTest
class SimpleChatTest {

    @Resource
    private OllamaChatModel ollamaChatModel;

    @Test
    void chatTest() {
        String result = ollamaChatModel.call("你好，请问你是谁？都能提供哪些服务？");
        log.info("result: {}", result);
    }
}
