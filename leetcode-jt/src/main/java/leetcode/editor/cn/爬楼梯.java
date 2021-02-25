package leetcode.editor.cn;

//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划 
// 👍 1480 👎 0

public class 爬楼梯{
	public static void main(String[] args) {
		Solution solution = new 爬楼梯().new Solution();
		System.out.println(solution.climbStairs(4));
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int climbStairs(int n) {
		/**
		 * 第n曾的答案 = 第 n-1 层的答案 + 第 n-2 层的答案
		 * F(n) = F(n-1) + F(n-2)
		 * F(n-1) = F(n-2) + F(n-3)
		 * ....
		 * F(3) = F(2) + F(1)
		 * F(2) = 2
		 * F(1) = 1
		 *
		 */
		if (n == 1){
    		return 1;
		}
    	if (n == 2){
    		return 2;
		}
    	int a = 1;
    	int b = 2;
    	int temp = 0;
		for (int i = 3; i <= n; i++) {
			temp = a + b;
			a = b;
			b = temp;
		}
		return temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}