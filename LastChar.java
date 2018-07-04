/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

public class LastChar
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int [] num = new int[length+1];

		
		for(int i=1 ;i<=length; i++){
			num[i] = sc.nextInt();
		}
		
		
		int reminder = 1;
		for(int i=num.length-1; i>=0; i--){
			int value =  (num[i]+reminder)%10;
			reminder =  (num[i]+reminder)/10;
			System.out.println(i+"\t"+num[i] + "\t"+value+"\t"+reminder);
			num[i] = value;
		}
		
		for(int i=0; i<num.length; i++){
			System.out.print(num[i]);
		}
		
	}
}