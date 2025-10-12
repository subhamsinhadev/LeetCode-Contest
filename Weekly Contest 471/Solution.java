class Solution {
    public int longestBalanced(String s) {
        int n=s.length();
        int maxlength=0;
        for(int i=0;i<n;i++){
            int[] freq=new int[26];
            for(int j=i;j<n;j++){
                freq[s.charAt(j)-'a']++;
                if(checkBalance(freq)){
                    maxlength=Math.max(maxlength,j-i+1);
                }
            }
        }
        return maxlength;
    }
    public static boolean checkBalance(int[] freq){
        int min=Integer.MAX_VALUE;
            int max=Integer.MIN_VALUE;
        for(int n:freq){
            if(n>0){
                min=Math.min(min,n);
                max=Math.max(max,n);
            }
        }
        return min==max;
    }
}