public class SelectionSort extends Sorter{
    public SelectionSort(int[] arr, boolean verbose) {
        super(arr, "SelectionSort", verbose);
    }

    @Override
    public void sort() {
        this.checks = 0;
        this.totalSwaps = 0;
        int smallestIdx;
        for (int i = 0; i < this.arr.length; i++) {
            displayArr();
            smallestIdx = findSmallestIndex(i, this.arr.length);
            swap(this.arr, smallestIdx, i);
            this.totalSwaps += 1;
        }
        displayArr();
        displayStats();
    }

    public int findSmallestIndex(int start, int end) {
        int smallest = this.arr[start];
        int idx = start;
        for (int j = start + 1; j < end; j++) {
            if (this.arr[j] < smallest) {
                smallest = this.arr[j];
                idx = j;
            }
            this.checks += 1;
        }
        return idx;
    }

    @Override
    public void test() {
        SelectionSort s = new SelectionSort(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1}, true);
        s.sort();
    }
}
