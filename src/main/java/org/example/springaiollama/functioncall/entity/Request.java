package org.example.springaiollama.functioncall.entity;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import lombok.Data;

/**
 * 请求
 *
 * @author houbw
 * @date 2024/12/18
 */
@Data
@JsonClassDescription("提供地区简称的查询")
public class Request {

    /**
     * 名称
     */
    private String name;
}
