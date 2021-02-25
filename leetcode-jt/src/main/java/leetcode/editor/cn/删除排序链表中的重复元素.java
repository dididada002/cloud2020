package leetcode.editor.cn;

//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。 
//
// 示例 1: 
//
// 输入: 1->1->2
//输出: 1->2
// 
//
// 示例 2: 
//
// 输入: 1->1->2->3->3
//输出: 1->2->3 
// Related Topics 链表 
// 👍 476 👎 0

public class 删除排序链表中的重复元素{
	public static void main(String[] args) {

		Solution solution = new 删除排序链表中的重复元素().new Solution();
	}
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.*/
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
    	ListNode temp = head;
    	while (temp != null && temp.next != null){
    		if (temp.val == temp.next.val){
    			temp.next = temp.next.next;
			}else {
    			temp = temp.next;
			}
		}
		return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}