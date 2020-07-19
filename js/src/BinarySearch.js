/**
 * Binary search: pass arr and search item.
 * return the item idx if found,
 * Or else return -1;
 *
 * @param arr
 * @param key
 * @returns {number}
 */
function binarySearch(arr, key) {
    let lo = 0;
    let hi = arr.length - 1;
    while (lo <= hi) {
        let mid = lo + Math.floor((hi - lo) / 2);
        if ( key < arr[mid]) {
            hi = mid - 1;
        } else if ( key > arr[mid]) {
            lo = mid + 1;
        } else {
            return mid;
        }
    }
    return -1;
}

console.log(binarySearch([1,2,3,4,5], 2));
console.log(binarySearch([1,2,3,4,5,6], 2));
console.log(binarySearch([1,2,3,4,5], 6));