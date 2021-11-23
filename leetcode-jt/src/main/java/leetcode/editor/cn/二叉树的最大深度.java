package leetcode.editor.cn;

//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 1032 👎 0

public class 二叉树的最大深度{
	public static void main(String[] args) {
		Solution solution = new 二叉树的最大深度().new Solution();
		TreeNode rootNode41 = new TreeNode(4,null,null);
        TreeNode rootNode42 = new TreeNode(4,null,null);
        TreeNode rootNode31 = new TreeNode(3,rootNode41,rootNode42);
        TreeNode rootNode32 = new TreeNode(3,null,null);
        TreeNode rootNode21 = new TreeNode(2,rootNode31,rootNode32);
        TreeNode rootNode22 = new TreeNode(2,null,null);
        TreeNode rootNode = new TreeNode(9,rootNode21,rootNode22);
        System.out.println(solution.maxDepth(rootNode));
    }
//leetcode submit region begin(Prohibit modification and deletion)

// * Definition for a binary tree node.
  public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
class Solution {
    public int maxDepth(TreeNode root) {
        //返回这棵树的深度
        if (root == null){
            return 0;
        }
        return  1 + Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}