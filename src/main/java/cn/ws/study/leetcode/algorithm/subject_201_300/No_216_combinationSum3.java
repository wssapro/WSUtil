package cn.ws.study.leetcode.algorithm.subject_201_300;

import java.util.ArrayList;
import java.util.List;

/**
 * 216、找出所有相加之和为n 的k个数的组合。组合中只允许含有 1 -9 的正整数，并且每种组合中不存在重复的数字。
 * <p>
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class No_216_combinationSum3 {

    public static void main(String[] args) {
        List<List<Integer>> combine = new No_216_combinationSum3().combinationSum3(3, 9);
        System.out.println(combine);
    }

    public List<List<Integer>> list = new ArrayList<>();
    public List<Integer> step = new ArrayList<>();
    public int sum = 0;

    public List<List<Integer>> combinationSum3(int k, int n) {
        recursion(k, n, 1);
        return list;
    }

    public void recursion(int k, int n, int start) {
        // 枝减
        if (sum > n) {
            return;
        }
        if (sum == n && step.size() == k) {
            list.add(new ArrayList<>(step));
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (step.size() == k - 1) {
                if (sum + i != n) {
                    continue;
                }
            }
            step.add(i);
            sum += i;
            recursion(k, n, i + 1);
            step.remove(step.size() - 1);
            sum -= i;
        }
    }

}
