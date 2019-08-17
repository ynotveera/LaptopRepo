package week3.day2;

import java.util.LinkedHashSet;
import java.util.Set;

public class ClassRoomSession3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "Infosys limited";
		char[] c1 = s1.toCharArray();
		
		Set<Character> set = new LinkedHashSet<Character>();
		for (int i=0;i<c1.length;i++)
		{
			boolean contains = set.contains(c1[i]);
			if(contains)
			{
				System.out.println(c1[i]);
			}
			else
			{
				set.add(c1[i]);
			}
			
		}
		
	}

}
