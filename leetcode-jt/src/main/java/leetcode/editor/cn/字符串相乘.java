package leetcode.editor.cn;

//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 示例 1: 
//
// 输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 说明： 
//
// 
// num1 和 num2 的长度小于110。 
// num1 和 num2 只包含数字 0-9。 
// num1 和 num2 均不以零开头，除非是数字 0 本身。 
// 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。 
// 
// Related Topics 数学 字符串 
// 👍 574 👎 0

public class 字符串相乘{
	public static void main(String[] args) {
		Solution solution = new 字符串相乘().new Solution();
		System.out.println(solution.multiply("123456789", "987654321"));
//		System.out.println(solution.multiplyPart("123", 4));
//		System.out.println(solution.plusNums("12", "9"));
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String multiply(String num1, String num2) {
    	//交换长短字符，保证nums1总是长的,降低复杂度
		if (num1.length() < num2.length()){
			String temp = num1;
			num1  = num2;
			num2 = temp;
		}
    	String ans = "0";
		String yinzi = "";
		for (int i = num2.length() - 1; i >= 0; i--) {
			int part = num2.charAt(i) - '0';
			String ansPart = multiplyPart(num1,part);
			ansPart = ansPart.concat(yinzi);
			ans = plusNums(ans,ansPart);
			yinzi = yinzi.concat("0");
		}
		return ans;
    }
    //合并两个字符串
    public String plusNums(String num1, String num2){
		StringBuilder sb = new StringBuilder();
		int temp = 0;
		int i = num1.length() - 1,j = num2.length() - 1;
		while (i >= 0 || j >= 0){
			if (i < 0){
				int numPart = num2.charAt(j) - '0';
				int sum = numPart + temp;
				temp = sum / 10;
				sb.append(sum % 10);
				j --;
				continue;
			}
			if (j < 0){
				int numPart = num1.charAt(i) - '0';
				int sum = numPart + temp;
				temp = sum / 10;
				sb.append(sum % 10);
				i --;
				continue;
			}
			int numPart1 = num1.charAt(i) - '0';
			int numPart2 = num2.charAt(j) - '0';
			int numPart = numPart1 + numPart2;
			int sum = numPart + temp;
			temp = sum / 10;
			sb.append(sum % 10);
			i --;
			j --;
		}
		if (temp != 0){
			sb.append(temp);
		}
		return sb.reverse().toString();
	}
	//将字符串乘以一个倍数
	public String multiplyPart(String num1,int part){
    	if (part == 0){
    		return "0";
		}
    	int temp = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = num1.length() - 1; i >= 0; i--) {
			int numPart = num1.charAt(i) - '0';
			int sum = numPart * part + temp;
			temp = sum / 10;
			int yushu = sum % 10;
			sb.append(yushu);
		}
		if (temp != 0){
			sb.append(temp);
		}
		sb.reverse();
		return sb.toString();
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}