package leetcode.editor.cn;

//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学 
// 👍 5340 👎 0

public class 两数相加{
	public static void main(String[] args) {
		Solution solution = new 两数相加().new Solution();
	}

	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
//leetcode submit region begin(Prohibit modification and deletion)
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
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = null , tail = null;//链表的头和尾节点，头节点不动,用于输出结果，尾节点不断往后移动
		int carry = 0;//低位相加后是否进位
		while (l1 != null || l2 != null){
			int n1 = l1 == null ? 0 : l1.val;
			int n2 = l2 == null ? 0 : l2.val;
			int sum = n1 + n2 + carry;//当前位的和
			if (head == null){//初始化头和尾节点
				head = tail = new ListNode(sum % 10);
			}else {//尾节点后面加一个节点：先在尾节点后加一个节点，再将尾节点后移
				tail.next = new ListNode(sum % 10);
				tail = tail.next;
			}
			carry = sum / 10;
			if (l1 != null){
				l1 = l1.next;
			}
			if (l2 != null){
				l2 = l2.next;
			}
		}
		if (carry > 0){
			tail.next = new ListNode(1);
		}
		return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}