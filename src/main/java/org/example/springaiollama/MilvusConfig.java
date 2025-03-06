package org.example.springaiollama;

import io.milvus.client.MilvusServiceClient;
import io.milvus.param.IndexType;
import io.milvus.param.MetricType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.embedding.TokenCountBatchingStrategy;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.ai.vectorstore.milvus.MilvusVectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @date 2025/3/6
 */
@Slf4j
@Configuration
public class MilvusConfig {

    @Value("${spring.ai.vectorstore.milvus.database-name}")
    private String db;
    @Value("${spring.ai.vectorstore.milvus.collection-name}")
    private String col;
    @Value("${spring.ai.vectorstore.milvus.embedding-dimension}")
    private Integer dis;
    @Value("${spring.ai.vectorstore.milvus.embedding-field-name}")
    private String efn;

    @Bean
    public VectorStore milvusVectorStore(MilvusServiceClient milvusClient, EmbeddingModel embeddingModel) {

        log.info("Milvuls collection Name: {}", col);
        log.info("Milvuls datebase Name: {}", db);
        log.info("Milvuls embedding Dis : {}", dis);
        log.info("Milvuls embedding filedName: {}", efn);

        return MilvusVectorStore.builder(milvusClient, embeddingModel)
                .collectionName(col)
                .databaseName(db)
                .embeddingDimension(dis)
                .embeddingFieldName(efn)
                .indexType(IndexType.IVF_FLAT)
                .metricType(MetricType.COSINE)
                .batchingStrategy(new TokenCountBatchingStrategy())
                .initializeSchema(true)
                .build();
    }
}
