public class Longest_Fibonacci_Subarray {

    public int longestSubarray(int[] nums) {
        int n=nums.length;
        if(n<3){
            return n;
        }


        int maxlen=2;
        int currentlen=2;
        for (int i = 2; i < nums.length; i++) {
            if(nums[i]==nums[i-1]+nums[i-2]){
                currentlen++;
            }
            else{
                currentlen=2;

            }
            maxlen=Math.max(currentlen, maxlen);
            
        }

        return maxlen;


    }

public static void main(String[] args) {
    int nums[]={5,2,7,9,16};
   int n= new Longest_Fibonacci_Subarray().longestSubarray(nums);
   System.out.println(n);
}
}
