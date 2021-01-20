package leetcode.editor.cn;

//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组 
// 👍 440 👎 0

import java.util.ArrayList;
import java.util.List;

public class 杨辉三角{
	public static void main(String[] args) {
		Solution solution = new 杨辉三角().new Solution();
		solution.generate(5);
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> res = new ArrayList<>();
		if (numRows < 1){
			return res;
		}
		List<Integer> resOne = new ArrayList<>();
		resOne.add(1);
		res.add(resOne);
		for (int i = 1; i < numRows; i++) {
			List<Integer> resPart = getNextListByPreList(res.get(i - 1));
			res.add(resPart);
		}
		return res;
    }

    //根据前一行的数组，组建一个符合条件的数组
	private List<Integer> getNextListByPreList(List<Integer> listPart) {
		int leftNum = 0;
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < listPart.size(); i++) {
			Integer idxImt = listPart.get(i);
			res.add(leftNum + idxImt);
			leftNum = idxImt;
		}
		res.add(listPart.get(listPart.size() - 1));
		return res;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}