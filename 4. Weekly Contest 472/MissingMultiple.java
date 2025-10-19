import java.util.HashSet;
import java.util.Set;

public class MissingMultiple {
    public int missingMultiple(int[] nums, int k) {
        int maxNum=0;
        Set<Integer> set=new HashSet<>();
        for (int i : nums) {
            set.add(i);
            maxNum=Math.max(maxNum,i);
            
        }
        //m=m+k tak isliye kyunki hume multiple chahiye
        for(int m=k;m<maxNum+k;m+=k){
            if(!set.contains(m)) return m;
            
        }

       //agar ek num ka sara multiple karta h toh next multiple return kar denge
        return maxNum+k;
    }
    public static void main(String[] args) {
        int arr[]={10,2,4,6};
        System.out.println(new MissingMultiple().missingMultiple(arr, 2));
    }
}