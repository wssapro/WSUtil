package cn.ws.blazefire.smtk;

/**
 * 基础请求
 *
 * @author shun
 * @date 2020-09-11 19:39
 */
public class BaseReq {

    private String appKey;

    private String secretKey;

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
