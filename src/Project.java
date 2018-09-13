import javax.swing.*;
import java.awt.*;
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
public class Projectfinal extends Frame implements ActionListener
{  
    TextField tf1,tf2,tf3;  
	TextArea area;
	int h1=0,h2=0;
    Button b1,b2;  
	Projectfinal()
	{  
        super("Water Jug");
        tf1=new TextField("Capacity of jug 1");  
        tf1.setBounds(50,50,150,20);  
        tf2=new TextField("Capacity of jug 2");  
        tf2.setBounds(230,50,150,20);  
        tf3=new TextField("Required capacity");  
        tf3.setBounds(410,50,150,20);  
        
        b1=new Button("Submit");  
        b1.setBounds(590,50,80,20); 
		
		area=new TextArea();  
        area.setBounds(50,400, 200,320); 
		
		b1.addActionListener(this);  
          
        add(tf1);add(tf2);add(tf3);add(b1); add(area); 
        setSize(1200,1200);  
        setLayout(null);  
        setVisible(true);  
    }  
		
	void drawing(Graphics g)
	{
		Graphics2D graphics = (Graphics2D) g;
        graphics.setPaint(Color.BLUE);
		
        		
		System.out.println("inside drawing");
		this.update(g);
       
	   
		graphics.fillRect(100, 300-h1,99,h1);
		graphics.fillRect(300, 300-h2,99,h2);
       
	   
	   graphics.setPaint(Color.BLACK);

        graphics.setStroke(new BasicStroke(3));

        	
        graphics.drawLine(100, 150, 100, 300);
        graphics.drawLine(100, 300, 200, 300);
        graphics.drawLine(200, 150, 200, 300);
		
		
		graphics.drawLine(300, 150, 300, 300);
        graphics.drawLine(300, 300, 400, 300);
        graphics.drawLine(400, 150, 400,300);
		
	}
	public void paint(Graphics g)
	{
        Graphics2D graphics = (Graphics2D) g;
        graphics.setPaint(Color.BLUE);
		
       	
		System.out.println("inside paint");
		
			
        graphics.fillRect(100, 300-h1,99,h1);
		graphics.fillRect(300, 300-h2,99,h2);
        graphics.setPaint(Color.BLACK);

        graphics.setStroke(new BasicStroke(3));

       	
        graphics.drawLine(100, 150, 100, 300);
        graphics.drawLine(100, 300, 200, 300);
        graphics.drawLine(200, 150, 200, 300);
		
		
		graphics.drawLine(300, 150, 300, 300);
        graphics.drawLine(300, 300, 400, 300);
        graphics.drawLine(400, 150, 400,300);
		
		Thread t= Thread.currentThread();
		try
		{
			
			t.sleep(500);
		}
		catch(Exception e)
		{
			System.out.println("exception found ");
		}		

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
	
		area.setText("(A,B) = (" + A.getValue()+ ","+B.getValue()+")"+"\n");
		
		Thread t= Thread.currentThread();
		while(A.getValue() != result)
		{
			System.out.println("in");
			if(!A.isFull() && B.isEmpty())
			{
				area.append("Fill B"+"\n");
				B.Fill();
				h1=A.getValue()*10;
				h2=B.getValue()*10;
				Graphics g =this.getGraphics();
				drawing(g);
					try{
					t.sleep(1000);
					}
					catch(Exception e1)
					{
						System.out.println("Hello world");
					}
				
				area.append( "(A, B) = (" + A.getValue() + ", " + B.getValue() +")"+"\n");
				repaint();
			}
			if(A.isFull())
			{
				area.append( "Empty A"+"\n");
				A.Empty();
				
				h1=A.getValue()*10;
				h2=B.getValue()*10;
				Graphics g =this.getGraphics();
				
				drawing(g);
				
				try
				{
					t.sleep(1000);
					}
					catch(Exception e1)
					{
						System.out.println("Hello world");
					}
			area.append("(A, B) = (" + A.getValue()+ ", "+B.getValue()+ ")"+"\n");
				repaint();
				
			}
			area.append( "Pour from B into A"+"\n");
			fill(A, B);
			
			h1=A.getValue()*10;
			h2=B.getValue()*10;
			System.out.println("h1 ,h2 = "+ h1 +" " +h2);
			Graphics g =this.getGraphics();
			
			drawing(g);
			try{
				t.sleep(1000);
				}
				catch(Exception e1)
				{
					System.out.println("Hello world");
				}
		area.append( "(A, B) = (" + A.getValue() + ", " + B.getValue() + ")"+"\n");
			repaint();
		}
		
		area.append("Done!"+"\n");
		
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

	
public static void main(String[] args) 
{  
    new Projectfinal();  
	
} 
}  
