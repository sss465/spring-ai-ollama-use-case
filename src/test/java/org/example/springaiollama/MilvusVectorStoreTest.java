package org.example.springaiollama;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.milvus.MilvusVectorStore;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * 向量数据库基本操作
 * @date 2025/3/6
 */
@Slf4j
@SpringBootTest
class MilvusVectorStoreTest {

    @Resource
    private MilvusVectorStore milvusVectorStore;

    @Test
    void saveTest() {
        // 主体为文档内容字段：content
        // 内容的嵌入向量字段：embedding
        // 元数据中的字段：title
        // 目前文档是自动生成ID：doc_id
        List<Document> docs = List.of(
                new Document("全球领先的专业级视频生成服务Vidu API开放平台全面开放，面向企业级用户与个人开发者。" +
                        "具备多模态语义理解能力，支持文字、图片等多模态指令输入，精准匹配创作意图。动漫风格稳定，画面流畅，帧间一致性高，" +
                        "首创多主体一致性技术，突破模型上下文理解限制。",
                        Map.of("title", "Vidu API 开放平台全面开放，开启智能化内容生产范式")),
                new Document("OpenAI宣布成立NextGenAI教育联盟，联合15家顶尖大学和机构，包括加州理工学院、哈佛大学、" +
                        "麻省理工学院、牛津大学等。OpenAI将提供5000万美元（约合人民币3.6亿元）的研究补助金、计算资源和API访问权限，" +
                        "支持学生、教育工作者和研究人员推进AI研究与教育创新。",
                        Map.of("title","OpenAI宣布提供3.6亿，联合15个大学和机构建立NextGenAI教育联盟")),
                new Document("智谱正式发布并开源最新的图像生成模型CogView4。模型具备强大的复杂语义对齐和指令跟随能力，" +
                        "支持任意长度的中英双语输入，可生成任意分辨率的图像。CogView4在DPG-Bench基准测试中综合评分排名第一，" +
                        "成为开源文生图模型中的最先进技术（SOTA）。",
                        Map.of("title", "智谱发布开源图像生成模型CogView4，首个支持中英双语，图像生成迎来新突破")),
                new Document("阿里云和通义实验室联合推出的AI编码助手“通义灵码”上线了Qwen2.5-Max模型。" +
                        "模型使用超过20万亿token的预训练数据及优化的后训练方案，在Arena-Hard、LiveBench等基准测试中，" +
                        "Qwen2.5-Max领先业界，在数学和编程能力上排名第一。",
                        Map.of("title", "通义灵码上新Qwen2.5-Max模型，体验数学和编程双冠王能力"))
        );
        milvusVectorStore.add(docs);
    }

    @Test
    void searchTest() {
        List<Document> results = milvusVectorStore.similaritySearch(SearchRequest.builder().query("语义理解").topK(5).build());
        log.info("search results: {}", results);
    }

    @Test
    void searchWithCondition() {
        List<Document> results = milvusVectorStore.similaritySearch(SearchRequest.builder().query("AI").topK(5)
                .similarityThreshold(0.5)
                .filterExpression("title == '通义灵码上新Qwen2.5-Max模型，体验数学和编程双冠王能力'").build());
        log.info("condition search results: {}", results);
    }
}
