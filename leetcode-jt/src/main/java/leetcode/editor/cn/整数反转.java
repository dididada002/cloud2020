package leetcode.editor.cn;

//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 
//
// 示例 1: 
//
// 输入: 123
//输出: 321
// 
//
// 示例 2: 
//
// 输入: -123
//输出: -321
// 
//
// 示例 3: 
//
// 输入: 120
//输出: 21
// 
//
// 注意: 
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。 
// Related Topics 数学 
// 👍 2396 👎 0

public class 整数反转{
	public static void main(String[] args) {
		Solution solution = new 整数反转().new Solution();
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
//		System.out.println(solution.reverse(123));
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
    	//先提取符号
		int reverseFlag = x > 0 ? 1 : -1;
		x = x / reverseFlag;
		//再反转
		int result = 0;
		int baseFlag = Integer.MAX_VALUE / 10;
		while ( x > 0){
			int i = x - (x / 10) * 10;
			//判断是否超范围 *********如何判断溢出（看了答案）************
			/**
			 * 在将结果进位之前，先判断是否能进位：判断是不是大于了  【Integer.MAX_VALUE / 10】
			 * 再判断进位后是不是溢出了，负数的最后一位不能超过8，正数的最后一位不能超过7
			 */
			if (result > baseFlag){
				return 0;
			}else if (result == baseFlag){
				if (reverseFlag > 0 && i > 7){
					return 0;
				}
				if (reverseFlag < 0 && i > 8){
					return 0;
				}
			}
			result = result * 10 + i;
			x = x/10;
		}
		result = result * reverseFlag;
		return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}