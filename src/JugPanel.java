import javax.swing.*;
import java.awt.*;

/**
 * Created by Sourish on 02-05-2017.
 */
public class JugPanel extends JPanel {
    //Coordinates for first jug
    int x1, x2, y1, y2;
    //Coordinates for second jug
    int x3, x4, y3, y4;
    //Amount of water in first jug
    int capacity1;
    //Amount of water in second jug
    int capacity2;
    public JugPanel() {
        setPreferredSize(new Dimension(300, 250));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics = (Graphics2D) g;
        graphics.setPaint(Color.BLUE);

        //Make height a function of capacity1. Copy and repeat the same with capacity 2 for the second jug
        graphics.fillRect(100, 70,99,130);
        graphics.setPaint(Color.BLACK);

        graphics.setStroke(new BasicStroke(3));

        //Replace with x1, x2, y1, y2 and copy the same and replace with x3, x4, y3, y4
        graphics.drawLine(100, 50, 100, 200);
        graphics.drawLine(100, 200, 200, 200);
        graphics.drawLine(200, 50, 200, 200);
    }

    /*Call these functions from Project.java via panel object to update
    respective values as per algorithm. Then call repaint() to clear the screen and redraw.*/

    public void setFirstJug(int x1, int x2, int y1, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public void setSecondJug(int x3, int x4, int y3, int y4) {
        this.x3 = x3;
        this.x4 = x4;
        this.y3 = y3;
        this.y4 = y4;
    }

    public void setCapacities(int capacity1, int capacity2) {
        this.capacity1 = capacity1;
        this.capacity2 = capacity2;
    }
}
