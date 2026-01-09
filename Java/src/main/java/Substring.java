import java.util.Set;
import java.util.HashSet;


class Substring{
    public int subtring(String s){
        Set<Character> set=new HashSet<>();
        int a=0,max=0;
        for(int b=0;b<s.length();b++){
            while(set.contains(s.charAt(b))){
                set.remove(s.charAt(a));
                a++;
            }
            set.add(s.charAt(b));
            max=Math.max(max,b-a+1);
        }
        return max;
    }
}