public class TreeNode implements Comparable<TreeNode> {
    public int value;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;

    public TreeNode(int value) {
        this.value = value;
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    @Override
    public int compareTo(TreeNode other) {
        return Integer.compare(this.value, other.value);
    }
}
