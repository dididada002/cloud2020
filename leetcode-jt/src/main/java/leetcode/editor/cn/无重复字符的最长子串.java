package leetcode.editor.cn;

//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 4671 👎 0

import java.util.HashMap;
import java.util.Map;

public class 无重复字符的最长子串{
	public static void main(String[] args) {
		Solution solution = new 无重复字符的最长子串().new Solution();
		solution.lengthOfLongestSubstring("abcabcbb");
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
    	//先将字符放入map中
		//用双指针，指向当前无重复子串的头尾，遍历字符数组，如果重复，那么双指针的头指向重复字符的下一个下标，尾指向当前下标
		if (s.length() <= 1){
			return s.length();
		}
		int ans = 0;
		int ansTemp = 0;
		int firstIdx = 0;
		Map<Character, Integer> idxMap = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (idxMap.containsKey(s.charAt(i))){
				if (idxMap.get(s.charAt(i)) >= firstIdx){
					firstIdx = idxMap.get(s.charAt(i)) + 1;
				}
				ansTemp = i - firstIdx + 1;
			}else {
				ansTemp ++;
			}
			idxMap.put(s.charAt(i),i);
			if (ansTemp > ans){
				ans = ansTemp;
			}
		}
		return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}