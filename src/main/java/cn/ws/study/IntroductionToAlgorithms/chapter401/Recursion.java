package cn.ws.study.IntroductionToAlgorithms.chapter401;

/**
 * TODO
 *
 * @author : Host-424
 * @date Date : 2021-10-19 17:32
 */
public class Recursion {
    public static void main(String[] args) {
        System.out.println(result(3, 9));
    }


    public static int result(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int result = result(x, n / 2);
        if (n % 2 == 1) {
            return result * result * x;
        }
        else {
            return result * result;
        }
    }
}
