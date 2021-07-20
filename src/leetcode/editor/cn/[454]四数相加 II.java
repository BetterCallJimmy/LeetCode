package leetcode.editor.cn;
//给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[
//l] = 0。 
//
// 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最
//终结果不会超过 231 - 1 。 
//
// 例如: 
//
// 
//输入:
//A = [ 1, 2]
//B = [-2,-1]
//C = [-1, 2]
//D = [ 0, 2]
//
//输出:
//2
//
//解释:
//两个元组如下:
//1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
//2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
// 
// Related Topics 数组 哈希表 
// 👍 385 👎 0


import org.omg.CORBA.INTERNAL;

import java.util.HashMap;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        //映射nums1[]  nums2[]各个数相加  <和,出现次数>
        HashMap<Integer, Integer> mapA = new HashMap<>();
        HashMap<Integer, Integer> mapB = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            for (int i1 = 0; i1 < nums2.length; i1++) {
                int sumA = nums1[i] + nums2[i1];
                Integer newFrequencyA = mapA.getOrDefault(sumA, 0) + 1;
                mapA.put(sumA, newFrequencyA);

                int sumB = nums3[i] + nums4[i1];
                Integer newFrequencyB = mapB.getOrDefault(sumB, 0) + 1;
                mapB.put(sumB, newFrequencyB);
            }
        }
        Set<Integer> keySetA = mapA.keySet();
        Set<Integer> keySetB = mapB.keySet();
        int count = 0;
        for (Integer integer : keySetA) {
            int target = -integer;
            if(keySetB.contains(target)){
                //注意这里是相乘
                count = count + mapA.get(integer) * mapB.get(target);
            }
        }
        return count;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
