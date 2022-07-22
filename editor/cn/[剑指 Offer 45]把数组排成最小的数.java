//输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。 
//
// 
//
// 示例 1: 
//
// 输入: [10,2]
//输出: "102" 
//
// 示例 2: 
//
// 输入: [3,30,34,5,9]
//输出: "3033459" 
//
// 
//
// 提示: 
//
// 
// 0 < nums.length <= 100 
// 
//
// 说明: 
//
// 
// 输出结果可能非常大，所以你需要返回一个字符串而不是整数 
// 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0 
// 
// Related Topics 贪心 字符串 排序 👍 496 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minNumber(int[] nums) {
        int n = nums.length;
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
//        quickSort(strings, 0, n - 1);
        Arrays.sort(strings, (x, y) -> (x+y).compareTo(y+x));
        StringBuilder sb = new StringBuilder();
        for (String str : strings) {
            sb.append(str);
        }
        return sb.toString();
    }

//    public void quickSort(String[] nums, int left, int right) {
//        if (left >= right) {
//            return;
//        }
//        int pivot = partition(nums, 0, nums.length - 1);
//        quickSort(nums, 0, pivot - 1);
//        quickSort(nums, pivot + 1, nums.length - 1);
//    }
//
//    public int partition(String[] nums, int left, int right) {
//        int pivot = left;
//        while (left < right) {
//            while (left < right && (nums[left] + nums[pivot]).compareTo(nums[pivot] + nums[left]) < 0) {
//                left++;
//            }
//            while (left < right && (nums[right] + nums[pivot]).compareTo(nums[pivot] + nums[right]) >= 0) {
//                right--;
//            }
//            if (left < right) {
//                String temp = nums[left];
//                nums[left] = nums[right];
//                nums[right] = temp;
//            }
//        }
//        nums[right] = nums[pivot];
//        return right;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
