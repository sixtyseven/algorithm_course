import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;


public class PercolationStats {
    private static final double CONFIDENCE_95 = 1.96;
    private final double mean;
    private final double stddev;
    private final int numberOfSamples;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException();
        }
        double[] fraction = new double[trials];
        numberOfSamples = trials;

        for (int i = 0; i < trials; i++) {
            final Percolation per = new Percolation(n);
            while (!per.percolates()) {
                per.open(StdRandom.uniform(n) + 1, StdRandom.uniform(n) + 1);
            }
            int numOfOpenSites = per.numberOfOpenSites();

            double fra = (double) numOfOpenSites / n / n;

            fraction[i] = fra;
        }
        mean = StdStats.mean(fraction);
        stddev = StdStats.stddev(fraction);
    }

    // sample mean of percolation threshold
    public double mean() {
        return mean;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return stddev;
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean - CONFIDENCE_95 * stddev / Math.sqrt(numberOfSamples);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean + CONFIDENCE_95 * stddev / Math.sqrt(numberOfSamples);
    }

    // test client (see below)
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        PercolationStats per = new PercolationStats(n, trials);
        System.out.println("v1                         ");
        System.out.println("mean                        = " + per.mean());
        System.out.println("stddev                      = " + per.stddev());
        System.out.println("95% confidence interval low = " + per.confidenceLo());
        System.out.println("95% confidence interval hi  = " + per.confidenceLo());
    }

}