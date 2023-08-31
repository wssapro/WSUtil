package cn.ws.blazefire.whatsapp.advertiseThree;

/**
 * TODO
 *
 * @author : Host-424
 * @date Date : 2022-04-13 20:01
 */
public class WhatsappDlTokenNode {

    private String token;
    private String phone;
    private String country;
    private String version;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
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
