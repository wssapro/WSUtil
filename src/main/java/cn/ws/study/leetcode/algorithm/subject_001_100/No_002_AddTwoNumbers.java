package cn.ws.study.leetcode.algorithm.subject_001_100;

/**
 * 2. 两数相加
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class No_002_AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode root = new ListNode(0);
        ListNode pointer = root;
        boolean carry = false;
        while (l1 != null || l2 != null || carry) {
            if (l1 == null) {
                l1 = new ListNode(0);
            }
            if (l2 == null) {
                l2 = new ListNode(0);
            }
            int sum = l1.val + l2.val;
            if (carry) {
                sum++;
            }
            pointer.next = new ListNode(sum % 10);
            pointer = pointer.next;
            carry = sum > 9 ? true : false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return root.next;
    }
}
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
