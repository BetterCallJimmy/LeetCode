import org.junit.Test;

public class ttest {
    private static int count(int i ,int j,int[] nums){
        int l = i;
        int r = j;
        int c = 0;
        while(l <= r){
            c = c + nums[l];
            l++;
        }
        return c;
    }
    public static int minSubArrayLen(int target, int[] nums) {

        int i = 0;
        int j = 0;


        int result = 0;
        while(i <= j && j < nums.length){
            if(i == j && nums[i]>=target){
                return 1;
            }else if(count(i,j,nums) < target){
                j++;
            }else {
                result = j - i + 1;
                i++;
            }
        }
        return result;
    }
    public String reverseStr(String s, int k) {
        if(s == null || "".equals(s)){
            return "";
        }
        int length = s.length();
        //这里不能初始null，若是null，拼接的字符串是一个null对象,也会将其转为“null”。在String源码中valuOf（）
        //我们在拼接字符串的时候，不能使用null作为空字符串，而应该使用""
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
        }else {
            String s1 = s;
            //s2 = s.substring(k, length);

            String sa = s1.substring(0, k);
            sb = s1.substring(k, length);
            done = new StringBuffer(sa).reverse().toString();
        }
        return done + sb + reverseStr(s2, k);
    }
    @Test
    public void tt() {
        System.out.println(reverseStr("abcd", 4));

    }
}