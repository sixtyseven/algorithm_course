/**
 * Counting inversions.
 * An inversion in an array a[] is a pair of entries a[i] and a[j] such that i<j < but a[i]> a[j].
 * Given an array, design a linearithmic algorithm to count the number of inversions.
 *
 * Hint: count while mergesorting.
 */
public class CountingInversion {
    private static int merge (Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        for (int k= lo; k <=hi; k++) {
            aux[k] = a[k];  // copy
        }

        int inversionCount = 0;
        int i=lo, j=mid+1;
        for (int k=lo; k<=hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            }
            else if (j > hi) {
                Comparable temp = aux[i++];
                a[k] = temp;
            }
            else if ((aux[j].compareTo(aux[i])) < 0) {
                inversionCount += (mid+1) - i;
                Comparable temp = aux[j++];
                a[k] = temp;
            }
            else a[k] = aux[i++];
        }
        return inversionCount;
    }

    private static int sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) return 0;
        int mid = lo + (hi - lo) / 2;

        int v1 = sort (a, aux, mid+1, hi);
        int v2 = sort (a, aux, lo, mid);
        return v1 + v2 + merge(a, aux, lo, mid, hi);
    }

    public static int sort (Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        return sort(a, aux, 0, a.length-1);
    }

    public static void main(String[] args) {
        assert CountingInversion.sort(new Integer[] {5, 4}) == 1;
        assert CountingInversion.sort(new Integer[] {5, 4, 3}) == 3;
        assert CountingInversion.sort(new Integer[] {5, 4, 3, 2}) == 6;
        assert CountingInversion.sort(new Integer[] {1, 20, 6, 4, 5, 30, 40, 2, 6}) == 14;
    }
}
