package org.example.springaiollama;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.context.i18n.LocaleContextHolder;

import java.time.LocalDateTime;

/**
 * 信息检索：获取当前时间的工具
 * @date 2025/2/25
 */
public class DateTimeTools {

    @Tool(description = "获取用户所在时区的当前日期和时间")
    public String getCurrentDateTime() {
        return LocalDateTime.now().atZone(LocaleContextHolder.getTimeZone().toZoneId()).toString();
    }
}
