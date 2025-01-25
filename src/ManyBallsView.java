import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
/******************************************************************************************
 *
 * Program:	ManyBallsView
 * Created by: Z. Blickensderfer, 12/30/22
 *
 * Description:
 * This is the front-end for the ManyBalls program.
 *
 *****************************************************************************************/
public class ManyBallsView extends JFrame {

    private ArrayList<Ball> balls;
    private int windowWidth;
    private int windowHeight;

    public ManyBallsView(int width, int height, ArrayList<Ball> balls) {
        // Initialize instance variables.
        windowWidth = width;
        windowHeight = height;
        this.balls = balls;

        // Show the window with the ball in its initial position.
        this.setTitle("MANY BALLS!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.setVisible(true);
    }

    public void paint(Graphics g) {
        // Clear the window.
        g.setColor(Color.white);
        g.fillRect(0, 0, windowWidth, windowHeight);

        // Tell the ball to draw itself.
        for (Ball b : balls) {
            b.draw(g);
        }
    }
}
