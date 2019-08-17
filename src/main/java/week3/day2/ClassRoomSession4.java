package week3.day2;

import java.util.LinkedHashMap;
import java.util.Map;

public class ClassRoomSession4 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String s1 = "Amazon India Private Limited";
		char char1[] = s1.toCharArray();
		Map<Character,Integer> countMap = new LinkedHashMap<Character, Integer>();
		for(Character c1 : char1)
		{
			if(countMap.containsKey(c1) && !countMap.containsKey(" "))
			{
				Integer value = countMap.get(c1);
				countMap.put(c1,value+1 );
			}
			else
			{
				countMap.put(c1,1);
			}
			
		}
		System.out.println(countMap);
	}

}
