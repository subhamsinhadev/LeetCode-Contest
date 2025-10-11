public class q3702 {
  
    public  static int longestSubsequence(int[] nums) {
        int xor=0;
        int longseq=nums[0];

        int i=0;
        if(nums[i]==0){
            return 0;
        }
        if (nums.length<=1) {
          return nums[0];  
        }
        for (int j = 0; j < nums.length; j++) {
            xor^=nums[j];
            System.out.println(xor);
            if((xor^nums[j])==0){
            //    xor= nums[i]-xor;
            longseq=nums[j+1];
               i++;
            
            }
            
            
        }
      
        
    return longseq;
    }

  public static void main(String[] args) {
    int arr[]={0, 1, 2, 0, 3};
    int val= longestSubsequence(arr);
    System.out.println(val);


    
  }
}
