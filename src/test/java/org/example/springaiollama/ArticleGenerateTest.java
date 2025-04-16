package org.example.springaiollama;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @date 2025/4/15
 */
@Slf4j
@SpringBootTest
public class ArticleGenerateTest {

    @Resource
    private OllamaChatModel ollamaChatModel;

    @Test
    void chatTest() {
        String system = "你是一个资深的新闻网编辑。你的任务是根据模板文章对素材进行仿写，让它与原文有相似的风格和效果。仿写后文章时间为2025年4月15日；学校为清华大学；学院为马克思主义学院；主题为‘以文化为主线推进深度改革’";
        String user = "2025年4月12日下午，北京大学新时代中国特色社会主义思想研究院主办的国家社会科学基金重大专项“以制度建设为主线推进全面深化改革研究”项目开题会在北京大学陈守仁国际研究中心中馆举行。北京大学社会科学部副部长、外国语学院教授林丰民出席并致辞，北京大学习近平新时代中国特色社会主义思想研究院院长、北京大学博雅讲席教授、课题组首席专家王浦劬和课题组子课题负责人汇报课题总体情况和研究计划。来自吉林大学、北京大学、中国社会科学院、中国人民大学、上海财经大学等机构的40余位专家学者参会。会议由中国政治学会学术委员会副主任、吉林大学行政学院教授周光辉主持。";
        String result = ChatClient.create(ollamaChatModel).prompt().system(system).user(user).call().content();
        log.info("result: {}", result);
    }
}
