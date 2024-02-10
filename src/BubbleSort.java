public class BubbleSort extends Sorter {

    public BubbleSort(int[] arr, boolean verbose) {
        super(arr, "BubbleSort", verbose);
    }

    @Override
    public void sort() {
        int swaps = 1;
        this.checks = 0;
        this.totalSwaps = 0;
        while (swaps != 0) {
            displayArr();
            swaps = 0;
            for (int i = 0; i < this.arr.length - 1; i++) {
                if (super.arr[i] > this.arr[i + 1]) {
                    swaps += 1;
                    swap(arr, i, i + 1);
                    this.totalSwaps += 1;
                }
                this.checks += 1;
            }
        }
        displayArr();
        displayStats();
    }

    @Override
    public void test() {
        BubbleSort b = new BubbleSort(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1}, true);
        b.sort();
    }
}
