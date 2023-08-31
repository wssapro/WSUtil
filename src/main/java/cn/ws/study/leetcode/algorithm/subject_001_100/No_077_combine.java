package cn.ws.study.leetcode.algorithm.subject_001_100;

import java.util.ArrayList;
import java.util.List;

/**
 * 77、组合
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * <p>
 * 你可以按 任何顺序 返回答案。
 */
public class No_077_combine {

    public static void main(String[] args) {
        List<List<Integer>> combine = new No_077_combine().combine(5, 3);
        System.out.println(combine);
    }

    public List<List<Integer>> list = new ArrayList<>();
    public List<Integer> step = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        combineHelper(n, k, 1);
        return list;
    }

    public void combineHelper(int n, int k, int start) {
        if (step.size() == k) {
            list.add(new ArrayList<>(step));
            return;
        }

        for (int i = start; i <= n && n - start + 1 >= k - step.size(); i++) {
            step.add(i);
            combineHelper(n, k, i + 1);
            step.remove(step.size() - 1);
        }
    }

}
