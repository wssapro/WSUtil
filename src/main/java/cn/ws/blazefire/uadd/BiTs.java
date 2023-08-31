package cn.ws.blazefire.uadd;

/**
 * TODO
 *
 * @author : Host-424
 * @date Date : 2022-08-29 14:53
 */
public class BiTs {
    public static void main(String[] args) {

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        Integer partners_bit = 1 << 30;

        System.out.println(Integer.toBinaryString(partners_bit));
        System.out.println(partners_bit);

        int a = 1 |  partners_bit;

        System.out.println(Integer.toBinaryString(a));
        System.out.println(a);
    }
}
