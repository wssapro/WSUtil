package cn.ws.study.dataStructure.example;

/**
 * 汉诺塔问题
 *
 * @author : Host-424
 * @date Date : 2021-10-15 18:03
 */
public class TowerOfHanoi {

    public static void main(String[] args) {

        run(3, "A", "B", "C");

    }

    public static void run(int num, String from, String mindle, String to) {
        if (num == 1) {
            System.out.println(num + ":" + from + "->" + to);
        }
        else {
            //步骤一：借助目标位置，将n-1部分从起始位置移动到辅助位置
            run(num - 1, from, to, mindle);

            //步骤二：将最后一块从起始位置移动到目标位置
            System.out.println(num + ":" + from + "->" + to);

            //步骤三：借助起始位置，将n-1部分从辅助位置移动到目标位置
            run(num - 1, mindle, from, to);
        }

    }
}
