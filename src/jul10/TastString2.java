package jul10;

import java.util.ArrayList;

public class TastString2 {

	public static void main(String[] args) {
		// TODO last occurence of substring inside a string
		String s1="niharikaGadde";
		String s2="subashChowdary";
		String s3=s1.substring(8);
		System.out.println(s3);
		//int i=s1.lastIndexOf("g");
		//System.out.println(i);
		ArrayList<String> t=new ArrayList<String>();
		for(int i=0;i<s1.length();i++)
		{
		if(s1.charAt(i)!='a')
		{
			
		
				System.out.println(s1.charAt(i));
		}
		
		}
		

	}

	
}
