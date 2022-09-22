//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 👍 2759 👎 0


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    ArrayList<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        dfs(n, n, sb);
        return res;
    }

    public void dfs(int l, int r, StringBuilder sb) {
        if (l < 0 || r < 0 || l > r) {
            return;
        }
        if (l == 0 && r == 0) {
            res.add(sb.toString());
            return;
        }

        sb.append("(");
        dfs(l - 1, r, sb);
        sb.deleteCharAt(sb.length() - 1);

        sb.append(")");
        dfs(l, r - 1, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
