public class InsertionSort extends Sorter {
    public InsertionSort(int[] arr, boolean verbose) {
        super(arr, "InsertionSort", verbose);
    }

    @Override
    public void sort() {
        this.checks = 0;
        this.totalSwaps = 0;
        for (int i = 1; i < this.arr.length; i++) {
            displayArr();
            int j = i;
            int temp = arr[i];
            while (j > 0 && temp < this.arr[j - 1]) {
                this.arr[j] = this.arr[j - 1];
                j -= 1;
                this.totalSwaps += 1;
                this.checks += 1;
            }
            arr[j] = temp;
        }
        displayArr();
        displayStats();
    }

    @Override
    public void test() {
        InsertionSort i = new InsertionSort(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1}, true);
        i.sort();
    }
}
