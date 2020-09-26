//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 2446 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int low = 0, high = len-1;
        return findMaxSub(nums, low, high);
    }

    public int findMaxSub(int[] nums, int low, int high){
        if (low == high){
            return nums[low];
        }else {
            int mid = (low + high) / 2;
            int left = findMaxSub(nums, low, mid);
            int right = findMaxSub(nums, mid+1, high);
            int cross = findMaxCross(nums, low, mid, high);

            if (left >= right && left >= cross){
                return left;
            }else if(right >= left && right >= cross){
                return right;
            }else{
                return cross;
            }
        }
    }

    public int findMaxCross(int[] nums, int low, int mid, int high){
        int left = Integer.MIN_VALUE;
        int right = Integer.MIN_VALUE;
        int sum = 0;
//        int max_i = 0;
//        int max_j = 0;
        for (int i = mid; i >= low; i--) {
            sum += nums[i];
            if (sum > left){
                left = sum;
//                max_i = i;
            }
        }
        sum= 0;
        for (int j = mid+1; j <= high; j++) {
            sum += nums[j];
            if (sum > right){
                right = sum;
//                max_j = j;
            }
        }
        return left+right;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
