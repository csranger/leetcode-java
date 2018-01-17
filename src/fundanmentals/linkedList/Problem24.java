package fundanmentals.linkedList;

/**
 * Create by hailong on 1/17/18.
 */

public class Problem24 {
    // 方法1
    public ListNode swapPairs(ListNode head) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode cursor = sentinel;
        while (cursor.next != null && cursor.next.next != null) {
            ListNode first = cursor.next;
            ListNode second = cursor.next.next;
            cursor.next = second;
            first.next = second.next;
            second.next = first;
            cursor = cursor.next.next;
        }
        return sentinel.next;
    }

    // 方法2 elegant 使用递归 O(n) space
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode temp = head.next;
        head.next = swapPairs2(temp.next);
        temp.next = head;
        return temp;
    }

    private class ListNode {
        private ListNode next;
        private int val;

        public ListNode(int val) {
            this.val = val;
        }
    }

    // 测试
    public static void main(String[] args) {
        new Problem24().test();
    }

    private void test() {
        ListNode l1 = new ListNode(1);
        ListNode current = l1;
        for (int i = 2; i < 5; i++) {
            current.next = new ListNode(i);
            current = current.next;
        }
        ListNode l2 = swapPairs2(l1);
        for (ListNode cursor = l2; cursor != null; cursor = cursor.next) {
            System.out.print(cursor.val);
            if (cursor.next != null) System.out.print(" -> ");
        }
    }

}
