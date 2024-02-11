public class MergeSort extends Sorter {

    public MergeSort(int[] arr, boolean verbose) {
        super(arr, "MergeSort", verbose);
    }

    @Override
    public void sort() {
        displayArr();
        this.arr = mergeAndSort(this.arr);
        displayArr();
        displayStats();
    }

    public int[] mergeAndSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int mid = arr.length / 2;
        int[] left = new int[mid], right = new int[arr.length - mid];
        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);
        left = mergeAndSort(left);
        right = mergeAndSort(right);
        return merge(left, right);
    }

    public int[] merge(int[] left, int[] right) {
        int i = 0, j = 0, counter = 0;
        int[] res = new int[left.length + right.length];
        while (i < left.length && j < right.length) {
            if (right[j] < left[i]) {
                res[counter] = right[j];
                j += 1;
                this.totalSwaps += left.length - i;
            } else {
                res[counter] = left[i];
                i += 1;
            }
            counter += 1;
            checks += 1;
        }

        while (i < left.length) {
            res[counter] = left[i];
            counter += 1;
            i += 1;
        }

        while (j < right.length) {
            res[counter] = right[j];
            counter += 1;
            j += 1;
        }
        displayArr(res);
        return res;
    }

    @Override
    public void test() {
        MergeSort m = new MergeSort(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1}, true);
        m.sort();
    }

    public static void main(String[] args) {
        MergeSort m = new MergeSort(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1}, true);
        m.sort();
    }
}
