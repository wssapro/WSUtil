package cn.ws.blazefire.whatsapp.advertiseTwo;

import cn.ws.blazefire.whatsapp.advertiseOne.TokenBean;
import com.alibaba.fastjson.JSONObject;

import java.math.BigInteger;
import java.util.HashMap;

/**
 * TODO
 *
 * @author : Host-424
 * @date Date : 2022-06-23 17:41
 */
public class Test {
    public static void main(String[] args) {

        String sss="16514616182----Murray Thomas----GH1FPdZ/mXTHzMGq7xN6dUOQali7Er7SUpUgRQvK3UOtZcJyD0XqAq9+AV0j6vH/9WJagkYQmFXZ+7GOqUcGEg==----LKFtqKAASnxIgl89fmUjtpxpL8WVkwPZLMk3ybT3ggI----CA0IBQ==----{\"identity\": {\"hexPrivate\": \"4829fca542ea52d9d64577e8c871f040744265d39c0e0b1671a0c03e05a6ef6c\", \"hexPublic\": \"05d5fe0b47504ddff7fbcd744401e4f11d2a551806e478c6b27c6967a38aebc957\", \"id\": 1, \"registration_id\": 654085638, \"next_prekey_id\": 1632980145, \"timestamp\": 1655820166}, \"signedPreKey\": {\"hexKey\": \"080012210554db1c9e928a10a420ce85277521f7f9e6b0dee72f224318dfe8b3adce6866141a20e840efc75615327d09410c78e122d29311ad7cdd3247b6a1be2ecd811f9463662240f28662c8f49320b640518601303a204377f572cb0b3d1592f8b5575cc2caa4e0eb9855533a792578d9d293435b48c498023ca853a5dd57d47f0ed62db4e1a38b29396d928681010000\", \"prekey_id\": 0, \"timestamp\": 1655820166}}----665b278e-00f9-49ad-afff-2d35f8b161c5----uwHoJUHfCCfN1K+VO3iHLbUOxtM=----\"android_id=lbpzoonri4gu08nm\\nbluetooth_mac=00:11:83:77:46:39\\nbluetooth_name=7azluw5r0\\nboard=msm8916\\nbootloader=unknown\\nbrand=vivo\\nbuild_id=ZXKXPC1\\nconnect_wifi_mac=04:71:1d:ad:6f:31\\nconnect_wifi_name=n8g3q9l\\ndevice=vivo Y33\\ndisplay=LJH-0P18E8FPB\\nfingerprint=vivo/vivo Y33/vivo Y33:11/ZXKXPC1/V0.4.0.4.ome:user/release-keys\\nhardware=qcom\\nhost=ilrnt8u0ajg5v\\nimei0=868158782202225\\nincremental=V0.4.0.4.ome\\nmac=00:11:83:43:0f:c9\\nmanufacturer=vivo\\nmodel=vivo Y33\\nnearbyBluetooths=>14:B8:DB:03:C6:50>1f00,>12:57:17:ED:04:80>1f00,>CE:84:2D:39:89:B6>1f00,b2h36>74:18:5C:17:4C:FD>7a020c\\nproduct=vivo Y33\\nradio=vivo Y33.V0, 2018/06/8 15:56\\nscan_wifi_list=x304wvpzy,d0:43:75:ad:9e:86#n8g3q9l,04:71:1d:ad:6f:31#yb12u,b8:ff:63:47:af:57#b4tcr2e,ae:d8:c3:b4:34:1e#j5hblrp,14:ff:a7:25:31:bd\\nsdk_release=11\\nsdk=30\\nserial=17RSJCN47ID7\\nsettings=adb_enabled,0\\nsim_contry=us\\nsim_iccid=89010179276924807616\\nsim_imsi=310017712351790\\nsim_mobile_network_type=3\\nsim_mobile_network_type_code=us\\nsim_network_operator=310017\\nsim_network_operator_name=North Sight Communications Inc.\\nsim_operator=310017\\nsim_operator_name=North Sight Communications Inc.\\nsim_phone_number=+16514616182\\nsim_phone_type=1\\nsim_state=5\\nsim_mnc=017\\nsim_mcc=310\\ntype=user\\nuser=compiler01\\nlocale=en-US\\nlanguage=en\\nbuildDateUtc=0\\ncdmalatitude=0\\ncdmalongitude=0\\ncell_cid=0\\ncell_lac=0\\ncell_mcc=0\\ncell_mnc=-1\\ncell_psc=0\\ncodename=REL\\ncpu_abi2=armeabi\\ncpu_abi=armeabi-v7a\\ndensity=0\\ndensityScalfactor=0.0\\nlocation_latitude=0\\nlocation_longitude=0\\nscreen_h=2400\\nscreen_w=1080\\nsupported_32_bit_abis=armeabi-v7a,armeabi\\nsupported_64_bit_abis=arm64-v8a\\nsupported_abis=arm64-v8a,armeabi-v7a,armeabi\\ncpu_features=half thumb fastmult vfp edsp neon vfpv3 tls vfpv4 idiva idivt evtstrm aes pmull sha1 sha2 crc32\\ncpu_processor=null\\ncpu_architecture=8\\ncpu_hardware=Qualcomm Technologies, Inc MSM8994\\ncpu_serial=null\\nios_model=iPhone14,5\\nios_model_name=iPhone 13\\nios_version=15.3\"";

        String[] tokenArr = sss.split("----");

        JSONObject accountInfoJSONObject = JSONObject.parseObject(tokenArr[5]);
        JSONObject identity = accountInfoJSONObject.getJSONObject("identity");
        JSONObject signedPreKey = accountInfoJSONObject.getJSONObject("signedPreKey");
        String[] equipmentInfoArr = tokenArr[8].substring(1,tokenArr[8].length()-1).split("\\\\n");

        HashMap<String,String> equipmentInfoMap = new HashMap<>();

        for (String s : equipmentInfoArr) {
            String[] split = s.split("=");
            equipmentInfoMap.put(split[0],split[1]);
        }

        TokenBean tokenBean = new TokenBean();
        // tokenBean.setAndroid_id(equipmentInfoMap.get("android_id"));
        // tokenBean.setAndroid_version(equipmentInfoMap.get("sdk_release"));
        // tokenBean.setBoard(equipmentInfoMap.get("board"));
        // tokenBean.setBrand(equipmentInfoMap.get("brand"));
        // tokenBean.setCc(equipmentInfoMap.get("sim_phone_type"));
        tokenBean.setCrt(equipmentInfoMap.get("sim_contry"));
        tokenBean.setCu(equipmentInfoMap.get("sim_contry"));
        // tokenBean.setDisplay(equipmentInfoMap.get("display"));
        tokenBean.setGa_id(equipmentInfoMap.get("sim_contry"));
        tokenBean.setKeystore(equipmentInfoMap.get("sim_contry"));
        // tokenBean.setLanguage(equipmentInfoMap.get("language"));
        // tokenBean.setManufacturer(equipmentInfoMap.get("manufacturer"));
        tokenBean.setMe(equipmentInfoMap.get("sim_contry"));
        // tokenBean.setPhone_model(equipmentInfoMap.get("model"));
        tokenBean.setPhoneid_id(equipmentInfoMap.get("sim_contry"));
        // tokenBean.setPrekey_id(signedPreKey.getString("prekey_id"));
        tokenBean.setPrivateKey(equipmentInfoMap.get("sim_contry"));
        tokenBean.setPublicKey(equipmentInfoMap.get("sim_contry"));
        tokenBean.setRc(equipmentInfoMap.get("sim_contry"));
        // tokenBean.setRegion(equipmentInfoMap.get("sim_contry"));
        // tokenBean.setRegistrationId(identity.getString("registration_id"));
        // tokenBean.setRegistration_jid(equipmentInfoMap.get("sim_phone_number"));
        tokenBean.setRouting_info(equipmentInfoMap.get("sim_contry"));
        tokenBean.setVersion(equipmentInfoMap.get("sim_contry"));
        tokenBean.setWa_version(equipmentInfoMap.get("sim_contry"));
        tokenBean.setPn(equipmentInfoMap.get("sim_contry"));
        tokenBean.setIp(equipmentInfoMap.get("sim_contry"));
        // tokenBean.setCountry(equipmentInfoMap.get("sim_contry"));



        /*String str = "080012210554db1c9e928a10a420ce85277521f7f9e6b0dee72f224318dfe8b3adce6866141a20e840efc75615327d09410c78e122d29311ad7cdd3247b6a1be2ecd811f9463662240f28662c8f49320b640518601303a204377f572cb0b3d1592f8b5575cc2caa4e0eb9855533a792578d9d293435b48c498023ca853a5dd57d47f0ed62db4e1a38b29396d928681010000";
        String s = hexString2binaryString(str);
        byte[] keyStoreBytes = new byte[s.length()];
        for (int i = 0; i < s.length(); i++) {
            keyStoreBytes[i] = (byte) s.charAt(i);
        }
        System.out.println(s);
        // byte[] keyStoreBytes = keyStoreDecode(str);
        String keystore = new String(keyStoreBytes);
        System.out.println(keystore);

        System.out.println(hexStr2Str(str));*/


        System.out.println("end");
    }

