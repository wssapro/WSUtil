package cn.ws.blazefire.smtk;

import java.util.List;

/**
 * @author shun
 * @date 2021-06-07 10:20
 */
public class MpSmsReq extends BaseReq {
    private String timestamp;

    private String rd;

    private String sign;

    private List<String> phone;


    private List<String> smsIds;

    private String message;

    public List<String> getSmsIds() {
        return smsIds;
    }

    public void setSmsIds(List<String> smsIds) {
        this.smsIds = smsIds;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getRd() {
        return rd;
    }

    public void setRd(String rd) {
        this.rd = rd;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public List<String> getPhone() {
        return phone;
    }

    public void setPhone(List<String> phone) {
        this.phone = phone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
