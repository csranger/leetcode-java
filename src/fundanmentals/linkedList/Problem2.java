package fundanmentals.linkedList;

/**
 * Create by hailong on 1/16/18.
 */

public class Problem2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(0);    // ListNode c1 = l1, c2 = l2; 变量存的是指针
        ListNode cursor = sentinel;
        int sum = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            cursor.next = new ListNode(sum % 10);
            cursor = cursor.next;
            sum = sum / 10;
        }
        if (sum != 0) cursor.next = new ListNode(sum);
        return sentinel.next;
    }

    private class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    // test
    public static void main(String[] args) {
        new Problem2().test();
    }

    private void test() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode l3 = addTwoNumbers(l1, l2);
        for (ListNode cursor = l3; cursor != null; cursor = cursor.next) {
            System.out.print(cursor.val);
            if (cursor.next != null) System.out.print(" -> ");
        }
    }
}
