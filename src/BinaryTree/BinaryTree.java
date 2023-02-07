package BinaryTree;

/*
 * @Author: Ereflect
 * @Date: 2023-02-07 12:27:02
 * @LastEditors: Please set LastEditors
 * @LastEditTime: 2023-02-07 12:29:43
 * @Description: 请填写简介
 * 
 */
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
private TreeNode root;

public void insert(int value) {
    if (root == null) {
        root = new TreeNode(value);
    } else {
        insertRecursive(root, value);
    }
}

private void insertRecursive(TreeNode current, int value) {
    if (value < current.val) {
        if (current.left == null) {
            current.left = new TreeNode(value);
        } else {
            insertRecursive(current.left, value);
        }
    } else if (value > current.val) {
        if (current.right == null) {
            current.right = new TreeNode(value);
        } else {
            insertRecursive(current.right, value);
        }
    }
}

public void delete(int value) {
    root = deleteRecursive(root, value);
}

private TreeNode deleteRecursive(TreeNode current, int value) {
    if (current == null) {
        return null;
    }
    if (value == current.val) {
        if (current.left == null && current.right == null) {
            return null;
        }
        if (current.right == null) {
            return current.left;
        }
        if (current.left == null) {
            return current.right;
        }
        int smallestValue = findSmallestValue(current.right);
        current.val = smallestValue;
        current.right = deleteRecursive(current.right, smallestValue);
        return current;
    }
    if (value < current.val) {
        current.left = deleteRecursive(current.left, value);
        return current;
    }
    current.right = deleteRecursive(current.right, value);
    return current;
}

private int findSmallestValue(TreeNode root) {
    return root.left == null ? root.val : findSmallestValue(root.left);
}

public void traverseInOrder() {
    traverseInOrderRecursive(root);
}

private void traverseInOrderRecursive(TreeNode current) {
    if (current != null) {
        traverseInOrderRecursive(current.left);
        System.out.print(current.val + " ");
        traverseInOrderRecursive(current.right);
    }
}

    public void traverseLevelOrder() {
        if (root == null) {
            return;
        }

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            TreeNode current = nodes.remove();
            System.out.print(current.val + " ");
            if (current.left != null) {
                nodes.add(current.left);
            }
            if (current.right != null) {
                nodes.add(current.right);
            }
        }
    }
}

