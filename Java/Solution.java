import java.util.Stack;

class Solution{
    public boolean isValid(String s){
        Stack<Character> stack =new Stack<>();
        for(char ch: s.toCharArray()){
            if( ch=='(' || ch=='{' || ch=='['){
                stack.push(ch);
            }
            else if (ch == ')' || ch == '}' || ch == ']') {
                if(stack.isEmpty())
                return false;
                
                char top=stack.pop();
                
                if((ch==')'&& top!='(') || (ch=='}' && top!='{') || (ch==']'&& top!='[')){
                    return false;
                }
            
            }
        }
        return stack.isEmpty();
    }
    public static void main(String args[]){
        Solution sol=new Solution();
        System.out.println(sol.isValid("(a)"));
        System.out.println(sol.isValid("0D0"));
        System.out.println(sol.isValid("("));
        System.out.println(sol.isValid("(M)"));
        System.out.println(sol.isValid("(D)"));
    }
}