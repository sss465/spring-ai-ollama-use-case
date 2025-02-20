package org.example.springaiollama.functioncall.function;

import lombok.extern.slf4j.Slf4j;
import org.example.springaiollama.functioncall.entity.Request;
import org.example.springaiollama.functioncall.entity.Response;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 * 我的测试服务
 *
 * @author houbw
 * @date 2024/12/18
 */
@Slf4j
@Component("myTestFunction")
@Description("提供地区简称的查询")
public class MyTestFunction implements Function<Request, Response> {
    @Override
    public Response apply(Request request) {
        log.info("请求：{}", request);
        return switch (request.getName()) {
            case "北京" -> new Response("京");
            case "上海" -> new Response("沪");
            case "深圳" -> new Response("深");
            default -> null;
        };
    }
}
