package leetcode.editor.cn;

//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表 
// 👍 1446 👎 0

public class 合并两个有序链表{
	public static void main(String[] args) {
		Solution solution = new 合并两个有序链表().new Solution();
		
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode res;
		if (l1 == null && l2 == null){
			//如果 l1 和 l2 都为空，那么直接返回空，结束递归
			return null;
		}else if (l1 != null && l2 == null){
			//如果 l1 不为空，但是 l2 为空，那么不用考虑l2，答案就是 l1，并且l1往后移一位
			res = l1;
			l1 = l1.next;
		}else if (l1 == null && l2 != null){
			//l2同理
			res = l2;
			l2 = l2.next;
		}else {
			//如果l1 和 l2 都不为空，那么就进行比较
			if (l1.val > l2.val){
				//如果l1的值比较大，那么l2就是答案，往后移一位
				res = l2;
				l2 = l2.next;
			}else {
				//l2同理
				res = l1;
				l1 = l1.next;
			}
		}
		//进行到这一步，说明答案已经找到了，但是还要找当前位置的下一位置的答案，递归
		res.next = mergeTwoLists(l1,l2);
		return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}