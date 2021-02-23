package leetcode.editor.cn;

//给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = [1,2,3]
//输出：[1,2,4]
//解释：输入数组表示数字 123。
// 
//
// 示例 2： 
//
// 
//输入：digits = [4,3,2,1]
//输出：[4,3,2,2]
//解释：输入数组表示数字 4321。
// 
//
// 示例 3： 
//
// 
//输入：digits = [0]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= digits.length <= 100 
// 0 <= digits[i] <= 9 
// 
// Related Topics 数组 
// 👍 631 👎 0

public class 加一{
	public static void main(String[] args) {
		Solution solution = new 加一().new Solution();
		int[] ints = solution.plusOne(new int[]{0});
		System.out.println(ints.length);
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] plusOne(int[] digits) {
    	int temp = 0;
		int sum;
		digits[digits.length - 1] = digits[digits.length - 1] + 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			sum = digits[i] + temp;
			temp = sum / 10;
			digits[i] = sum % 10;
		}
		if (temp > 0){
			int[] res = new int[digits.length + 1];
			res[0] = temp;
			for (int i = 1; i < digits.length + 1; i++) {
				res[i] = digits[i - 1];
			}
			return res;
		}
		return digits;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}