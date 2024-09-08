// https://leetcode.com/problems/split-linked-list-in-parts/description/?envType=daily-question&envId=2024-09-08


//   Definition for singly-linked list.
class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        int length = 0;
        ListNode temp = head;

        // Calculate the length of the linked list
        while (temp != null) {
            temp = temp.next;
            length++;
        }

        // Determine the size of each part
        int partLength = length / k;
        int extraNodes = length % k;

        temp = head;
        ListNode prev = null;
        for (int i = 0; i < k; i++) {
            ans[i] = temp;

            // Calculate the size of current part (distribute the extraNodes untill no extra
            // is left to maintain diff of 1)
            int currentPartSize = partLength + (0 < extraNodes ? 1 : 0);
            extraNodes--;

            // Move temp to the end of current part
            for (int j = 0; j < currentPartSize; j++) {
                prev = temp;
                temp = temp.next;
            }

            // Cut off the end of current part
            if (prev != null) {
                prev.next = null;
            }
        }

        return ans;
    }
}
