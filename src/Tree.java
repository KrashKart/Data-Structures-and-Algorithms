public class Tree {
    private TreeNode root;

    public Tree() {
        this.root = null;
    }

    public boolean insert(int value) {
        TreeNode newNode = new TreeNode(value);
        if (this.root == null) {
            this.root = newNode;
            return true;
        }
        TreeNode pointer = this.root;
        while (true) {
            if (value == pointer.value) {
                return false;
            } else if (pointer.value > value) {
                if (pointer.left == null) {
                    pointer.left = newNode;
                    break;
                }
                pointer = pointer.left;
            } else {
                if (pointer.right == null) {
                    pointer.right = newNode;
                    break;
                }
                pointer = pointer.right;
            }
        }
        newNode.parent = pointer;
        return true;
    }

    public boolean delete(int value) {
        TreeNode pointer = this.root;
        while (true) {
            // finding the node
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
        if (pointer.left == null && pointer.right == null) {
            if (parent != null) {
                parent.setChild(pointer, null);
            }
        } else {
            TreeNode nextNode;
            if (pointer.left != null && pointer.right != null) {
                // node has 2 children
                nextNode = findSuccessor(pointer);
                // if successor has 1 child
                if (nextNode.right != null) {
                    delete(nextNode.value);
                }
                nextNode.left = pointer.left;
                nextNode.right = pointer.right;
            } else {
                // node has 1 child
                nextNode = pointer.left != null ? pointer.left : pointer.right;
            }
            nextNode.parent = parent;
            if (parent != null) {
                parent.setChild(pointer, nextNode);
            } else {
                this.root = nextNode;
            }
        }
        pointer.clearChild();
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
        t.insert(7);
        t.insert(6);
        t.insert(8);
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

        t.delete(9);
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
