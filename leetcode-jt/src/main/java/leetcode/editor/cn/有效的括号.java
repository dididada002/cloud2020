package leetcode.editor.cn;

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串 
// 👍 2052 👎 0

import java.util.HashMap;
import java.util.Stack;

public class 有效的括号{
	public static void main(String[] args) {
		Solution solution = new 有效的括号().new Solution();
		System.out.println(solution.isValid(")("));
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
		s = s.replaceAll(" ", "");
		if (s.length() % 2 != 0){
			return false;
		}
		Stack<Character> cs = new Stack<>();
		//用来存括号
		HashMap<Character, Character> map = new HashMap<>();
		map.put('{', '}');
		map.put('(', ')');
		map.put('[', ']');
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))){
				//如果是左括号，不用对比，直接压栈
				cs.push(s.charAt(i));
			}else {
				//如果是右括号，进行对比。如果此时栈是空的，或者和栈顶的左括号不匹配，那么说明是错的
				if (cs.empty() || s.charAt(i) != map.get(cs.pop())){
					return false;
				}
			}
		}
		//如果遍历完后，栈不是空的，那么说明括号没有匹配完，字符串不合法
		return cs.empty();
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}