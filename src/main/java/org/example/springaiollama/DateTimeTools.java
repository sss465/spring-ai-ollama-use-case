package org.example.springaiollama;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.context.i18n.LocaleContextHolder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 工具类
 * @date 2025/2/25
 */
@Slf4j
public class DateTimeTools {

    /**
     * 信息检索：获取当前时间的工具
     * @return 当前时间
     */
    @Tool(description = "获取用户所在时区的当前日期和时间")
    public String getCurrentDateTime() {
        return LocalDateTime.now().atZone(LocaleContextHolder.getTimeZone().toZoneId()).toString();
    }

    /**
     * 设置警报
     * @param time 时间
     */
    @Tool(description = "为给定的时间设置用户闹钟，该时间以ISO-8601格式提供。")
    public void setAlarm(String time) {
        LocalDateTime alarmTime = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME);
        log.info("时间设置为：" + alarmTime);
    }
}
