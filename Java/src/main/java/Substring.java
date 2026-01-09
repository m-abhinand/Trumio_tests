import java.util.HashSet;
import java.util.set;

class Solution{
    public int subtring(String s){
        Set<Character> set=new HashSet<>();
        int a=0,max=0;
        for int(int b=0;b<s.length();n++){
            while(set.contains(s.charAt(b))){
                set.remove(s.charAt(a));
                a++;
            }
            set.add(s.charAt(b));
            max=Math.max(maxLen,b-a+1);
        }
        return max;
    }
}