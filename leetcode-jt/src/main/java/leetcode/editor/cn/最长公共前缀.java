package leetcode.editor.cn;

//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串 
// 👍 1386 👎 0

public class 最长公共前缀{
	public static void main(String[] args) {
		Solution solution = new 最长公共前缀().new Solution();
		String[] strs = new String[]{"dog","racecar","car"};
		System.out.println(solution.longestCommonPrefix(strs));

	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	/**
	 * 遍历数组中的全部字符串（按照下标同时遍历，如果数组中的元素的该下标的字符全都一样，就往后移动下标，知道遇到不同的字符，或者有一个元素遍历到头了）
	 * @param strs
	 * @return
	 */
    public String longestCommonPrefix(String[] strs) {
    	String res = "";
		if (strs.length == 0){
			return res;
		}
    	int index = 0;
		while (true){
			if (strs[0].length() == index){
				return res;
			}
			char charI = strs[0].charAt(index);
			for (String str : strs) {
				if (index == str.length()){
					return res;
				}
				if (charI != str.charAt(index)){
					return res;
				}
			}
			res = res.concat(String.valueOf(charI));
			index ++;
		}
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}