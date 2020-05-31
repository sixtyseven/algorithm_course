import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class FastCollinearPointsHashmap {
    private int numOfSegments;
    private LineSegment[] lineSegments;
    private HashMap<Double, ArrayList<Point>> slopeEndPoints = new HashMap<Double, ArrayList<Point>>();

    public FastCollinearPointsHashmap(Point[] rawPoints) {     // finds all line segments containing 4 or more points
        if (rawPoints == null) {
            throw new IllegalArgumentException();
        }

        for (Point point : rawPoints) {
            if (point == null) {
                throw new IllegalArgumentException();
            }
        }

        int pointsLen = rawPoints.length;
        Point[] pointsCopy = new Point[pointsLen];
        System.arraycopy(rawPoints, 0, pointsCopy, 0, pointsLen);
        Arrays.sort(pointsCopy);

        for (int i = 0; i < (pointsLen - 1); i++) {
            if (pointsCopy[i].compareTo(pointsCopy[i+1]) == 0) {
                throw new IllegalArgumentException();
            }
        }

//        Point[] pointsCopy2 = new Point[pointsLen];
//        System.arraycopy(pointsCopy, 0, pointsCopy2, 0, pointsLen);

//        StdOut.println(rawPoints.length);
//        for (Point p: pointsCopy) {
//            StdOut.println(p);
//        }

        numOfSegments = 0;
        lineSegments = new LineSegment[1];

        // loop though points
        for (int i = 0; i < (pointsLen - 3); i++) {
            Point p = pointsCopy[i];
//            StdOut.println("");
//            StdOut.println("Point i " + i + " "  + p);

            Point[] pointsCopy2 = Arrays.copyOfRange(pointsCopy, i+1, pointsLen);
//            StdOut.println("points2 length " + pointsCopy2.length);
            Arrays.sort(pointsCopy2, p.slopeOrder());

            // loop though pointsCopy
            for (int j = 0; j < pointsCopy2.length - 1; j++) {
                int sameSlopeCount = 1;
                double slope = p.slopeTo(pointsCopy2[j]);
//                StdOut.println(" ");
//                StdOut.println("j " + j);
//                StdOut.println("slope " + slope);

                while (j < pointsCopy2.length - 1) {
                    double slope2 = p.slopeTo(pointsCopy2[j+1]);
//                    StdOut.println("slope2 " + slope2);
                    if (slope == slope2) {
                        sameSlopeCount++;
                        j++;
                    } else {
                        break;
                    }
                }

//                StdOut.println("sameSlopeCount " + sameSlopeCount);
//                StdOut.println("segmentSecondPoint " + segmentSecondPoint);
//                StdOut.println("p " + p);
//                if (segmentSecondPoint != null) {
//                    StdOut.println("segmentSecondPoint.compareTo(p) " + segmentSecondPoint.compareTo(p));
//                    StdOut.println("segmentSecondPoint.compareTo(p) " + segmentSecondPoint.compareTo(p));
//                }

                if (sameSlopeCount >= 3 && !segmentAdded(slope, pointsCopy2[j])) {
                    numOfSegments++;

                    LineSegment lineSegment = new LineSegment(p, pointsCopy2[j]);
//                    StdOut.println("numOfSegments " + numOfSegments);
//                    StdOut.println(" sameSlopeCount " +  sameSlopeCount);
//                    StdOut.println(" segmentSecondPoint " +  segmentSecondPoint);
//                    StdOut.println(" lineSegment " +  lineSegment);
                    if (numOfSegments > lineSegments.length) {
                        lineSegments = doubleArray(lineSegments, numOfSegments-1);
                    }
                    lineSegments[numOfSegments-1] = lineSegment;
                }
            }
        }
    }

    private boolean segmentAdded(double slope, Point p){
        ArrayList<Point> endPoints = this.slopeEndPoints.get(slope);

        if (endPoints == null) {
            endPoints = new ArrayList<Point>();
            endPoints.add(p);
            this.slopeEndPoints.put(slope, endPoints);
        } else if (endPoints.contains(p)) {
            return true;
        } else {
            endPoints.add(p);
            this.slopeEndPoints.put(slope, endPoints);
        }
        return false;
    }

    private static LineSegment[] doubleArray(LineSegment[] arr, int size) {
        LineSegment[] copy = new LineSegment[size * 2];
        for (int i = 0; i < size; i++) {
            copy[i] = arr[i];
        }
        return copy;
    }

    private static Double[] doubleArray(Double[] arr, int size) {
        Double[] copy = new Double[size * 2];
        for (int i = 0; i < size; i++) {
            copy[i] = arr[i];
        }
        return copy;
    }

    public  int numberOfSegments()        // the number of line segments
    {
        return numOfSegments;
    }
    public LineSegment[] segments()                // the line segments
    {
        return getSliceOfArray(lineSegments, numOfSegments);
    }

    private static LineSegment[] getSliceOfArray(LineSegment[] arr, int end)
    {
        // Get the slice of the Array
        LineSegment[] slice = new LineSegment[end];

        // Copy elements of arr to slice
        for (int i = 0; i < end; i++) {
            slice[i] = arr[i];
        }

        // return the slice
        return slice;
    }

    public static void main(String[] args) {

        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        long start = System.currentTimeMillis();
        FastCollinearPointsHashmap collinear = new FastCollinearPointsHashmap(points);
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        StdOut.println("v5");
        StdOut.println("Print out collinear segments " + collinear.segments().length);
        StdOut.println("Time Elapsed " + timeElapsed);
    }
}