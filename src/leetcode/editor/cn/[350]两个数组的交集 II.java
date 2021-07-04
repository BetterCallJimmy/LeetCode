package leetcode.editor.cn;
//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2,2]
// 
//
// 示例 2: 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[4,9] 
//
// 
//
// 说明： 
//
// 
// 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。 
// 我们可以不考虑输出结果的顺序。 
// 
//
// 进阶： 
//
// 
// 如果给定的数组已经排好序呢？你将如何优化你的算法？ 
// 如果 nums1 的大小比 nums2 小很多，哪种方法更优？ 
// 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？ 
// 
// Related Topics 数组 哈希表 双指针 二分查找 排序 
// 👍 511 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        //将任意一个数组映射为Map<值,出现次数>
        //用另一个数组去遍历这个Map，若有相同的Key，则将其出现次数减1.并将当前Key放入List，
        //若已为0则说明这Key出现次数的最小值，已经放入List了。后面再出现不要再放入List
        ArrayList<Integer> result = new ArrayList<>();
        Map map1 = new HashMap<Integer,Integer>();
        for(int i = 0;i < nums1.length;i++){
            int count = (int) map1.getOrDefault(nums1[i],0) + 1;

            map1.put(nums1[i],count);
        }

        for (int i : nums2) {
            if (map1.get(i) != null){
                Integer curCount = (Integer) map1.get(i);
                if (curCount == 0){
                    continue;
                }else {
                    map1.put(i,curCount - 1);
                    result.add(i);
                }

            }
        }
        int[] array = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            array[i] = result.get(i);
        }
        return array;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
