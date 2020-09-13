//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 345 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> tag = new Stack<>();

        TreeNode temp = root;
        while (null != temp || !stack.isEmpty()) {
            if (null != temp && tag.peek()==0) {
                stack.push(temp);
                tag.push(0);
                temp = temp.left;
            } else {
                temp = stack.peek();
                if (null != temp.right && tag.peek()==0) {
                    temp = temp.right;
                    stack.push(temp);
                    tag.push(1);
                } else {
                    temp = stack.pop();
                    tag.pop();
                    tag.pop();
                    tag.push(1);
                    list.add(temp.val);
                }
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
