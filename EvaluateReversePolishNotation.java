class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<tokens.length; i++) {
            
            if(tokens[i].equals("*")){
                if(stack.size() < 2) {
                    return -1;
                }
                int a = stack.pop();
                int b = stack.pop();
                
                stack.push(a*b);
                
            } else if(tokens[i].equals("/")){
                if(stack.size() < 2) {
                    return -1;
                }
                int a = stack.pop();
                int b = stack.pop();
                try{
                    stack.push(b/a);
                } catch(Exception e) {
                    stack.push(0);
                }
                
            } else if(tokens[i].equals("+")) {
                if(stack.size() < 2) {
                    return -1;
                }
                int a = stack.pop();
                int b = stack.pop();
                
                stack.push(a+b);
                
            } else if(tokens[i].equals("-")){
                if(stack.size() < 2) {
                    return -1;
                }
                int a = stack.pop();
                int b = stack.pop();
                
                stack.push(b-a);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        if(stack.size() == 1)
            return stack.pop();
        else 
            return -1;
    }
}