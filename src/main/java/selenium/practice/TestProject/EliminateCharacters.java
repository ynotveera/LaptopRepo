package selenium.practice.TestProject;

public class EliminateCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "Welcome to Automation World!!!";

		text = text.replace("e", "");

		//System.out.println(text);

		for (int i=0;i<text.length();i++)
		{
			if(text.charAt((i))!='e')
			{
				System.out.print(text.charAt(i));
			}
		}

		//System.out.println(text);
	}

}
