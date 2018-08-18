
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    private static class stack {
        ArrayList<Character> st = new ArrayList<>();

        public ArrayList<Character> getList() {
            return st;
        }

        public char pop() {
            char par = st.get(st.size() - 1);
            st.remove(st.size() - 1);
            return par;
        }

        public char last() {
            return st.get(st.size() - 1);
        }

        public void push(char par) {
            st.add(par);
        }

        public boolean isEmpty() {
            if (st == null || st.size() == 0) {
                return false;
            }
            return true;
        }

        public boolean isMatching(char var1, char var2) {
            if (var1 == '(' && var2 == ')') {
                return true;
            } else if (var1 == '{' && var2 == '}') {
                return true;
            } else if (var1 == '[' && var2 == ']') {
                return true;
            } else {
                return false;
            }
        }

    }

    public static boolean checkPara(String exp) {
        stack st = new stack();
//      System.out.println(exp);
        for (int i = 0; i < exp.length(); i++) {
            if (exp.charAt(i) == '(' || exp.charAt(i) == '{' || exp.charAt(i) == '[') {
                st.push(exp.charAt(i));
            } else {
//              System.out.println(st.last() + "\t" + exp.charAt(i) + "\t" + i);
                if (st.isEmpty()) {
                    return false;
                }
                if (st.isMatching(st.last(), exp.charAt(i))) {
                    st.pop();
                } else {
                    return false;
                }
            }
        }

        if(st.isEmpty())
            return true;
        else 
            return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int loop = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < loop; i++) {
            String exp = sc.nextLine();
            if (checkPara(exp)) {
                System.out.println("balanced");
            } else {
                System.out.println("not balanced");
            }
        }
    }
}