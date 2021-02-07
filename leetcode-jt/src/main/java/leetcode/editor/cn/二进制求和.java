package leetcode.editor.cn;

//给你两个二进制字符串，返回它们的和（用二进制表示）。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
// Related Topics 数学 字符串 
// 👍 544 👎 0

import java.text.ParseException;

public class 二进制求和{
	public static void main(String[] args) throws ParseException {
		Solution solution = new 二进制求和().new Solution();
		System.out.println(solution.addBinary("100", "110110"));
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
    	if ("0".equals(a)){
    		return b;
		}
    	if ("0".equals(b)){
    		return a;
		}
    	StringBuilder res = new StringBuilder();
    	int plus = 0;
		int lengtha = a.length();
		int lengthb = b.length();
		int maxIndex = Math.max(lengtha, lengthb);
    	for (int i = 0; i < maxIndex ; i ++){
    		if (i >= a.length() && plus == 0){
    			res.insert(0, b.substring(0,b.length() - i));
    			return res.toString();
			}else if (i >= b.length() && plus == 0){
				res.insert(0, a.substring(0,a.length() - i));
				return res.toString();
			}
			int aint = i >= a.length() ? 0 : Integer.parseInt(String.valueOf(a.charAt(a.length() -i - 1)));
			int bint = i >= b.length() ? 0 : Integer.parseInt(String.valueOf(b.charAt(b.length() -i - 1)));
			int sum = aint + bint + plus;
			int nowint = sum % 2;
			plus = sum / 2;
			res.insert(0,nowint);
		}
    	if (plus != 0){
    		res.insert(0,plus);
		}
    	return res.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}