package cn.ws.blazefire.opc;

import cn.ws.tools.ReadLog;
import cn.ws.tools.WriteLog;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author : Host-424
 * @date Date : 2023-02-24 18:08
 */
public class OpClOGIC {


    public static String file = "C:\\Users\\Host-424\\Desktop\\a\\ReqAndResLog_20230224.";

    public static void main(String[] args) {


        String aaa = "2023-02-24 15:00:57.472 DEBUG ReqAndResLog:146 - [IP=172.168.77.29]{\"abroad\":true,\"androidId\":\"08f444938b9c6e538240c6e1d868e2c3\",\"apilevel\":26,\"audioStatus\":0,\"batteryCapacity\":31,\"businessType\":\"opccoreabroad\",\"callStatus\":1,\"carrierOperator\":0,\"cd\":79010001,\"cityID\":0,\"country\":\"GB\",\"countryID\":159,\"debugStatus\":0,\"deviceFirm\":\"HUAWEI\",\"deviceName\":\"ATU-L42\",\"imei\":\"867273035459028\",\"imsi\":\"422030602592985\",\"installPackageVersion\":\"com.android.chrome#70.0.3538.110,com.android.vending#34.4.16-21 [0] [PR] 507539062,com.facebook.katana#400.0.0.37.76,com.facebook.orca#394.0.0.15.72,com.google.android.gm#8.10.21.220187835.release,com.google.android.googlequicksearchbox#13.48.11.26.arm64,com.google.android.packageinstaller#8.0.0-5674515,com.google.android.youtube#18.03.33,com.whatsapp#2.22.24.78,\",\"ip\":\"37.200.132.82\",\"language\":\"en\",\"mcc\":\"422\",\"mnc\":[\"03\"],\"netType\":3,\"opversion\":\"1.8.9\",\"osVersion\":\"8.0.0\",\"packageName\":\"com.android.systemui\",\"proviceID\":0,\"province\":\"阿曼\",\"screenStatus\":false,\"sericode\":\"1534891720\",\"storageRead\":true,\"storageWrite\":true,\"targetPositionID\":0,\"testPositionID\":0,\"timezone\":\"GMT+04:00\",\"version\":2046}[input]{\"ctrlJsonResult\":\"{\\\"oadList\\\":[{\\\"oadID\\\":15,\\\"oadUrl\\\":\\\"https://j9elr4.ik27s.com/opa/opcOad/file/Opccore_20220802160600.od\\\",\\\"oadMD5\\\":\\\"70285589721FC07D94303EFAB7B0780A\\\",\\\"oadClassName\\\":\\\"opccore.oad.simulatedclick.OPCCore\\\",\\\"oadName\\\":\\\"OPC\\\"}],\\\"positionList\\\":[{\\\"billID\\\":\\\"2023022415005747152666A\\\",\\\"businessID\\\":285,\\\"advertID\\\":16,\\\"positionID\\\":16190,\\\"parameters\\\":\\\"{\\\\\\\"sendJmdReport\\\\\\\":\\\\\\\"false\\\\\\\",\\\\\\\"runType\\\\\\\":0,\\\\\\\"scriptList\\\\\\\":[{\\\\\\\"jmdName\\\\\\\":\\\\\\\"40deb401b9ffe8e1df2f1cc5ba480b1236.jmd\\\\\\\",\\\\\\\"packageName\\\\\\\":\\\\\\\"com.android.chrome\\\\\\\",\\\\\\\"parameter\\\\\\\":\\\\\\\"{\\\\\\\\\\\\\\\"url\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"https://game.086313.com/IT/L7/index.html?gameChannelId\\u003d4518\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"x1\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"129\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"y1\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"443\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"x2\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"603\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"y2\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"711\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"time1\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"20000\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"time2\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"40000\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"dj\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"9600\\\\\\\\\\\\\\\"}\\\\\\\",\\\\\\\"scriptCode\\\\\\\":\\\\\\\"https://j9elr4.ik27s.com/opa/scriptFile/2023020911590307965295d9a401f650802ebea1b8b82e.data\\\\\\\",\\\\\\\"versions\\\\\\\":\\\\\\\"\\\\\\\"}],\\\\\\\"sendImageReport\\\\\\\":\\\\\\\"false\\\\\\\",\\\\\\\"romLimitSize\\\\\\\":0,\\\\\\\"keyguardURL\\\\\\\":\\\\\\\"https://j9elr4.ik27s.com/opa/encodeFile/ff47cb7f1121a21f71cae53bb489d2e7.data\\\\\\\",\\\\\\\"runPackage\\\\\\\":\\\\\\\"com.android.chrome\\\\\\\",\\\\\\\"dangerPackageList\\\\\\\":\\\\\\\"https://j9elr4.ik27s.com/opa/dangerPackageList/d3b7f9f38d2f4531a50771633417fe0e.data\\\\\\\",\\\\\\\"maxWaitTime\\\\\\\":\\\\\\\"600\\\\\\\",\\\\\\\"sendMasksReport\\\\\\\":\\\\\\\"false\\\\\\\",\\\\\\\"sendScriptReport\\\\\\\":\\\\\\\"true\\\\\\\",\\\\\\\"clipboardInfo\\\\\\\":\\\\\\\"\\\\\\\",\\\\\\\"forceUpdata\\\\\\\":\\\\\\\"false\\\\\\\",\\\\\\\"downloadFile\\\\\\\":[{\\\\\\\"md5\\\\\\\":\\\\\\\"1D9C0010C1DD86C5ED23946B0DD073AD\\\\\\\",\\\\\\\"type\\\\\\\":\\\\\\\"26F45194LZPFYRMM\\\\\\\",\\\\\\\"url\\\\\\\":\\\\\\\"https://j9elr4.ik27s.com/opa/opcOad/APP/01f73df699d41eb1f907891b9c6dfca4.jmd\\\\\\\",\\\\\\\"version\\\\\\\":0}],\\\\\\\"operatorInfo\\\\\\\":\\\\\\\"\\\\\\\",\\\\\\\"openPermission\\\\\\\":\\\\\\\"true\\\\\\\",\\\\\\\"operatorType\\\\\\\":0,\\\\\\\"adaptationInfo\\\\\\\":\\\\\\\"\\\\\\\",\\\\\\\"runParameter\\\\\\\":\\\\\\\"\\\\\\\"}\\\",\\\"oadID\\\":15}],\\\"result\\\":1}\",\"nodePositionList\":[{\"billID\":\"2023022415005747152666A\",\"positionID\":16190,\"advertID\":16,\"businessID\":285,\"oadType\":\"OPC\"}],\"result\":0}";

        System.out.println(aaa.contains("cd\":7901"));
        System.out.println(aaa.contains("result\":0"));
        List<String> a = new ArrayList<>();
        for (int i = 117; i <=142; i++) {

            List<String> read = ReadLog.read(file+ i + ".log");

            for (String s : read) {
                if(s.contains("cd\":7901") && s.contains("result\":0")){
                    a.add(s);
                }
            }


        }

        WriteLog.write("C:\\Users\\Host-424\\Desktop\\a\\aaa.log",a,true);
        System.out.println(1);
    }
}
