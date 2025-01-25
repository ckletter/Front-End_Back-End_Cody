import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
/******************************************************************************************
 *
 * Program:	Circle, CirclePatters, and CirclePatternsView
 * Created for CS2 @ Menlo School by Z. Blickensderfer on 1/14/23
 *
 * Description:
 *  This program prompts the user for a number of circles three times,
 *  first printing a row of circles alternating in color,
 *  then a diagonal of circles (again, alternating in color),
 *  and, finally, a target made of circles that (you guessed it) alternate in color.
 *
 *****************************************************************************************/
public class CirclePatternsView extends JFrame {

    private static final int    WINDOW_WIDTH = 800,
                                WINDOW_HEIGHT = 600;
    private ArrayList<Circle> circles;

    public CirclePatternsView(ArrayList<Circle> circles) {
        // TODO: Write the view's constructor.
        this.circles = circles;

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setTitle("Circles");
        this.setVisible(true);
    }

    public void paint(Graphics g) {
        // TODO: write paint() so it draws all the circles on the window.
        boolean color = true;
        int size = circles.size();
        for (int i = 0; i < size; i++)
        {
            circles.get(i).draw(g);
        }
    }

}
