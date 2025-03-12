# Spring AI 使用案例
1. 本项目用于学习基于ollama的Spring AI框架的使用

## 实例列表
> 所有调用方式都在src/test/java/org/example/springaiollama下
1. `简单对话`：org.example.springaiollama.SimpleChatTest
   1. 需要在ollama中安装chat模型
   2. 需要在配置文件中配置ollama的chat模型
   3. 需要引入spring-ai-ollama-spring-boot-starter依赖
2. `工具调用 > 信息检索`：org.example.springaiollama.ToolCallingInformationRetrievalTest
   1. chat模型需要支持ToolCalling功能，如：Qwen2.5+
3. `工具调用 > 执行操作`：org.example.springaiollama.ToolCallingTakeActionTest
4. `向量数据库Milvus操作`：org.example.springaiollama.MilvusVectorStoreTest
   1. 需要在ollama中安装embedding模型
   2. 需要在配置文件中配置ollama的embedding模型
   3. 需要引入spring-ai-milvus-store-spring-boot-starter依赖
   4. 需要安装Milvus数据库
   5. 需要自定义MilvusVectorStore：定义好数据库和集合后运行程序会自动生成
   6. 注意：每个embedding模型的维度不同，在定义维度时要根据模型指定，比如：nomic-embed-text的维度是768
5. `RAG`：org.example.springaiollama.RAGTest
   1. 前提是有chat和embedding模型及向量数据库