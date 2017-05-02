import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Project implements ActionListener
{
    JTextField tf1,tf2,tf3;
    JTextArea area;
    JugPanel panel;
    JButton b1;

    Timer timer;

    Project()
    {
        JFrame frame= new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        JPanel pane = new JPanel();
        pane.setLayout(new GridBagLayout());

        tf1 = new JTextField("Capacity of jug 1", 10);
        tf2 = new JTextField("Capacity of jug 2", 10);
        tf3 = new JTextField("Required capacity", 10);
        panel = new JugPanel();
        b1 = new JButton("Submit");
        area = new JTextArea(5, 30);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 20, 5, 20);
        gbc.gridx = 0;
        gbc.gridy = 0;
        pane.add(tf1, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        pane.add(tf2, gbc);
        gbc.gridx = 2;
        gbc.gridy = 0;
        pane.add(tf3, gbc);
        gbc.gridx = 3;
        gbc.gridy = 0;
        pane.add(b1, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.BOTH;
        pane.add(panel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        pane.add(area, gbc);

        frame.add(new JScrollPane(pane), BorderLayout.CENTER);
        frame.setVisible(true);

        b1.addActionListener(this);
        timer = new Timer(1000,this);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == b1) {
            String s1 = tf1.getText();
            String s2 = tf2.getText();
            String s3 = tf3.getText();
            int a = Integer.parseInt(s1);
            int b = Integer.parseInt(s2);
            int result = Integer.parseInt(s3);

            Jug A = new Jug(a);
            Jug B = new Jug(b);

            area.setText("(A,B) = (" + A.getValue() + "," + B.getValue() + ")" + "\n");

            while (A.getValue() != result) {
                if (!A.isFull() && B.isEmpty()) {
                    area.append("Fill B" + "\n");
                    B.Fill();
                    area.append("(A, B) = (" + A.getValue() + ", " + B.getValue() + ")" + "\n");
                }
                if (A.isFull()) {
                    area.append("Empty A" + "\n");
                    A.Empty();
                    area.append("(A, B) = (" + A.getValue() + ", " + B.getValue() + ")" + "\n");
                }
                area.append("Pour from B into A" + "\n");
                fill(A, B);
                area.append("(A, B) = (" + A.getValue() + ", " + B.getValue() + ")" + "\n");
            }

            area.append("Done!" + "\n");

            //Save steps to be performed and start timer here. Use code: timer.start();
        } else {
            /*This block is executed when the timer is running. The timer will call
            this block every second...you can change this by changing the delay during
            initialization. Implement simulation logic here...ie how to update the
            values in panel and call repaint so that the simulation is natural. My advice
            is to disable the button while simulation is running. Don't forget to stop the
            timer and enable it once the simulation is over though.
            Use code: timer.stop(); b1.setEnabled(true/false)*/
        }

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


    public static void main(String[] args) {
        new Project();
    }
}