    public static String hexStr2Str(String hex) {
        String hexStr = "";
        String str = "0123456789ABCDEF"; //16进制能用到的所有字符 0-15
        for(int i=0;i<hex.length();i++){
            String s = hex.substring(i, i+1);
            if(s.equals("a")||s.equals("b")||s.equals("c")||s.equals("d")||s.equals("e")||s.equals("f")){
                s=s.toUpperCase().substring(0, 1);
            }
            hexStr+=s;
        }

        char[] hexs = hexStr.toCharArray();//toCharArray() 方法将字符串转换为字符数组。
        int length = (hexStr.length() / 2);//1个byte数值 -> 两个16进制字符
        byte[] bytes = new byte[length];
        int n;
        for (int i = 0; i < bytes.length; i++) {
            int position = i * 2;//两个16进制字符 -> 1个byte数值
            n = str.indexOf(hexs[position]) * 16;
            n += str.indexOf(hexs[position + 1]);
            // 保持二进制补码的一致性 因为byte类型字符是8bit的  而int为32bit 会自动补齐高位1  所以与上0xFF之后可以保持高位一致性
            //当byte要转化为int的时候，高的24位必然会补1，这样，其二进制补码其实已经不一致了，&0xff可以将高的24位置为0，低8位保持原样，这样做的目的就是为了保证二进制数据的一致性。
            bytes[i] = (byte) (n & 0xff);
        }
        String name = "";
        try {
            name = new String(bytes);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return name;

    }
    /**
     * 将16进制转换为二进制
     *
     * @param hexString
     * @return
     */
    public static String hexString2binaryString(String hexString) {
        //16进制转10进制
        BigInteger sint = new BigInteger(hexString, 16);
        //10进制转2进制
        String result = sint.toString(2);
        //字符串反转
        return new StringBuilder(result).reverse().toString();
    }
}
