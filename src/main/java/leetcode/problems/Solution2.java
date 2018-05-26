package leetcode.problems;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
public class Solution2 {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode ls = new ListNode(-1);
		ListNode lr = ls;
		int z = 0, y = 0;
		while (l1 != null || l2 != null || z > 0) {
			int n1 = -1, n2 = -1;
			if (l1 != null) {
				n1 = l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				n2 = l2.val;
				l2 = l2.next;
			}
			if (n1 < 0 && n2 >= 0) {
				y = (n2 + z) % 10;
				lr.next = new ListNode(y);
				lr = lr.next;
				z = (n2 + z) / 10;
				continue;
			}
			if (n2 < 0 && n1 >= 0) {
				y = (n1 + z) % 10;
				lr.next = new ListNode(y);
				lr = lr.next;
				z = (n1 + z) / 10;
				continue;
			}
			if (n1 >= 0 && n2 >= 0) {
				y = (n1 + n2 + z) % 10;
				lr.next = new ListNode(y);
				lr = lr.next;
				z = (n1 + n2 + z) / 10;
				continue;
			}
			lr.next = new ListNode(z);
			lr = lr.next;
			z = 0;
		}
		return ls.next;

	}
}
