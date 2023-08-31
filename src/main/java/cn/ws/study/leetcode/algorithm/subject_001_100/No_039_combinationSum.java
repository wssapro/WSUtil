package cn.ws.study.leetcode.algorithm.subject_001_100;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. 组合总和
 * 给你一个 无重复元素 的整数数组candidates 和一个目标整数target，
 * 找出candidates中可以使数字和为目标数target 的 所有不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * 对于给定的输入，保证和为target 的不同组合数少于 150 个。
 */
public class No_039_combinationSum {

    public static void main(String[] args) {
        int[] candidates = new int[]{3, 4, 5,6};
        List<List<Integer>> list = new No_039_combinationSum().combinationSum(candidates, 10);
        System.out.println(list);
    }

    public List<List<Integer>> list = new ArrayList<>();
    public List<Integer> step = new ArrayList<>();
    public int sum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        sum = target;
        recursion(candidates, target);
        return list;
    }

    public void recursion(int[] candidates, int target) {
        if (sum < 0) {
            return;
        }
        if (sum == 0) {
            list.add(new ArrayList<>(step));
            return;
        }

        for (int i = 0; i < candidates.length; i++) {
            sum -= candidates[i];
            step.add(candidates[i]);
            recursion(candidates, target - candidates[i]);
            sum += candidates[i];
            step.remove(step.size()-1);
        }




    }
}
