package fundanmentals.linkedList;

/**
 * Create by hailong on 1/17/18.
 */

public class Problem19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode cursor = sentinel, pos = sentinel;
        for (int i = 0; i < n; i++) cursor = cursor.next;
        while (cursor.next != null) {
            cursor = cursor.next;
            pos = pos.next;
        }
        pos.next = pos.next.next;
        return sentinel.next;
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
        new Problem19().test();
    }

    private void test() {
        ListNode l1 = new ListNode(1);
        ListNode cursor1 = l1;
        for (int i = 2; i <= 5; i++) {
            cursor1.next = new ListNode(i);
            cursor1 = cursor1.next;
        }
        removeNthFromEnd(l1, 2);
        for (ListNode cursor = l1; cursor != null; cursor = cursor.next) {
            System.out.print(cursor.val);
            if (cursor.next != null) System.out.print(" -> ");
        }
    }
}
