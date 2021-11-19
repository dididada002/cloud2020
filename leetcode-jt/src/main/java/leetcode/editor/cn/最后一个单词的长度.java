package leetcode.editor.cn;

//给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中最后一个单词的长度。 
//
// 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "Hello World"
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：s = "   fly me   to   the moon  "
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：s = "luffy is still joyboy"
//输出：6
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅有英文字母和空格 ' ' 组成 
// s 中至少存在一个单词 
// 
// Related Topics 字符串 
// 👍 396 👎 0

public class 最后一个单词的长度{
	public static void main(String[] args) {
		Solution solution = new 最后一个单词的长度().new Solution();
		System.out.println(solution.lengthOfLastWord("abc  abc  "));
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLastWord(String s) {
    	//1、简便做法
		/*String[] s1 = s.split(" ");
		return s1[s1.length -1].length();*/
		//2、滑动窗口，把每一个空格都当作最后一个空格，如果检查到不是最后一个，那么重新计算长度
		/*int result = 0;
		boolean ifKong = true;
		for (int i = 0; i < s.length(); i++) {
			char charI = s.charAt(i);
			if (charI == ' '){
				ifKong = true;
			}else {
				if (ifKong){
					result = 1;
				}else {
					result += 1;
				}
				ifKong = false;
			}
		}
		return result;*/
		//3、从后往前遍历（对2的改进）
		int result = 0;
		boolean ifKong = true;
		for (int i = s.length() - 1; i >= 0; i--) {
			char charI = s.charAt(i);
			if (charI == ' '){
				if (!ifKong){
					return result;
				}
			}else {
				ifKong = false;
				result += 1;
			}
		}
		return result;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}