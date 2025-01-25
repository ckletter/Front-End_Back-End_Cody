import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;
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
public class CirclePatterns {
    private static final int    FIRST_CORNER_X = 30,
                                FIRST_CORNER_Y = 50,
                                DIAMETER = 30,
                                SMALLEST_RADIUS = 10,
                                CHANGE_IN_RADIUS = 30;
    private CirclePatternsView window;

    private ArrayList<Circle> circles;

    public CirclePatterns() {
        circles = new ArrayList<Circle>();
        window = new CirclePatternsView(circles);
    }

    public int getNumCircles() {
        Scanner s = new Scanner(System.in);
        System.out.print("How many circles should I draw? ");
        int n = s.nextInt();
        s.nextLine();
        return n;
    }

    public void makeRow(int numCircles) {
        // TODO: Write makeRow so it adds the row of circles to the ArrayList of circles.
        int startX = FIRST_CORNER_X;
        int startY = FIRST_CORNER_Y;
        boolean color = true;
        for (int i = 0; i < numCircles; i++)
        {
            if (color)
            {
                circles.add(new Circle(startX, startY, DIAMETER, Color.blue));
            }
            else
            {
                circles.add(new Circle(startX, startY, DIAMETER, Color.red));
            }
            color = !color;
            startX += DIAMETER;
        }
    }

    public void makeDiagonal(int numCircles) {
        // TODO: Write makeDiagonal so it adds the diagonal of circles to the ArrayList of circles.
        int startX = FIRST_CORNER_X;
        int startY = FIRST_CORNER_Y;
        boolean color = false;
        for (int i = 0; i < numCircles; i++)
        {
            if (color)
            {
                circles.add(new Circle(startX, startY, DIAMETER, Color.red));
            }
            else {
                circles.add(new Circle(startX, startY, DIAMETER, Color.blue));
            }
            startX += DIAMETER;
            color = !color;
            startY += DIAMETER;
        }
    }

    public void makeTarget(int numCircles) {
        // TODO: Write makeTarget so it adds the target of circles to the ArrayList of circles.
        // Key idea: the circles have to start big, then get small.
        // That way, when drawn in order, they appear on top of each other.
        int startX = 100;
        int startY = 300;
        boolean color = true;
        int radius = SMALLEST_RADIUS + CHANGE_IN_RADIUS * numCircles;
        for (int i = 0; i < numCircles; i++) {
            if (color) {
                circles.add(new Circle(startX, startY, radius, Color.red));
            } else {
                circles.add(new Circle(startX, startY, radius, Color.black));
            }
            color = !color;
            radius -= CHANGE_IN_RADIUS;
            startX += CHANGE_IN_RADIUS / 2;
            startY += CHANGE_IN_RADIUS / 2;
        }
    }

    public void run() {
        int numCircles = this.getNumCircles();
        this.makeRow(numCircles);
        window.repaint();

        // Part 2
        numCircles = this.getNumCircles();
        this.makeDiagonal(numCircles);
        window.repaint();

        // Part 3
        numCircles = this.getNumCircles();
        this.makeTarget(numCircles);
        window.repaint();
    }

    public static void main(String[] args) {
        CirclePatterns c = new CirclePatterns();
        c.run();
    }
}
