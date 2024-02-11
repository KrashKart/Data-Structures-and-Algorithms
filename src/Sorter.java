abstract public class Sorter {
    protected int[] arr;
    protected String name;
    protected boolean verbose;
    protected int totalSwaps = 0;
    protected int checks = 0;

    public Sorter(int[] arr, String name, boolean verbose) {
        this.arr = arr;
        this.name = name;
        this.verbose = verbose;
    }

    abstract public void sort();

    abstract public void test();

    public boolean isSorted() {
        for (int i = 1; i < this.arr.length; i++) {
            if (this.arr[i] < this.arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void displayArr() {
        if (this.verbose) {
            String s = "[";
            for (int i = 0; i < this.arr.length; i++) {
                if (i == this.arr.length - 1) {
                    s += String.format("%d]", this.arr[i]);
                } else {
                    s += String.format("%d, ", this.arr[i]);
                }
            }
            System.out.printf("%s: %s\n", this.name, s);
        }
    }

    public void displayArr(int[] arr) {
        if (this.verbose) {
            String s = "[";
            for (int i = 0; i < arr.length; i++) {
                if (i == arr.length - 1) {
                    s += String.format("%d]", arr[i]);
                } else {
                    s += String.format("%d, ", arr[i]);
                }
            }
            System.out.printf("%s: %s\n", this.name, s);
        }
    }

    public void displayStats() {
        System.out.printf("%s\nTotal Swaps: %d\nTotal Checks: %d\n", this.name, this.totalSwaps, this.checks);
    }
}
