package javapack;

class A
{
	//int x=10,y=20;
	int x,y;
	void sum()
	{
		System.out.println("Sum of x & y is:"+(x+y));
	}
}

public class MethodDemo {

	public static void main(String[] args) {
		
		//System.out.println("Welcome to Java");
		A b1=new A();
		b1.x=10;
		b1.y=20;
		b1.sum();
		A b2=new A();
		b2.x=1;
		b2.y=2;
		b2.sum();

	}

}
