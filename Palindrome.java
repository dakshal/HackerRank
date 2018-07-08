/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int length = sc.nextInt();
	    sc.nextLine();
	    for(int k=0; k<length; k++){
    		String str = sc.nextLine();
    		str = str.toLowerCase().trim();
    // 		System.out.println(str);
    		
    		int i=0, j=str.length()-1;
    		
    		while(i<=j) {
    			if(str.charAt(i) == str.charAt(j)) {
    				i++;
    				j--;
    			} else if(str.charAt(i)-'a'<0) {
    				i++;
    			} else if(str.charAt(j)-'a'<0) {
    				j--;
    			} else {
    				break;
    			}
    		}
    		
    		if(i>=j) {
    			System.out.println("YES");
    		} else {
    			System.out.println("NO");
    		}
	    }
	}
}