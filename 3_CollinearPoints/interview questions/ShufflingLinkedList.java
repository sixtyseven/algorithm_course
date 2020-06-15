/***
 * Shuffling a linked list.
 * Given a singly-linked list containing nnn items,
 * rearrange the items uniformly at random.
 * Your algorithm should consume a logarithmic (or constant) amount of extra memory and
 * run in time proportional to N*log⁡N in the worst case.
 *
 * Hint: design a linear-time subroutine that can take two uniformly
 * shuffled linked lists of sizes n1 and n2 and combined
 * them into a uniformly shuffled linked lists of size n1 + n2.
 *
 */
public class ShufflingLinkedList {

    private static void merge (Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        for (int k= lo; k <=hi; k++) {
            aux[k] = a[k];  // copy
        }
        int i=lo, j=mid+1;
        for (int k=lo; k<=hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            }
            else if (Math.random() >= 0.5) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    private static void shuffle(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;

        shuffle (a, aux, mid+1, hi);
        shuffle (a, aux, lo, mid);
        merge(a, aux, lo, mid, hi);
    }

    public static void shuffle (Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        shuffle(a, aux, 0, a.length-1);
    }
    public static void main(String[] args) {
        Integer arr[] = new Integer[] {1,2,3,4,5,6,7,8,9,10};
        ShufflingLinkedList.shuffle(arr);
        for (int item:arr) {
            System.out.println(item);
        }
    }
}
