public class LexSmallest {
    public String lexSmallest(String s) {
        String old=s;
        for (int i = 0; i < s.length(); i++) {

            ///pehle hum 0,i tak substring nikalne aur rev liye aur phir se usme old string add kiye
            String first= new StringBuilder(s.substring(0,i)).reverse().toString()+s.substring(i);

            String last=s.substring(0, s.length()-i)+new StringBuilder(s.substring(s.length()-i)).reverse().toString();

            if(first.compareTo(old)<0)old=first;
            if(last.compareTo(old)<0)old=last;


            
        }
        return old;
    }
    public static void main(String[] args) {
        String s="dcab";
         System.out.println(new Solution().lexSmallest(s));
    }
}