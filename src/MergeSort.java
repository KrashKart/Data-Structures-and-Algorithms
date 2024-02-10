public class MergeSort extends Sorter {

    public MergeSort(int[] arr, boolean verbose) {
        super(arr, "MergeSort", verbose);
    }

    @Override
    public void sort() {
        displayArr();
        mergeAndSort(0, this.arr.length);
        displayArr();
        displayStats();
    }

    public void mergeAndSort(int start, int end) {
        if (start < end - 1) {
            int mid = (end - start) / 2 + start;
            mergeAndSort(start, mid);
            mergeAndSort(mid, end);
            merge(start, end);
        }
    }

    public void merge(int start, int end) {
        // technically insertion sort. I wanted to sort in-place and couldnt find
        // an algorithm for O(n) inplace sorting, so let's pretend
        for (int p = start + 1; p < end; p++) {
            boolean swapped = false;
            int j = p;
            int temp = arr[p];
            while (j > 0 && temp < this.arr[j - 1]) {
                this.arr[j] = this.arr[j - 1];
                j -= 1;
                swapped = true;
            }
            arr[j] = temp;
            if (swapped) {
                this.totalSwaps += 1;
                this.checks += 1;
            }
        }
    }

    @Override
    public void test() {
        MergeSort m = new MergeSort(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1}, true);
        m.sort();
    }
}
