package selenium.practice.TestProject;

public class GreatestOfThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=11;
		int b=10;
		int c=10;
		
		if(a>b && a>c)
		{
			System.out.println("a is greater");
		}
		else if(c >b && c >a)
		{
			System.out.println("c is greater");
		}
		else if(b>a && b>c)
		{
			System.out.println("b is greater");	
		}
		else
		{
			System.out.println("Invalid");
		}
			
	}

}
