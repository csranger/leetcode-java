package fundanmentals.linkedList;

/**
 * Create by hailong on 1/16/18.
 */

public class Problem21 {
    // 方法1
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode c1 = l1, c2 = l2;
        ListNode sentinel = new ListNode(0);
        ListNode cursor = sentinel;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                cursor.next = l2;
                break;
            } else if (l2 == null) {
                cursor.next = l1;
                break;
            } else if (l1.val < l2.val) {
                cursor.next = l1;
                l1 = l1.next;
                cursor = cursor.next;
            } else {
                cursor.next = l2;
                l2 = l2.next;
                cursor = cursor.next;
            }
        }
        return sentinel.next;
    }

    // 方法2：使用递归
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
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
        ListNode l3 = mergeTwoLists2(l1, l2);
        System.out.println("方法2");
        for (ListNode cursor = l3; cursor != null; cursor = cursor.next) {
            System.out.print(cursor.val);
            if (cursor.next != null) System.out.print(" -> ");
        }
    }
}
