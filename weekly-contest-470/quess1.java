public class quess1{
     public static int alternatingSum(int[] nums) {

        int result=0;
        
    
        
        for(int i=0;i<nums.length;i++){
                if(i%2==0){
                    result+=nums[i];
                }else{
                    result-=nums[i];
                    
                }
                    
                
                
            }
    
        
     return result;   
    }
    public static void main(String[] args) {
        int arr[]={1,3,5,7,9};
        System.out.println(alternatingSum(arr));
        
    }
}