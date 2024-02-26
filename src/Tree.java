public class Tree {
    private TreeNode root;

    public Tree() {
        this.root = null;
    }

    public boolean insert(int value) {
        TreeNode newNode = new TreeNode(value);

        if (this.root == null) {
            root = newNode;
            return true;
        } else {
            TreeNode pointer = this.root;
            while (true) {
                if (newNode.compareTo(pointer) == -1) {
                    if (pointer.left == null) {
                        pointer.left = newNode;
                        newNode.parent = pointer;
                        return true;
                    }
                    pointer = pointer.left;
                } else if (newNode.compareTo(pointer) == 0) {
                    return false;
                } else {
                    if (pointer.right == null) {
                        pointer.right = newNode;
                        newNode.parent = pointer;
                        return true;
                    }
                    pointer = pointer.right;
                }
            }
        }
    }

    public boolean delete(int value) {
        TreeNode pointer = this.root;
        while (true) {
            if (pointer == null) {
                return false;
            } else if (pointer.value == value) {
                break;
            } else if (pointer.value < value) {
                pointer = pointer.right;
            } else {
                pointer = pointer.left;
            }
        }

        TreeNode parent = pointer.parent;
        String dir = parent.left == pointer ? "left" : "right";
        if (dir.equals("left")) {
            parent.left = null;
        } else {
            parent.right = null;
        }
        pointer.parent = null;

        if (pointer.left != null && pointer.right != null) {
            // 2 children
            TreeNode succ = findSuccessor(pointer);
            // if successor has 1 child
            if (succ.right != null) {
                succ.parent.left = succ.right;
                succ.right.parent = succ.parent;
                succ.right = null;
            }
            if (dir.equals("left")) {
                parent.left = succ;
            } else {
                parent.right = succ;
            }
            succ.parent = parent;
            succ.left = pointer.left;
        } else if (pointer.left != null || pointer.right != null) {
            // 1 child
            TreeNode child = pointer.left != null ? pointer.left : pointer.right;
            if (dir.equals("left")) {
                parent.left = child;
            } else {
                parent.right = child;
            }
            child.parent = parent;
        }
        return true;
    }

    public TreeNode findMin(TreeNode start) {
        if (start.left == null) {
            return start;
        }
        return findMin(start.left);
    }

    public TreeNode findSuccessor(TreeNode node) {
        if (node.right != null) {
            return findMin(node.right);
        }
        TreeNode parent = node.parent;
        TreeNode child = node;
        while (parent != null && child == parent.right) {
            child = parent;
            parent = child.parent;
        }
        return parent;
    }

    public boolean contains(int value) {
        TreeNode pointer = this.root;
        while (pointer != null && pointer.value != value) {
            if (pointer.value < value) {
                pointer = pointer.right;
            } else {
                pointer = pointer.left;
            }
        }
        return pointer != null;
    }

    public static void main(String[] args) {
        // driver code to test btree
        Tree t = new Tree();
        t.insert(5);
        t.insert(3);
        t.insert(4);
        t.insert(2);
        t.insert(1);
        t.insert(6);
        t.insert(8);
        t.insert(7);
        t.insert(9);
        t.insert(10);
        boolean accumBefore = true;
        for (int i = 1; i < 11; i++) {
            if (!t.contains(i)) {
                System.out.println(i);
            }
            accumBefore &= t.contains(i);
        }
        System.out.println(accumBefore);

        t.delete(3);
        boolean accumAfter = true;
        for (int i = 1; i < 11; i++) {
            if (!t.contains(i)) {
                System.out.println(i);
            }
            accumAfter &= t.contains(i);
        }
        System.out.println(accumAfter);
    }
}
