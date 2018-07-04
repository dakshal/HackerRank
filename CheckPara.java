/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    class stack{
        ArrayList<String> st = new ArrayList<>();
        
        public ArrayList<String> getList() {
            return st;
        }
        
        public String pop(){
            String par = st.get(st.size()-1);
            st.remove(st.size()-1);
            return par;
        }
        public String last(){
            return st.get(st.size()-1);
        }
        
        public void push(String par) {
            st.add(par);
        }
        
        public boolean isEmpty(){
            if(st == null || st.size()==0){
                return true;
            }
            return false;
        }
        
        public boolean isMatching(String var1, String var2){
            if(var1.equals("(") && var2.equals(")")){
                return true;
            }else if(var1.equals("[") && var2.equals("]")){
                return true;
            }else if(var1.equals("{") && var2.equals("}")){
                return true;
            }
            else {
                return false;
            }
        }
        
    }
    
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    
	    String exp = sc.nextLine();
	    stack st = new stack();
	    for(int i=0; i<exp.length;i++){
	        if(exp.charAt(i) == "(" || exp.charAt(i)=="{" || exp.chatAt(i) == "["){
	            st.push(exp.charAt(i));
	        }
	        if(st.isEmpty()){
	            System.out.println("Not valide Expression!!!");
	            break;
	        }
	        
	        if(st.isMatching(st.last(), exp.charAt(i))){
	            st.pop();
	        } else {
	            System.out.println("Not valide Expression!!!");
	            break;
	        }
	    }
	}
}