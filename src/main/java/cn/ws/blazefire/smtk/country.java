package cn.ws.blazefire.smtk;

import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author : 10617-wangshun
 * @description :
 * @date : 2023-11-02 17:37
 */
public class country {
    /**
     * 2#1#0
     * 2-AO|IN#1-AO|IN
     */
    public static void main(String[] args) {
        String str ="2-AO|";
        HashMap<Integer, HashSet<String>> hashMap = getHashMap(str);

        System.out.println(1);
    }

    public static HashMap<Integer, HashSet<String>> getHashMap(String str) {
        HashMap<Integer, HashSet<String>> map = new HashMap<>();
        if (StringUtils.isNotEmpty(str)) {
            String[] idCountryListArr = str.split("#");
            for (String idCountry : idCountryListArr) {
                if (StringUtils.isNotEmpty(idCountry)) {
                    String[] idCountryArr = idCountry.split("-");
                    if(idCountryArr.length==2){
                        int platform = Integer.parseInt(idCountryArr[0]);
                        String countryStr = idCountryArr[1];
                        HashSet<String> countrySet = getHashSet(countryStr,"\\|");
                        map.put(platform, countrySet);
                    }
                }
            }
        }
        return map;
    }


    public static HashSet<String> getHashSet(String str,String splitKey) {
        HashSet<String> set = new HashSet<String>();
        if (str != null && !"".equals(str)) {
            String[] split = str.split(splitKey);
            if (split.length == 0) {
                return set;
            }
            Collections.addAll(set, split);
        }
        return set;
    }
}
