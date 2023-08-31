package cn.ws.study.dataStructure.example;

/**
 * 斐波那契数列
 *
 * @author : Host-424
 * @date Date : 2021-10-15 18:28
 */
public class FibonacciSequence {

    public static void main(String[] args) {

        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += fibonacci(i);
        }
        System.out.println(sum);
    }

    /**
     * 获取指定位置数值
     */
    public static int fibonacci(int num) {
        if (num == 0 || num == 1) {
            return num;
        }
        return fibonacci(num - 1) + fibonacci(num - 2);
    }
}
