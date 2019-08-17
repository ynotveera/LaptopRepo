package week3.day2;

import java.util.ArrayList;
import java.util.List;

public class ClassRoomSession {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s1 = "Infosys limited";
		char[] c1 = s1.toCharArray();

		List<Character> dupl = new ArrayList<Character>();

		for (char cs : c1) {
			if(!dupl.contains(cs))
			{
				dupl.add(cs);
				
			}
			else
			{
				//System.out.println("Duplicate characters are");
				System.out.println(cs);
			}
		}

	}

}
