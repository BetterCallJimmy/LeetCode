package leetcode.editor.cn;//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 0 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 1670 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {

        /*
        只需要依次将基准元素和后面的元素进行比较（假定后面的元素依次为x1,x2,x3....），不断更新基准元素，
        直到基准元素和所有元素都满足最长公共前缀的条件，就可以得到最长公共前缀。
         */
        String curStr = strs[0];
        int count = 0;
        while (curStr.length() != 0 && count != strs.length){
            for (int i = 0; i < strs.length; i++) {
                //由于基准strs[0]的长度可能不是最短的，所以判断下一个的长度是不是更短，若是则更新基准
                //这样的效率不是很高，但更简单
                if (curStr.length() > strs[i].length()){
                    curStr = strs[i];
                    count = 0;
                    break;
                }
                //截取string的头部部分，长度和基准的一样
                String substring = strs[i].substring(0, curStr.length());
                //如果基准和截取的头部str不一样，则将基准缩短尾部
                if (!curStr.equals(substring)){
                    curStr = curStr.substring(0,curStr.length() - 1);
                    count = 0;
                    break;
                }
                count++;
            }
        }
        if (curStr.length() == 0){
            return "";
        }else {
            return curStr;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
