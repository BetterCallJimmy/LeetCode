package leetcode.editor.cn;
//给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。 
//
// 
// 如果剩余字符少于 k 个，则将剩余字符全部反转。 
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。 
// 
//
// 
//
// 示例: 
//
// 输入: s = "abcdefg", k = 2
//输出: "bacdfeg"
// 
//
// 
//
// 提示： 
//
// 
// 该字符串只包含小写英文字母。 
// 给定字符串的长度和 k 在 [1, 10000] 范围内。 
// 
// Related Topics 双指针 字符串 
// 👍 130 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseStr(String s, int k) {
        if(s == null || "".equals(s)){
            return "";
        }
        int length = s.length();
        //这里不能初始null，若是null，拼接的字符串是一个null对象,也会将其转为“null”。在String源码中valuOf（）
        //我们在拼接字符串的时候，不能使用null作为空字符串，而应该使用""
        //          [      s         ]
        //把s分为    [  s1  ][   s2   ]   s1长度为2k、k-2k、0-k
        //          [ sa sb][   s2   ]
        //sa反转后   [done sb][  s2    ]
        //s2递归
        String done = "";
        String sb = "";
        String s2 = "";
        if (length >= 2 * k) {
            String s1 = s.substring(0, 2 * k);
            s2 = s.substring(2 * k, length);

            String sa = s1.substring(0, k);
            sb = s1.substring(k, 2 * k);
            done = new StringBuffer(sa).reverse().toString();

        }else if (length <= k){
            done = new StringBuffer(s).reverse().toString();
        }else {//k-2k
            String s1 = s;//该长度下没有s2
            String sa = s1.substring(0, k);
            sb = s1.substring(k, length);
            done = new StringBuffer(sa).reverse().toString();
        }
        return done + sb + reverseStr(s2, k);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
