class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] para = s.toCharArray();
        for(int i=0; i<para.length; i++){
            if(para[i] == '{' || para[i] == '[' || para[i] == '('){
                stack.push(para[i]);
                continue;
            }
            
            if(stack.isEmpty()){
                return false;
            }
            
            char lastPara = stack.pop();
            
            if((lastPara == '{' && para[i] == '}') || (lastPara == '(' && para[i] == ')') || (lastPara == '[' && para[i] == ']')) {
                
            } else {
                return false;
            }
            
        }
        if(stack.isEmpty())
            return true;
        else 
            return false;
    }
}