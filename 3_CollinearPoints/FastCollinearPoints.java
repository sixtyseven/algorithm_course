import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Objects;

public class FastCollinearPoints {
    private int numOfSegments;
    private LineSegment[] lineSegments;

    public FastCollinearPoints(Point[] rawPoints) {     // finds all line segments containing 4 or more points
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

        Point[] pointsCopy2 = new Point[pointsLen];
        System.arraycopy(pointsCopy, 0, pointsCopy2, 0, pointsLen);

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
            Arrays.sort(pointsCopy2);
            Arrays.sort(pointsCopy2, p.slopeOrder());

            // loop though pointsCopy
            for (int j = 1; j < pointsLen - 1; j++) {
                Point segmentSecondPoint = null;
                int sameSlopeCount = 1;
                double slope = p.slopeTo(pointsCopy2[j]);
//                StdOut.println(" ");
//                StdOut.println("j " + j);
//                StdOut.println("slope " + slope);

                while (j < pointsLen - 1) {
                    double slope2 = p.slopeTo(pointsCopy2[j+1]);
//                    StdOut.println("slope2 " + slope2);
                    if (slope == slope2) {
                        sameSlopeCount++;

                        if (sameSlopeCount == 2) {
                            segmentSecondPoint = pointsCopy2[j];
                        }
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

                if (sameSlopeCount >= 3 && segmentSecondPoint.compareTo(p) > 0) {
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

    private static <T> boolean contains(final T[] arr, final T v) {
        for (final T e : arr) {
            if (Objects.equals(v, e)) {
                return true;
            }
        }

        return false;
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
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        StdOut.println("");
        StdOut.println("Print out collinear segments " + collinear.segments().length);
        StdOut.println("Time Elapsed " + timeElapsed);
    }
}