package cn.ws.blazefire.whatsapp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WhatsAppInfo {
    // 安卓id
    private String android_id;

    // 安卓版本
    private String android_version;

    // 谷歌id
    private String ga_id;

    // 地区码
    private String region;

    // 品牌（Build.BRAND）
    private String brand;

    // 公布的版本（一般用于手机信息的系统版本 Build.VERSION.RELEASE）
    private String version;

    // 机型（Build.MODEL）
    private String phone_model;

    // WhatsApp应用版本号（pm dump com.whatsapp|grep versionName）
    private String wa_version;

    // 制造商（Build.MANUFACTURER）
    private String manufacturer;

    // 平台类型（Build.BOARD）
    private String board;

    // 版本号（设置-关于手机-版本号Build.DISPLAY）
    private String display;

    // 外部存储总量
    private String crt;

    // 内部存储总量
    private String mem;

    // cpu 型号
    private String cu;

    /*
     *	me、rc2文件地址:/data/data/com.whatsapp/files
     */

    // me文件 内容 base64加密
    private String me;

    // rc2文件 内容base64加密
    private String rc;

    /*
        keystore.xml文件地址：/data/data/com.whatsapp/shared_prefs
     */
    // keystore文件 内容base64加密
    private String keystore;

    /*
     * 	privatekKey、privateKey、registrationId、record字段获取方式：
        获取本机数据库文件，查询出对应表数据
        文件地址：
        /data/data/com.whatsapp/databases/axolotl.db
        sql语句：
        select hex(private_key),hex(private_key),registration_id from identities where recipient_id = -1;
        select hex(record) from signed_prekeys order by prekey_id limit 1;
     *
     */
    // 公钥 内容base64加密
    private String publicKey;

    // 私钥 内容base64加密
    private String privateKey;

    // 注册id
    private String registrationId;

    // record 内容base64加密
    private String record;

    // 昵称
    // cat com.whatsapp_preferences_light.xml |grep push_name
    private String pn;

    // IP地址
    private String ip;
    // 国家码
    private String country;

    // 语言
    private String language;

    // ../Database/axolotl.db取prekeyId（与record一起取最新）
    private String prekey_id;

    // whatsapp_preferences_light.xml phoneid_id
    private String phoneid_id;

    // whatsapp_preferences_light.xml routing_info
    private String routing_info;
    private String registration_jid;
    private String cc;
}
