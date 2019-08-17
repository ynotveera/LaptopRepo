package week3.day1;

public class BMW extends Car{
	
	public void doHorn()
	{
		System.out.println("BMW Horn");
	}
	
	public String doHorn(String force)
	{
		return force + "Horn";
	}
	
	public static void main(String[] args) {
		Vehicle vehicle = new Vehicle();
		vehicle.doHorn();
		Car car = new Car();
		car.doHorn();
		BMW bmw = new BMW();
		bmw.doHorn();
		System.out.println(bmw.doHorn("Force"));
		
	}

}
