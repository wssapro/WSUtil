package cn.ws.blazefire.ip;

import lombok.Data;

/**
 *
 * @author : Host-424
 * @date Date : 2022-07-27 20:54
 */
@Data
public class BehaviorReq {

    /**
     * 状态（0-不可用、1-可用）
     */
    private int result;

    /**
     * 状态（0-超时、1-socket为空、2-Receiver为空）
     */
    private int reason;

    /**
     * 使用时间（单位：秒）
     */
    private int useTime;

    /**
     * 代理节点
     */
    private TaskNode taskNode;

    /**
     * 代理节点
     */
    private ProxyNode proxyNode;
}
