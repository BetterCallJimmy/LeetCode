package leetcode.editor.cn;
//给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面
//的字符构成。如果可以构成，返回 true ；否则返回 false。 
//
// (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。) 
//
// 
//
// 示例 1： 
//
// 
//输入：ransomNote = "a", magazine = "b"
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：ransomNote = "aa", magazine = "ab"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：ransomNote = "aa", magazine = "aab"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 你可以假设两个字符串均只含有小写字母。 
// 
// Related Topics 哈希表 字符串 计数 
// 👍 161 👎 0


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        char[] ransom = ransomNote.toCharArray();
        char[] magazi = magazine.toCharArray();
        //把magazine字符串各字符映射到map<字符,出现次数>
        //再用ransom和map匹配减去出现次数
        //用数组来映射更快
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : magazi) {
            int newFrequency = map.getOrDefault(c, 0) + 1;
            map.put(c, newFrequency);
        }

        for (char c : ransom) {
            Integer frequency = map.get(c);
            if(frequency == null || frequency < 1){
                return false;
            }
            map.put(c, frequency - 1);
        }
        return true;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
