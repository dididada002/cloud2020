package leetcode.editor.cn;

//给定一个二叉树，判断它是否是高度平衡的二叉树。 
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在范围 [0, 5000] 内 
// -104 <= Node.val <= 104 
// 
// Related Topics 树 深度优先搜索 二叉树 
// 👍 805 👎 0

public class 平衡二叉树{
	public static void main(String[] args) {
		Solution solution = new 平衡二叉树().new Solution();
        TreeNode rootNode41 = new TreeNode(4,null,null);
        TreeNode rootNode42 = new TreeNode(4,null,null);
        TreeNode rootNode31 = new TreeNode(3,rootNode41,rootNode42);
        TreeNode rootNode32 = new TreeNode(3,null,null);
        TreeNode rootNode21 = new TreeNode(2,rootNode31,rootNode32);
        TreeNode rootNode22 = new TreeNode(2,null,null);
        TreeNode rootNode = new TreeNode(9,rootNode21,rootNode22);
        System.out.println(solution.isBalanced(rootNode));
    }
//leetcode submit region begin(Prohibit modification and deletion)

//  Definition for a binary tree node.
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
    public boolean isBalanced(TreeNode root) {
        if (getDepthByTreeNode(root) == -1){
            return false;
        }
        return true;
    }
    int getDepthByTreeNode(TreeNode node){
        //如果左右不平衡，那么返回 -1
        if (node == null){
            return 0;
        }
        int leftDepth = getDepthByTreeNode(node.left);
        if (leftDepth == -1){
            return -1;
        }
        int rightDepth = getDepthByTreeNode(node.right);
        if (rightDepth == -1){
            return -1;
        }
        if (Math.abs(leftDepth - rightDepth) > 1){
            return -1;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public boolean isBalancedV2(TreeNode root) {
        if (root ==null){
            return true;
        }

        if(root.left!=null && root.right!=null){
            return isBalancedV2(root.left) && isBalancedV2(root.right);
        }

        if(root.left!=null){
            return isBalancedV2(root.left);
        }


        if(root.right!=null){
            return isBalancedV2(root.right);
        }

        return true;
    }





}
//leetcode submit region end(Prohibit modification and deletion)

}