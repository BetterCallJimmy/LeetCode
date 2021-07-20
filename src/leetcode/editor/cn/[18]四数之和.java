package leetcode.editor.cn;
//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意：答案中不可以包含重复的四元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [], target = 0
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 200 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 
// Related Topics 数组 双指针 排序 
// 👍 898 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //[-2,-1,-1,1,1,2,2] 0
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            //若排序后的第一个都大于0，直接返回
//            if (nums[j] > target) {
//                return res;
//            }

            //保证不会出现重复的三元组
            //如[-4 -4 0 1 1 2 2 3 3]，若有重复把i移到最后出现的位置

            //[-2,-1,-1,1,1,2,2] 0  若直接移到最右边的-1，会漏调1组

            //保证不会出现重复的三元组
            // 错误去重方法，将会漏掉-1,-1,2 这种情况
            //在纸上写下就明白，（[-1，-1....]）i不能先移到最右边的-1，
            //这样后边的匹配次数会变少
            /*
            if (nums[i] == nums[i + 1]) {
                continue;
            }
            */
            if (j > 0 && nums[j] == nums[j - 1]) {
                continue;
            }

            int target2 = target - nums[j];

            for (int i = j  + 1; i < nums.length; i++) {
                //若排序后的第一个都大于0，直接返回
//                if (nums[i] > target2) {
//                    return res;
//                }

                //保证不会出现重复的三元组
                //保证不会出现重复的三元组
                // 错误去重方法，将会漏掉-1,-1,2 这种情况
                //在纸上写下就明白，（[-1，-1....]）i不能先移到最右边的-1，
                //这样后边的匹配次数会变少
            /*
            if (nums[i] == nums[i + 1]) {
                continue;
            }
            */
                if (i > 1 + j && nums[i] == nums[i - 1]) {
                    continue;
                }

                int left = i + 1;
                int right = nums.length - 1;

                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum < target2) {
                        left++;
                    } else if (sum > target2) {
                        right--;
                    } else {
                        ArrayList<Integer> numList = new ArrayList<>();
                        numList.add(nums[j]);
                        numList.add(nums[i]);
                        numList.add(nums[left]);
                        numList.add(nums[right]);
                        res.add(numList);
                        //保证不会出现重复的三元组
                        //如[-4 0 1 1 2 2 3 3]
                        //当找到[-4 1 3]后让left移到下一位（且不为1），right同理
                        while (right > left && nums[right] == nums[right - 1]) right--;
                        while (right > left && nums[left] == nums[left + 1]) left++;

                        right--;
                        left++;
                    }
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
