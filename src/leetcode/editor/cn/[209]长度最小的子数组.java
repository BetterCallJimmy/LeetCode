package leetcode.editor.cn;
//给定一个含有 n 个正整数的数组和一个正整数 target 。 
//
// 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长
//度。如果不存在符合条件的子数组，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
// 
//
// 示例 2： 
//
// 
//输入：target = 4, nums = [1,4,4]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target <= 109 
// 1 <= nums.length <= 105 
// 1 <= nums[i] <= 105 
// 
//
// 
//
// 进阶： 
//
// 
// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。 
// 
// Related Topics 数组 二分查找 前缀和 滑动窗口 
// 👍 680 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //计算这个数组从i到j的和
    private int count(int i ,int j,int[] nums){
        int l = i;
        int r = j;
        int c = 0;
        while(l <= r){
            c = c + nums[l];
            l++;
        }
        return c;
    }
    public int minSubArrayLen(int target, int[] nums) {
        /*
        滑动窗口，即双指针
         */
        /*
        int i = 0;
        int j = 0;

        int result = 0;
        //当左指针超过右指针，右指针超出数组右边
        while(i <= j && j < nums.length){
            if(i == j && nums[i]>=target){
                return 1;
            }else if(count(i,j,nums) < target){
                j++;
            }else {
                if((j - i + 1) < result || result == 0 ){
                    result = j - i + 1;
                }
                i++;
            }
        }
        return result;

         */
        //滑动窗口
        int i = 0;
        int j = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for(j = 0;j<nums.length;j++){
            sum += nums[j];
            while(sum >= target){
                result = result>(j-i+1)?(j-i+1):result;
                //窗口缩小
                sum -= nums[i];
                i++;
            }
        }
        return result==Integer.MAX_VALUE?0:result;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
