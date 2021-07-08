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
    @Test
    public void tt() {

        int[] nums = {2,3,1,2,4,3};
        System.out.println(this.minSubArrayLen(7, nums));

    }
}