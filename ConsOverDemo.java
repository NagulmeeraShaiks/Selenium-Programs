package javapack;

class C
{
	C()
	{
		System.out.println("default constructor");
	}
	C(int x,int y)
	{
		System.out.println("Two param cons");
	}
	C(int x,int y,int z)
	{
		System.out.println("Three param cons");
	}
}

public class ConsOverDemo {

	public static void main(String[] args) {
		C b1=new C(1,2);
		C b2=new C();
	}

}
