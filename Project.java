import javax.swing.*;  
import java.awt.event.*;  
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
public class Project implements ActionListener
{  
    JTextField tf1,tf2,tf3;  
    JButton b1,b2;  
	Project(){  
        JFrame f= new JFrame();  
        tf1=new JTextField("Capacity of jug 1");  
        tf1.setBounds(50,50,150,20);  
        tf2=new JTextField("Capacity of jug 2");  
        tf2.setBounds(230,50,150,20);  
        tf3=new JTextField("Required capacity");  
        tf3.setBounds(410,50,150,20);  
        
        b1=new JButton("Submit");  
        b1.setBounds(590,50,80,20);  
         
		b1.addActionListener(this);  
          
        f.add(tf1);f.add(tf2);f.add(tf3);f.add(b1);  
        f.setSize(800,800);  
        f.setLayout(null);  
        f.setVisible(true);  
    }         
	public void actionPerformed(ActionEvent e) 
	{  
        String s1=tf1.getText();  
        String s2=tf2.getText();
		String s3=tf3.getText();
        int a=Integer.parseInt(s1);  
        int b=Integer.parseInt(s2);  
        int result=Integer.parseInt(s3);  
		
		Jug A=new Jug(a);
		Jug B=new Jug(b);
		System.out.println("(A,B) = (" + A.getValue()+ ","+B.getValue()+")");
		solve(A,B,result);
		System.out.println("Done!");
		
    }  
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
public static void main(String[] args) {  
    new Project();  
} 
}  
