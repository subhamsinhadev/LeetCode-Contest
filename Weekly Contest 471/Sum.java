import java.util.HashMap;

public class Sum {
    public int freqCalc(int[] nums,int k){
        HashMap<Integer,Integer> freq=new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num,0)+1);

        }
        int sum=0;
        for (int num : freq.keySet()) {
            int count=freq.get(num);
            if(count%k==0){
                sum+=num*count;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] arr={1,2,2,3,3,3,3,4};
        int freq=new Sum().freqCalc(arr, 2);
        System.out.println(freq);
    }
    
}
