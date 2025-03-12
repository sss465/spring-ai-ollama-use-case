package org.example.springaiollama;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.QuestionAnswerAdvisor;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.milvus.MilvusVectorStore;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * RAG
 * @date 2025/3/12
 */
@Slf4j
@SpringBootTest
class RAGTest {

    @Resource
    private OllamaChatModel ollamaChatModel;
    @Resource
    private MilvusVectorStore milvusVectorStore;

    @Test
    void qaTest() {
        ChatResponse response = ChatClient.builder(ollamaChatModel).build().prompt()
                .advisors(new QuestionAnswerAdvisor(milvusVectorStore, SearchRequest.builder().similarityThreshold(0.5).topK(5).build()))
                .user("阿里云和通义实验室在编码上推出了什么功能？").call().chatResponse();
        log.info("response: {}", response.getResult().getOutput().getText());
    }
}
