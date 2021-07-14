package leetcode.editor.cn;
//编写一个算法来判断一个数 n 是不是快乐数。 
//
// 「快乐数」定义为： 
//
// 
// 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。 
// 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。 
// 如果 可以变为 1，那么这个数就是快乐数。 
// 
//
// 如果 n 是快乐数就返回 true ；不是，则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：19
//输出：true
//解释：
//12 + 92 = 82
//82 + 22 = 68
//62 + 82 = 100
//12 + 02 + 02 = 1
// 
//
// 示例 2： 
//
// 
//输入：n = 2
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 231 - 1 
// 
// Related Topics 哈希表 数学 双指针 
// 👍 632 👎 0


import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int getSum(int num){
        int temp = 0;
        int sum = 0;
        while (num > 0){
            //个位
            temp = num % 10;
            temp = temp*temp;
            sum += temp;
            num /= 10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        //无限循环，即会重复出现
        HashSet<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)){
            //add要放在前面，把第一次输入的n也添加
            set.add(n);
            n = getSum(n);
            //set.add(n);
        }
        return n == 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
