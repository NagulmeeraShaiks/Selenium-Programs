package javapack;

class D
{
	int x,y;
	D(int x)
	{
		System.out.println("Cons demo:"+x);
	}
	D(int x,int y)
	{
		this(1);
		this.x=x;
		this.y=y;
	}
	void sum()
	{
		
		System.out.println("Sum of x & y is:"+(x+y));
		this.show();
	}
	void show()
	{
		System.out.println("Show method");
	}
}
public class ThisDemo {

	public static void main(String[] args) {
		D b=new D(10,20);
		b.sum();

	}

}
