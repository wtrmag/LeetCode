//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: 3 
//
// 示例 2: 
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
// 
// Related Topics 位运算 数组 分治算法 
// 👍 746 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public int majorityElement(int[] nums) {
//        Map<Integer, Integer> hashMap = new HashMap<>();
//        for (int num : nums) {
//            if (hashMap.containsKey(num)) {
//                hashMap.put(num, hashMap.get(num) + 1);
//            }else {
//                hashMap.put(num, 1);
//            }
//        }
//        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()){
//            if (entry.getValue() > nums.length / 2){
//                return entry.getKey();
//            }
//        }
//        return -1;
//    }
//}
class Solution {
    public int majorityElement(int[] nums) {
        return find(nums, 0, nums.length - 1);
    }

    public int find(int[] nums, int low, int high){
        if(low == high){
            return nums[low];
        }
        int mid = (low + high) / 2;
        int left = find(nums, low, mid);
        int right = find(nums, mid + 1, high);

        if (left == right){
            return left;
        }

        int left_count = getCount(nums, low, left, high);
        int right_count = getCount(nums, low, right, high);
        return left_count>right_count?left:right;
    }

    public int getCount(int[] nums, int low, int num, int high){
        int count = 0;
        for (int i = low; i <= high; i++) {
            if (nums[i] == num){
                count++;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
