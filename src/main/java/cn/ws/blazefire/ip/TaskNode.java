package cn.ws.blazefire.ip;

import lombok.Data;

/**
 * @author : Host-424
 * @date Date : 2022-07-29 10:49
 */
@Data
public class TaskNode {

    /**
     * 任务id
     */
    private Integer taskId;

    /**
     * 国家
     */
    private String country;

    /**
     * 请求时间
     */
    private Long reqTime;
}
