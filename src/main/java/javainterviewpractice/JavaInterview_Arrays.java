package javainterviewpractice;

import java.util.Arrays;
import java.util.Collections;

public class JavaInterview_Arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer[] zbc = new Integer[] {4,5,809,98,1001,1,1,1};
		
		//Arrays.sort(zbc,Collections.reverseOrder());
		
		

		for(int i=0;i<zbc.length-1;i++)
		{
			for(int j=0;j<zbc.length-1;j++)
			{
			if(zbc[j]<zbc[j+1])
			{
				int temp = zbc[j+1];
				zbc[j+1]=zbc[j];
				zbc[j]=temp;
			}
			}
		}
		
		for (int i=0;i<zbc.length;i++)
		{
			System.out.println(zbc[i]);
		}
		
		
	}

}
