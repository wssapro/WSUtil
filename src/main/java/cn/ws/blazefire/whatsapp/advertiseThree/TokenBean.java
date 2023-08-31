/**
 * Copyright 2022 bejson.com
 */
package cn.ws.blazefire.whatsapp.advertiseThree;

public class TokenBean {

    // 安卓id
    private String android_id;

    // 安卓版本
    private String android_version;

    // 平台类型（Build.BOARD）
    private String board;

    // 品牌（Build.BRAND）
    private String brand;

    private String cc;


    // 外部存储总量
    private String crt;

    // cpu 型号
    private String cu;

    // 版本号（设置-关于手机-版本号Build.DISPLAY）
    private String display;

    // 谷歌id
    private String ga_id;

    // keystore文件 内容base64加密
    private String keystore;

    // 语言
    private String language;

    // 制造商（Build.MANUFACTURER）
    private String manufacturer;

    private String me;

    // 内部存储总量
    private String mem;

    // 机型（Build.MODEL）
    private String phone_model;

    private String phoneid_id;

    private String prekey_id;

    // 私钥 内容base64加密
    private String privateKey;

    // 公钥 内容base64加密
    private String publicKey;

    private String rc;

    // record 内容base64加密
    private String record;

    // 地区码
    private String region;

    // 注册id
    private String registrationId;

    private String registration_jid;

    private String routing_info;

    // 公布的版本（一般用于手机信息的系统版本 Build.VERSION.RELEASE）
    private String version;

    // WhatsApp应用版本号（pm dump com.whatsapp|grep versionName）
    private String wa_version;

    // 昵称
    // cat com.whatsapp_preferences_light.xml |grep push_name
    public String pn;

    // IP地址
    public String ip;
    // 国家码
    public String country;


    public String getPn() {
        return pn;
    }

    public void setPn(String pn) {
        this.pn = pn;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setAndroid_id(String android_id) {
        this.android_id = android_id;
    }

    public String getAndroid_id() {
        return android_id;
    }

    public void setAndroid_version(String android_version) {
        this.android_version = android_version;
    }

    public String getAndroid_version() {
        return android_version;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public String getBoard() {
        return board;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getCc() {
        return cc;
    }

    public void setCrt(String crt) {
        this.crt = crt;
    }

    public String getCrt() {
        return crt;
    }

    public void setCu(String cu) {
        this.cu = cu;
    }

    public String getCu() {
        return cu;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getDisplay() {
        return display;
    }

    public void setGa_id(String ga_id) {
        this.ga_id = ga_id;
    }

    public String getGa_id() {
        return ga_id;
    }

    public void setKeystore(String keystore) {
        this.keystore = keystore;
    }

    public String getKeystore() {
        return keystore;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setMe(String me) {
        this.me = me;
    }

    public String getMe() {
        return me;
    }

    public void setMem(String mem) {
        this.mem = mem;
    }

    public String getMem() {
        return mem;
    }

    public void setPhone_model(String phone_model) {
        this.phone_model = phone_model;
    }

    public String getPhone_model() {
        return phone_model;
    }

    public void setPhoneid_id(String phoneid_id) {
        this.phoneid_id = phoneid_id;
    }

    public String getPhoneid_id() {
        return phoneid_id;
    }

    public void setPrekey_id(String prekey_id) {
        this.prekey_id = prekey_id;
    }

    public String getPrekey_id() {
        return prekey_id;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setRc(String rc) {
        this.rc = rc;
    }

    public String getRc() {
        return rc;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public String getRecord() {
        return record;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegion() {
        return region;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistration_jid(String registration_jid) {
        this.registration_jid = registration_jid;
    }

    public String getRegistration_jid() {
        return registration_jid;
    }

    public void setRouting_info(String routing_info) {
        this.routing_info = routing_info;
    }

    public String getRouting_info() {
        return routing_info;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public void setWa_version(String wa_version) {
        this.wa_version = wa_version;
    }

    public String getWa_version() {
        return wa_version;
    }

}
