/***
 * Merging with smaller auxiliary array.
 * Suppose that the subarray a[0] to a[n−1] is sorted and
 * the subarray a[n] to a[2∗n−1] is sorted.
 * How can you merge the two subarrays so that a[0] to a[2∗n−1]
 * is sorted using an auxiliary array of length nnn (instead of 2n)?
 *
 * Hint: copy only the left half into the auxiliary array.
 */
public class MergeSmallerAux {
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        System.out.println("");
        System.out.println("merge() ");

        System.out.println("auxLen: " + aux.length);
        int auxActualLenMinusOne = mid-lo;
        System.out.println("auxActualLenMinusOne: " + auxActualLenMinusOne);
        System.out.println("a.len: " + a.length);
        System.out.println("lo: " + lo);
        System.out.println("mid: " + mid);
        System.out.println("hi: " + hi);

        for (Comparable item : a) {
            System.out.println("a: " + item);
        }

        for (int k=lo, x=0; x <= auxActualLenMinusOne; k++) {
            Comparable temp = a[k];
            System.out.println("x: " + x);
            aux[x++] = temp;
        }

        for (Comparable item : aux) {
            System.out.println("aux: "  + item);
        }

        int iiii = 0,
            jjjj = mid + 1;

        for (int k=lo; k<=hi; k++) {
            if (iiii > auxActualLenMinusOne) {
                System.out.println("s1");
                break;
            }
            else if (jjjj > hi) {
                System.out.println("s2");
                a[k] = aux[iiii++];
            }
            else if (a[jjjj].compareTo(aux[iiii]) < 0) {
                System.out.println("s3");
                a[k] = a[jjjj++];
            }
            else {
                System.out.println("s4");
                a[k] = aux[iiii++];
            }
        }
        System.out.println("");
        for (Comparable item : a) {
            System.out.println("a after : " + item);
        }
        System.out.println("");
    }

    private static void mergeOrigin(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        for ( int k=lo; k<=hi; k++) {
            aux[k] = a[k];
        }

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if(aux[j].compareTo(aux[i]) < 0) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        System.out.println("");

        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;

        sort(a, aux, lo, mid);
        sort(a, aux, mid+1, hi);
        merge(a, aux, lo, mid, hi);
//        mergeOrigin(a, aux, lo, mid, hi);
    }

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[(a.length + 1) / 2];
//        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    public static void main(String[] args) {
//        Integer arr[] = new Integer[]{111, 20};
//        Integer arr[] = new Integer[]{111, 20, 50, 40};
//        Integer arr[] = new Integer[]{111, 20, 50};

        Integer arr[] = new Integer[]{111, 20, 50, 40, 30, 60, 50};
        MergeSmallerAux msa = new MergeSmallerAux();
        msa.sort(arr);
        for (Integer integer : arr) {
            System.out.println(integer);
        }
    }
}
