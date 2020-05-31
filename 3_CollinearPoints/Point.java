/******************************************************************************
 *  Compilation:  javac Point.java
 *  Execution:    java Point
 *  Dependencies: none
 *
 *  An immutable data type for points in the plane.
 *  For use on Coursera, Algorithms Part I programming assignment.
 *
 ******************************************************************************/

import java.util.Comparator;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Point implements Comparable<Point> {

    private final int x;     // x-coordinate of this point
    private final int y;     // y-coordinate of this point

    /**
     * Initializes a new point.
     *
     * @param  x the <em>x</em>-coordinate of the point
     * @param  y the <em>y</em>-coordinate of the point
     */
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }

    /**
     * Draws this point to standard draw.
     */
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    /**
     * Draws the line segment between this point and the specified point
     * to standard draw.
     *
     * @param that the other point
     */
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    /**
     * Returns the slope between this point and the specified point.
     * Formally, if the two points are (x0, y0) and (x1, y1), then the slope
     * is (y1 - y0) / (x1 - x0). For completeness, the slope is defined to be
     * +0.0 if the line segment connecting the two points is horizontal;
     * Double.POSITIVE_INFINITY if the line segment is vertical;
     * and Double.NEGATIVE_INFINITY if (x0, y0) and (x1, y1) are equal.
     *
     * @param  that the other point
     * @return the slope between this point and the specified point
     */
    public double slopeTo(Point that) {
        if ((that.x == this.x)) {
            if (that.y == this.y) {
                return Double.NEGATIVE_INFINITY;
            }
            return Double.POSITIVE_INFINITY;
        }

        if (that.y == this.y) return +0.0;

        return (double) (that.y - this.y) / (that.x - this.x);
    }

    /**
     * Compares two points by y-coordinate, breaking ties by x-coordinate.
     * Formally, the invoking point (x0, y0) is less than the argument point
     * (x1, y1) if and only if either y0 < y1 or if y0 = y1 and x0 < x1.
     *
     * @param  that the other point
     * @return the value <tt>0</tt> if this point is equal to the argument
     *         point (x0 = x1 and y0 = y1);
     *         a negative integer if this point is less than the argument
     *         point; and a positive integer if this point is greater than the
     *         argument point
     */
    public int compareTo(Point that) {
        if (this.y > that.y) { return 1; }
        if (this.y < that.y) { return -1; }
        return Integer.compare(this.x, that.x);
    }

    /**
     * Compares two points by the slope they make with this point.
     * The slope is defined as in the slopeTo() method.
     *
     * @return the Comparator that defines this ordering on points
     */
    public Comparator<Point> slopeOrder() {
//        if (slopeOrder == null) {
//            slopeOrder = new SlopeOrder();
//        }
//        return slopeOrder;
        return new SlopeOrder();
    }

    private class SlopeOrder implements Comparator<Point> {
        public int compare (Point p1, Point p2) {
            double slope1, slope2;

            slope1 = Point.this.slopeTo(p1);
            slope2 = Point.this.slopeTo(p2);

//            StdOut.println(slope1);
//            StdOut.println(slope2);
//            StdOut.println("");

            return Double.compare(slope1, slope2);
        }
    }

    /**
     * Returns a string representation of this point.
     * This method is provide for debugging;
     * your program should not rely on the format of the string representation.
     *
     * @return a string representation of this point
     */
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    /**
     * Unit tests the Point data type.
     */
    public static void main(String[] args) {
        Point t1p = new Point(429, 449);
        Point t1q = new Point(429, 13);
        Point t1r = new Point(228, 401);
        assert t1p.slopeOrder().compare(t1q, t1r) > 0;

        Point t2p = new Point(3, 9);
        Point t2q = new Point(5, 9);
        Point t2r = new Point(1, 9);
        assert t2p.slopeOrder().compare(t2q, t2r) == 0;

        Point t3p = new Point(4, 2);
        Point t3q = new Point(4, 2);
        Point t3r = new Point(4, 2);
        assert t3p.slopeOrder().compare(t3q, t3r) == 0;

        assert t3p.compareTo(t3q) == 0;

    }
}
