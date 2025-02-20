package org.example.springaiollama.functioncall;

import com.fasterxml.jackson.annotation.JsonClassDescription;

import java.util.function.Function;

/**
 * 天气服务
 *
 * @author houbw
 * @date 2024/12/10
 */
public class MockWeatherService implements Function<MockWeatherService.Request, MockWeatherService.Response> {

    /**
     * 温度单位单位
     */
    public enum Unit { C, F }

    /**
     * 请求
     * @param location 位置
     * @param unit 单位
     */
    @JsonClassDescription("Get the weather in location")
    public record Request(String location, Unit unit) {}

    /**
     * 响应
     * @param temp 温度
     * @param unit 单位
     */
    public record Response(double temp, Unit unit) {}

    /**
     * 方法调用 获取某地的温度信息
     *
     * @param request the function argument
     * @return 返回温度信息
     */
    public Response apply(Request request) {
        System.out.println(request);
        if (request.location.equals("北京")) {
            return new Response(40.0, Unit.C);
        }
        return new Response(30.0, Unit.C);
    }
}
