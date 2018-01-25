package searching.tree;

/**
 * Create by hailong on 1/26/18.
 */

public class Problem100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val == q.val) return isSameTree(p.left, q.left);
        return false;
    }

    private class TreeNode {
        private int val;
        private TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // test
    public static void main(String[] args) {
        System.out.println(new Problem100().test());
    }

    private boolean test() {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(1);
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(1);
        q.right = new TreeNode(2);
        return isSameTree(p, q);
    }
}
