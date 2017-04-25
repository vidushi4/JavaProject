import java.util.*;
class Jug
{
	int capacity;
	int value;
	Jug(int n)
	{
		capacity = n;
		value = 0;
	}
	void Fill()
	{
		value = capacity;
	}
	void Empty()
	{
		value = 0;
	}
	boolean isFull()
	{
		return value >= capacity;
	}
	boolean isEmpty()
	{
		return value == 0;
	}
	
	

	int getValue()
	{
	return value;
	}
	
}	
	
	
public class WaterJug
{
	static void fill(Jug A, Jug B)
	{
	int old_value = A.value;

	A.value = A.value + B.value;
	A.value = A.value > A.capacity?A.capacity:A.value;

	B.value = B.value - (A.value - old_value);
	}
	static int gcd(int n,int m)
	{ 
		if(m<=n && n%m == 0)
			return m;
		if(n < m)
			return gcd(m,n);
		else
			return gcd(m,n%m);
	}
	static boolean check(int a,int b,int c)
	{
		if(c>a)
		{
			System.out.println("A can't hold more water than it's capacity!");
			return false;
		}
 		if(c % gcd(a,b) == 0)
		{
			return true;
		}
 		System.out.println("Can't reach this state with the given jugs");
		return false;
	}

	static void solve(Jug A, Jug B, int result)
	{
		while(A.getValue() != result)
		{
			if(!A.isFull() && B.isEmpty())
			{
				System.out.println("Fill B");
				B.Fill();
				System.out.println("(A, B) = (" + A.getValue() + ", " + B.getValue() +")");
			}
			if(A.isFull())
			{
				System.out.println("Empty A");
				A.Empty();
				System.out.println("(A, B) = (" + A.getValue()+ ", "+B.getValue()+ ")");
			}
			System.out.println("Pour from B into A");
			fill(A, B);
			System.out.println("(A, B) = (" + A.getValue() + ", " + B.getValue() + ")");
		}
	}
	public static void main(String[] args)
	{
		int a,b,result;
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter capacity of jug A");
		a=sc.nextInt();
		System.out.println("Enter capacity of jug B");
		b=sc.nextInt();
		do{
			System.out.println("Enter required water in A:");
			result=sc.nextInt();
		}while(!check(a,b,result));
		Jug A=new Jug(a);
		Jug B=new Jug(b);
		System.out.println("(A,B) = (" + A.getValue()+ ","+B.getValue()+")");
		solve(A,B,result);
		System.out.println("Done!");
		
		
	}
	
}

