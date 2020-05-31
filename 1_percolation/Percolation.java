import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    // 0 for Blocked site, 1 for Open site, 2 for Open site connected to the bottom
    private final int[] site;
    private final int gridLen;
    private final int idxVirtualTop;
    private final WeightedQuickUnionUF uf;
    private int numOfOpenSite;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        // one for connecting to top row, two for connecting to bottom row.
        int arrayLen = n * n + 1;
        site = new int[arrayLen];
        gridLen = n;
        idxVirtualTop = arrayLen - 1;
        numOfOpenSite = 0;
        uf = new WeightedQuickUnionUF(arrayLen);
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (isOpen(row, col)) {
            return;
        }

        int idx = getIndex(row, col);
        if (row == gridLen) {
            site[idx] = 2;
        } else {
            site[idx] = 1;
        }

        if (row == 1) {
            update(idx, idxVirtualTop);
        } else if (isOpen(row - 1, col)) {
            int topIdx = getIndex(row - 1, col);
            update(idx, topIdx);
        }

        if (col != gridLen && isOpen(row, col + 1)) {
            int rightIdx = getIndex(row, col + 1);
            update(idx, rightIdx);
        }

        if (row != gridLen) {
            int bottomIdx = getIndex(row + 1, col);
            update(idx, bottomIdx);
        }

        if (col != 1 && isOpen(row, col - 1)) {
            int leftIdx = getIndex(row, col - 1);
            update(idx, leftIdx);
        }

        numOfOpenSite++;
    }

    private void update(int openIdx, int adjacentIdx) {
        int previousRoot = uf.find(adjacentIdx);
        int previousRoot2 = uf.find(openIdx);
        uf.union(openIdx, adjacentIdx);
        if (site[openIdx] == 2 || site[previousRoot2] == 2 || site[previousRoot] == 2) {
            int newRoot = uf.find(openIdx);
            site[newRoot] = 2;
        }
    }

    private void validateRowColumn(int row, int col) {
        if (!(row >= 1 && col >= 1 && row <= gridLen && col <= gridLen)) {
            throw new IllegalArgumentException();
        }
    }

    private int getIndex(int row, int col) {
        validateRowColumn(row, col);
        return (row - 1) * gridLen + (col - 1);
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        validateRowColumn(row, col);
        return site[getIndex(row, col)] > 0;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        validateRowColumn(row, col);
        int idx = getIndex(row, col);
        return site[idx] > 0 && (uf.find(idx) == uf.find(idxVirtualTop));
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return numOfOpenSite;
    }

    // does the system percolate?
    public boolean percolates() {
        int root = uf.find(idxVirtualTop);
        return site[root] == 2;
    }

    // test client (optional)
    public static void main(String[] args) {
        Percolation per1 = new Percolation(3);
        per1.open(1, 1);
        assert per1.isOpen(1, 1);
        assert per1.isFull(1, 1);
        assert !per1.isOpen(2, 1);
        assert !per1.isFull(2, 1);
        per1.open(2, 1);
        assert !per1.percolates();
        per1.open(3, 2);
        assert !per1.percolates();
        per1.open(2, 2);
        assert per1.percolates();
        assert per1.numberOfOpenSites() == 4;

        Percolation per2 = new Percolation(5);
        per2.open(1, 1);
        per2.open(2, 1);
        per2.open(3, 1);
        per2.open(4, 1);
        per2.open(5, 1);

        per2.open(5, 4);
        per2.open(4, 4);
        assert !per2.isFull(4, 4);

        Percolation per3 = new Percolation(3);
        per3.open(1, 1);
        per3.open(2, 2);
        per3.open(3, 3);
        assert !per3.percolates();



//        for (int j= 0; j<=100000; j++) {
//
//        }
    }
}
