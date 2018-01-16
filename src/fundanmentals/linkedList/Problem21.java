package fundanmentals.linkedList;

/**
 * Create by hailong on 1/16/18.
 */

public class Problem21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode c1 = l1, c2 = l2;
        ListNode sentinel = new ListNode(0);
        ListNode cursor = sentinel;
        while (c1 != null || c2 != null) {
            if (l1 == null) {
                cursor.next = c2;
                break;
            } else if (c2 == null) {
                cursor.next = c1;
                break;
            } else if (c1.val < c2.val) {
                cursor.next = c1;
                c1 = c1.next;
                cursor = cursor.next;
            } else {
                cursor.next = c2;
                c2 = c2.next;
                cursor = cursor.next;
            }
        }
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
        new Problem21().test();
    }

    private void test() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode l3 = mergeTwoLists(l1, l2);
        for (ListNode cursor = l3; cursor != null; cursor = cursor.next) {
            System.out.print(cursor.val);
            if (cursor.next != null) System.out.print(" -> ");
        }
    }
}
