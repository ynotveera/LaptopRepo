package selenium.practice.TestProject;

public class PrimeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int givenNO =17;
		int tempVar =0;
		for (int i=1;i<=givenNO;i++)
		{
			if(givenNO%i==0)
			{
				tempVar++;
			}
		}
	
		if(tempVar==2)
		{
			System.out.println("The given no is prime");	
		}
		else
		{
			System.out.println("The given no is not a prime");
		}
		

	}

}
