package leetcode.editor.cn;

//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：head = [0,1,2], k = 4
//输出：[2,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 500] 内 
// -100 <= Node.val <= 100 
// 0 <= k <= 2  109 
// 
// Related Topics 链表 双指针 
// 👍 655 👎 0

import java.util.HashMap;
import java.util.Map;

public class 旋转链表{
	public static void main(String[] args) {
//		System.out.println( 5 - 5%5);
		Solution solution = new 旋转链表().new Solution();
		ListNode listNode5 = new ListNode(5);
		ListNode listNode4 = new ListNode(4,listNode5);
		ListNode listNode3 = new ListNode(3,listNode4);
		ListNode listNode2 = new ListNode(2,listNode3);
		ListNode listNode1 = new ListNode(1,listNode2);
		ListNode listNode = solution.rotateRight(listNode1, 2);
		System.out.println("123");
	}
//leetcode submit region begin(Prohibit modification and deletion)
//  Definition for singly-linked list.
  public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
		//首先需要返回头节点
		//其次，需要把旋转之后的链表进行前后节点的连接，旋转之后的头尾节点断开
		if (head == null || head.next == null || k == 0){
			return head;
		}

		//1、将链表根据下标放入map中
		Map<Integer, ListNode> indexMap = new HashMap<>();
		int index = 0;
		while (head != null){
			indexMap.put(index, head);
			if (head.next == null){
				break;
			}
			head = head.next;
			index ++;
		}
		//2、进行处理
		//2.1 获取旋转后的头节点
		ListNode headBeforeNode = indexMap.get(0);
		if (k % indexMap.size() != 0){
			ListNode tailBeforeNode = indexMap.get(indexMap.size() - 1);
			tailBeforeNode.next = headBeforeNode;
			ListNode resultNode = indexMap.get((indexMap.size() - (k % indexMap.size())) % indexMap.size());
			ListNode resultNodeBefore1 = indexMap.get((indexMap.size() - ((k + 1) % indexMap.size())) % indexMap.size());
			resultNodeBefore1.next = null;
			return resultNode;
		}
		return headBeforeNode;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}