package week3.day2;

import java.util.LinkedHashSet;
import java.util.Set;

public class ClassRoomSession1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "Infosys limited";
		char[] c1 = s1.toCharArray();
		
		Set<Character> set = new LinkedHashSet<Character>();
		for (char cs : c1) {
			boolean added = set.add(cs);
			if(!added)
			{
				System.out.println(cs);
			}
			else
			{
				//System.out.print(cs);
			}
			
		}
		
	}

}
