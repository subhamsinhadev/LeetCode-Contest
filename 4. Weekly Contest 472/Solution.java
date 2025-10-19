import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int longestBalanced(int[] nums) {
        int maxLen=0;
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> odd=new HashSet<>();// ye sara odd num ko store karega
            Set<Integer> even=new HashSet<>();// aur ye even
            for (int j = i; j < nums.length; j++) {
               if(nums[j]%2==0){
                even.add(nums[j]);
            }else{
                odd.add(nums[j]);

            }
            if(odd.size()==even.size()){
                maxLen=Math.max(maxLen, j-i+1);
            } 
            }
            

            
        }
     return maxLen;   
    }
public static void main(String[] args) {
    int arr[]={2,5,4,3};
    System.out.println(new Solution().longestBalanced(arr));
}
}
