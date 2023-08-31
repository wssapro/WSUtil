package cn.ws.study.leetcode.algorithm.subject_001_100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 * <p>
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class No_017_letterCombinations {

    public static void main(String[] args) {
        List<String> result = new No_017_letterCombinations().letterCombinations("");
        System.out.println(result);
    }

    List<String> list = new ArrayList<>();
    StringBuffer stringBuffer = new StringBuffer();

    public Map<Character, String> phoneMap = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        if (digits.length() > 0) {
            recursion(digits, 0);
        }
        return list;
    }


    public void recursion(String digits, int index) {
        if (stringBuffer.length() == digits.length()) {
            list.add(stringBuffer.toString());
            return;
        }
        String value = phoneMap.get(digits.charAt(index));

        for (int i = 0; i < value.length(); i++) {
            stringBuffer.append(value.charAt(i));
            recursion(digits, index + 1);
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
    }
}
