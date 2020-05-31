import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

public class BruteCollinearPoints {
    private int numOfSegments;
    private LineSegment[] lineSegments;

    public BruteCollinearPoints(Point[] points)    // finds all line segments containing 4 points
    {
        if (points == null) {
            throw new IllegalArgumentException();
        }

        for (Point point : points) {
            if (point == null) {
                throw new IllegalArgumentException();
            }
        }

        int pointsLen = points.length;
        Point[] pointsCopy = new Point[pointsLen];
        System.arraycopy(points, 0, pointsCopy, 0, pointsLen);

        Arrays.sort(pointsCopy);

        for (int i = 0; i < (pointsLen - 1); i++) {
            if (pointsCopy[i].compareTo(pointsCopy[i+1]) == 0) {
                throw new IllegalArgumentException();
            }
        }

        numOfSegments = 0;
        lineSegments = new LineSegment[1];

        for (int i=0; i < (pointsLen-3); i++) {
            for (int j=i+1; j < (pointsLen-2); j++) {
                for( int k=j+1; k < (pointsLen-1); k++) {
                    for(int l=k+1; l< pointsLen; l++) {
                        if (pointsCopy[i].slopeTo(pointsCopy[j]) == pointsCopy[i].slopeTo(pointsCopy[k]) &&
                                pointsCopy[i].slopeTo(pointsCopy[j]) == pointsCopy[i].slopeTo(pointsCopy[l])) {

//                            StdOut.println(11111);
//                            StdOut.println(numOfSegments);
                            LineSegment lineSegment = new LineSegment(pointsCopy[i], pointsCopy[l]);
                            if (numOfSegments > lineSegments.length - 1) {
//                                StdOut.println(22222);
//                                StdOut.println(numOfSegments);
//                                StdOut.println(lineSegments.length);
                                copy();
                            }
                            numOfSegments++;
                            lineSegments[numOfSegments-1] = lineSegment;
                        }
                    }
                }
            }
        }
    }

    private void copy() {
        LineSegment[] tmpSegments = new LineSegment[numOfSegments * 2];
        System.arraycopy(lineSegments, 0, tmpSegments, 0, numOfSegments);
        lineSegments = tmpSegments;
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

    /**
     * Unit tests the Point data type.
     */
    public static void main(String[] args) {
        // read the n points from a file
        In in = new In("input8.txt");
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // print and draw the line segments
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        assert collinear.numberOfSegments() == 2;
        StdOut.println("length of segments " + collinear.segments().length);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
        }
    }
}