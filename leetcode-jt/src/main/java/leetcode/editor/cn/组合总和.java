package leetcode.editor.cn;

//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1： 
//
// 输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2： 
//
// 输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯算法 
// 👍 1153 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 组合总和{
	public static void main(String[] args) {
		Solution solution = new 组合总和().new Solution();
		int[] candidates = new int[]{2,7,6,3,5,1};
		List<List<Integer>> lists = solution.combinationSum(candidates, 9);
		System.out.println(lists);
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> resPart = new ArrayList<>();
		//首先对数组进行排序
		Arrays.sort(candidates);
		return getAllList(candidates, target,res,resPart,0);
    }

	private List<List<Integer>> getAllList(int[] candidates, int target, List<List<Integer>> res, List<Integer> resPart,int idx) {
		for (int i = idx; i < candidates.length; i++) {
			int candidate = candidates[i];
			//如果当前元素大于了目标值，说明当前方法已经找不到答案了，结束当前递归
			if (candidate > target){
				return res;
			}
			//如果当前元素等于目标值，说明这就是当前答案，加入答案数组中，结束递归
			if (candidate == target){
				List<Integer> ans = new ArrayList<>(resPart);
				ans.add(candidate);
				res.add(ans);
				return res;
			}
			//当前元素可能是答案，暂时算做答案的一部分，继续从当前下标递归
			resPart.add(candidate);
			getAllList(candidates,target - candidate,res,resPart,i);
			//当前元素递归完成，删除当前元素，继续下一元素
			resPart.remove(resPart.size() - 1);
		}
		return res;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}