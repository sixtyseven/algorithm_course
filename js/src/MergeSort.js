

function mergeSort(arr) {
    let arrClone = [];
    for (let i = 0; i< arr.length; i++) {
        arrClone[i] = arr[i];
    }

    sort(arrClone, arr, 0, arr.length - 1);
    return arr;
}

function sort(src, dst, lo, hi) {
    if (hi <= lo) {
        return;
    }

    let mid = lo + Math.floor((hi - lo) / 2);
    sort(dst, src, lo, mid);
    sort(dst, src, mid+1, hi);

    if (!less(src[mid+1], src[mid])) {
        for (let i = lo; i <= hi; i++) {
            dst[i] = src[i];
        }
        return;
    }

    merge(src, dst, lo, mid, hi);

}

function merge(src, dst, lo, mid, hi) {
    let i = lo,
        j = mid + 1;

    for ( let k = lo; k <= hi; k++ ) {
        if (i > mid) {
            dst[k] = src[j++];
        } else if (j > hi) {
            dst[k] = src[i++];
        } else if (less(src[j], src[i])) {
            dst[k] = src[j++];
        } else {
            dst[k] = src[i++];
        }
    }
}

function less(a, b) {
    return a < b;
}



console.log(mergeSort([10, 1,2,4,3,5,8,9,7,6]));

