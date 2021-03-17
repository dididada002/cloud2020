package leetcode.editor.cn;

//给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。 
//
// 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下： 
//
// 
// "123" 
// "132" 
// "213" 
// "231" 
// "312" 
// "321" 
// 
//
// 给定 n 和 k，返回第 k 个排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3, k = 3
//输出："213"
// 
//
// 示例 2： 
//
// 
//输入：n = 4, k = 9
//输出："2314"
// 
//
// 示例 3： 
//
// 
//输入：n = 3, k = 1
//输出："123"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 1 <= k <= n! 
// 
// Related Topics 数学 回溯算法 
// 👍 492 👎 0

import java.util.ArrayList;
import java.util.List;

public class 排列序列{
	public static void main(String[] args) {
		Solution solution = new 排列序列().new Solution();
		System.out.println(solution.getPermutation(3, 1));
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String getPermutationPart(int n, int k,List<Integer> intList) {
    	if (n == 0){
    		return "";
		}
    	//先求出 (n-1)!
		int jiShu = 1;
		for (int i = 1; i < n; i++) {
			jiShu *= i;
		}
		int xuShu = k / jiShu;
		Integer idx = intList.get(xuShu);
		intList.remove(xuShu);
		return idx + getPermutationPart(n - 1,k % jiShu,intList);
    }

	public String getPermutation(int n, int k) {
		List<Integer> intList = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			intList.add(i);
		}
		return getPermutationPart(n,k-1,intList);
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}