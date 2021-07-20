package leetcode.editor.cn;
//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 排序 
// 👍 3503 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            //若排序后的第一个都大于0，直接返回
            if (nums[i] > 0){return res;}

            //保证不会出现重复的三元组
            // 错误去重方法，将会漏掉-1,-1,2 这种情况
            //在纸上写下就明白，（[-1，-1....]）i不能先移到最右边的-1，
            //这样后边的匹配次数会变少
            /*
            if (nums[i] == nums[i + 1]) {
                continue;
            }
            */
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0){
                    left++;
                }else if(sum > 0){
                    right--;
                }else {
                    ArrayList<Integer> numList = new ArrayList<>();
                    numList.add(nums[i]);
                    numList.add(nums[left]);
                    numList.add(nums[right]);
                    res.add(numList);
                    //保证不会出现重复的三元组
                    //如[-4 0 1 1 2 2 3 3]
                    //当找到[-4 1 3]后让left移到下一位（且不为1），right同理
                    //且不能放到上面2个if判断中
                    while (right > left && nums[right] == nums[right - 1]) right--;
                    while (right > left && nums[left] == nums[left + 1]) left++;

                    right--;
                    left++;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
