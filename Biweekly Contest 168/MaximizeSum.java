
public class MaximizeSum {

    
    public String maxSumOfSquares(int num, int sum) {
        if(sum>9*num){
            return "";
        }
        int[] digit=new int[num];


        // for (int i = 0; i < num; i++) {
        //     //sum=3
        //     //num=2
        //     System.out.println("---"+digit[i]);
        //     System.out.println("---"+sum);

        //     digit[i]=Math.min(9, sum);
        //     sum-=digit[i];
        //     System.out.println("###"+digit[i]);



            
        // }
        int k=0;

        while(k<sum){
            digit[k]=Math.min(9, sum);
            sum=sum-digit[k];
            k++;



        }
        StringBuilder sb=new StringBuilder();
        for (int i : digit) {
            sb.append(i);
            
        }
        



        return sb.toString();
        
    }

    public static void main(String[] args) {
      System.out.println(  new MaximizeSum().maxSumOfSquares(2, 3));
    }
    
}
