import com.alibaba.fastjson.JSON;

import javax.swing.plaf.BorderUIResource;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: TODO 此题没有解出来，看答案的，好好消化
 * @author: terui
 * @date: 2019/9/8 8:08 下午
 */
public class ListNodeSum {
    public static class ListNode {
        int      val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * <p>
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * <p>
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p>
     * 示例：
     * <p>
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     * 在真实的面试中遇到过这道题？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);

        ListNode p = l1;
        ListNode q = l2;
        ListNode curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = p != null ? p.val : 0;
            int y = q != null ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(9);
        a1.next = new ListNode(2);

        a1.next.next = new ListNode(3);

        a1.next.next.next = new ListNode(1);

        ListNode b1 = new ListNode(3);
        b1.next = new ListNode(8);


        ListNode result = new ListNodeSum().addTwoNumbers(a1, b1);
        System.out.println(JSON.toJSONString(result));

    }
}
