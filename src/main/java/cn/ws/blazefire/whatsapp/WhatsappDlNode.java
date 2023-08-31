package cn.ws.blazefire.whatsapp;

/**
 * TODO
 *
 * @author : Host-424
 * @date Date : 2022-04-13 20:01
 */
public class WhatsappDlNode {
    private String token;
    private String phone;
    private String country;


    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
