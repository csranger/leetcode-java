package fundanmentals.linkedList;

/**
 * Create by hailong on 1/17/18.
 */

public class Problem83 {
    // 方法1
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cursor = head;
        while (cursor != null && cursor.next != null) {
            if (cursor.val == cursor.next.val) cursor.next = cursor.next.next;
            else cursor = cursor.next;
        }
        return head;
    }

    // 方法2 递归方法  O(n) space stack overflow        tree 中经常用到，只是那里是O(log(n)) space
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) return head;
        head.next = deleteDuplicates2(head.next);
        if (head.next.val == head.val) return head.next;
        return head;
    }

    private class ListNode {
        private ListNode next;
        private int val;

        public ListNode(int val) {
            this.val = val;
        }
    }

    // test
    public static void main(String[] args) {
        new Problem83().test();
    }

    private void test() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(2);
        ListNode l2 = deleteDuplicates2(l1);
        for (ListNode cursor = l2; cursor != null; cursor = cursor.next) {
            System.out.print(cursor.val);
            if (cursor.next != null) System.out.print(" -> ");
        }
    }
}
