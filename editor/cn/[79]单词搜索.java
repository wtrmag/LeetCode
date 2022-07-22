//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"SEE"
//输出：true
// 
//
// 示例 3： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
//
// Related Topics 数组 回溯 矩阵 👍 1373 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    String w;
    StringBuilder sb;

    public boolean exist(char[][] board, String word) {
        w = word;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                sb = new StringBuilder();
                if (backtrack(board, sb, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, StringBuilder sb, int i, int j, int k) {
        if (sb.length() == w.length()) {
            return true;
        }
        if (i >= board.length || j >= board[0].length || i < 0 || j < 0) {
            return false;
        }
        if (board[i][j] == '/' || board[i][j] != w.charAt(k)) {
            return false;
        }

        char temp = board[i][j];
        sb.append(board[i][j]);
        board[i][j] = '/';
        boolean res = backtrack(board, sb, i + 1, j, k + 1) || backtrack(board, sb, i - 1, j, k + 1) ||
                backtrack(board, sb, i, j + 1, k + 1) || backtrack(board, sb, i , j - 1, k + 1);
        sb.deleteCharAt(sb.length() - 1);
        board[i][j] = temp;

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
