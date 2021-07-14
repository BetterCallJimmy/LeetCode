package leetcode.editor.cn;
//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3], target = 6
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 104 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 只会存在一个有效答案 
// 
//
// 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？ 
// Related Topics 数组 哈希表 
// 👍 11463 👎 0


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        /*
        先将nums映射位Map，index对应map的val
        再遍历map，map.get(i) - target，再看其差是否也在map中
         */
        int[] res = new int[2];
        HashMap map = new HashMap<Integer,Integer>();
        //将nums转成map，直接放在同一个循环中
//        for (int i = 0; i < nums.length; i++) {
//            //key对应的是nums的值，val对应是nums的index
//            map.put(nums[i],i);
//        }

        for (int i = 0; i < nums.length; i++) {
            //通过nums数组，获取要查找的key
            int val =  target - nums[i];
            Integer index = (Integer) map.get(val);
            //注意题目要求不能是同个index位置的数相加等于target
            if (index != null && i != index){
                res[0] = i;
                res[1] = index;
                return res;
            }
            //key对应的是nums的值，val对应是nums的index
            map.put(nums[i],i);
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
