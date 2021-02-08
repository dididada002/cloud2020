package leetcode.editor.cn;

//判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
// 
//
// 
//
// 上图是一个部分填充的有效的数独。 
//
// 数独部分空格内已填入了数字，空白格用 '.' 表示。 
//
// 示例 1: 
//
// 输入:
//[
//  ["5","3",".",".","7",".",".",".","."],
//  ["6",".",".","1","9","5",".",".","."],
//  [".","9","8",".",".",".",".","6","."],
//  ["8",".",".",".","6",".",".",".","3"],
//  ["4",".",".","8",".","3",".",".","1"],
//  ["7",".",".",".","2",".",".",".","6"],
//  [".","6",".",".",".",".","2","8","."],
//  [".",".",".","4","1","9",".",".","5"],
//  [".",".",".",".","8",".",".","7","9"]
//]
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//[
//  ["8","3",".",".","7",".",".",".","."],
//  ["6",".",".","1","9","5",".",".","."],
//  [".","9","8",".",".",".",".","6","."],
//  ["8",".",".",".","6",".",".",".","3"],
//  ["4",".",".","8",".","3",".",".","1"],
//  ["7",".",".",".","2",".",".",".","6"],
//  [".","6",".",".",".",".","2","8","."],
//  [".",".",".","4","1","9",".",".","5"],
//  [".",".",".",".","8",".",".","7","9"]
//]
//输出: false
//解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
//     但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。 
//
// 说明: 
//
// 
// 一个有效的数独（部分已被填充）不一定是可解的。 
// 只需要根据以上规则，验证已经填入的数字是否有效即可。 
// 给定数独序列只包含数字 1-9 和字符 '.' 。 
// 给定数独永远是 9x9 形式的。 
// 
// Related Topics 哈希表 
// 👍 466 👎 0

import java.util.Arrays;

public class 有效的数独{
	public static void main(String[] args) {
		char[][] board = new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
		Solution solution = new 有效的数独().new Solution();
		System.out.println(solution.isValidSudoku(board));
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValidSudoku(char[][] board) {
    	//1 检查每行
		for (int i = 0; i < board.length; i++) {
			char[] chars = board[i];
			boolean onlyOne = checkIfOne(chars);
			if (!onlyOne){
				return false;
			}
		}
		//2 检查每列
		for (int i = 0; i < board.length; i++) {
			char[] chars = new char[9];
			for (int j = 0; j < 9; j++) {
				chars[j] = board[j][i];
			}
			boolean onlyOne = checkIfOne(chars);
			if (!onlyOne){
				return false;
			}
		}
		//3 检查9个三宫格
		boolean onlyOne = checkThree(0,0,board);
		if (!onlyOne){
			return false;
		}
		return true;
    }

	private boolean checkThree(int i, int j,char[][] board) {
    	//如果到达最后一个三宫格，那么说明已经验证完成，说明是有效的
    	if (i == 6 && j == 9){
    		return true;
		}
    	//如果到了每行的最后一个三宫格，向下移动
    	if (j == 9){
			return checkThree(i + 3,0,board);
		}
		char[] nums = new char[9];
    	int idx = 0;
    	//取出三宫格的没个数
		for (int k = i; k < i+3; k++) {
			for (int l = j; l < j+3; l++) {
				nums[idx] = board[k][l];
				idx ++;
			}
		}
		boolean checkIfOne = checkIfOne(nums);
		if (checkIfOne){
			//向右移动三宫格
			return checkThree(i,j+3,board);
		}
		return false;
	}

	//检查数组中是否有重复数字
	public boolean checkIfOne(char[] num){
		char[] nums = new char[9];
		for (int i = 0; i <num.length; i++) {
			nums[i] = num[i];
		}
    	Arrays.sort(nums);
		for (int i = 1; i < nums.length; i++) {
			if ('.' != nums[i] && nums[i] == nums[i -1]){
				return false;
			}
		}
		return true;
	}


}
//leetcode submit region end(Prohibit modification and deletion)

}