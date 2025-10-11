public class Equal_Score_Substrings {
    public boolean scoreBalance(String s) {

        int tsum=0;
        //we will calculate total sum
        for(int i=0;i<s.length();i++){
            tsum+=(s.charAt(i)-'a'+1);
        }
        int leftsum=0;
        for (int i = 0; i < s.length()-1; i++) {
            leftsum+=(s.charAt(i)-'a'+1);
            int rightsum=tsum-leftsum;
            if(leftsum==rightsum){
                return true;
            }
            
        }


        return false;
    }
    public static void main(String[] args) {
        String s="adbc";
       boolean b= new Equal_Score_Substrings().scoreBalance(s);
       System.out.println(b);
    }
}
