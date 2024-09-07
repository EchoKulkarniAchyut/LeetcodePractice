// https://leetcode.com/problems/linked-list-in-binary-tree/?envType=daily-question&envId=2024-09-07

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null && head != null) {
            return false;
        }
        return preOrder(head, root);
    }

    public boolean preOrder(ListNode head, TreeNode root) {
        if (root == null) {
            return false;
        }
        boolean ans = false;
        if (head.val == root.val) {
            ListNode h = head;
            TreeNode r = root;
            ans = ans || ifPathExists(h, r);
        }
        ans = ans || preOrder(head, root.left);
        ans = ans || preOrder(head, root.right);

        return ans;
    }

    public boolean ifPathExists(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        } else if (root == null) {
            return false;
        } else if (head.val != root.val) {
            return false;
        } else {
            return ifPathExists(head.next, root.left) || ifPathExists(head.next, root.right);
        }
    }
}
