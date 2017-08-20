package com.datastructures;

/**
 * Created by xhans on 2016/2/26.
 */
public class AvlTree<T extends Comparable<? super T>>  {
    private static class AvlNode<T> {
        AvlNode(T theElement){
            this(theElement, null, null);
        }
        AvlNode(T theElement, AvlNode<T> lt, AvlNode<T> rt){
            element = theElement;
            left = lt;
            right = lt;
            height = 0;
        }

        T element;
        AvlNode<T> left;
        AvlNode<T> right;
        int height;
    }

    //空树的高度为-1
    private int height(AvlNode<T> t){
        return t == null ? -1 : t.height;
    }

    private AvlNode<T> insert(T x, AvlNode<T> t){
        if (t == null){
            return new AvlNode<T>(x, null, null);
        }

        int compareResult = x.compareTo(t.element);

        if (compareResult < 0){
            t.left = insert(x, t.left);
        } else if (compareResult > 0){
            t.right = insert(x, t.right);
        } else {

        }
        return balance(t);
    }

    private static final int ALLOWED_IMBALANCE = 1;

    private AvlNode<T> balance(AvlNode<T> t){
        if (t == null){
            return t;
        }

        //左子树不平衡
        if (height(t.left) - height(t.right) > ALLOWED_IMBALANCE){
            if (height(t.left.left) >= height(t.left.right)) {//LL
                t = rotateWithLeftChild(t);
            } else {//LR
                t = doubleWithLeftChild(t);
            }
        } else if (height(t.right) - height(t.left) > ALLOWED_IMBALANCE){ //右子树不平衡
            if (height(t.right.right) >= height(t.right.left)){//RR
                t = rotateWithRightChild(t);
            } else { //RL
                t = doubleWithRightChild(t);
            }
        }

        t.height = Math.max(height(t.left), height(t.right)) + 1;
        return t;
    }

    //LL
    private AvlNode<T> rotateWithLeftChild(AvlNode<T> k2){
        AvlNode<T> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;
        return k1;
    }

    //RR
    private AvlNode<T> rotateWithRightChild(AvlNode<T> k1){
        AvlNode<T> k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
        k2.height = Math.max(k1.height, height(k2.right));
        return k2;
    }

    //LR
    private AvlNode<T> doubleWithLeftChild(AvlNode<T> k3){
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    private AvlNode<T> doubleWithRightChild(AvlNode<T> k1){
        k1.right = rotateWithLeftChild(k1.right);
        return rotateWithRightChild(k1);
    }

    private AvlNode<T> remove(T x, AvlNode<T> t){
        if (t == null) {
            return t;
        }

        int compareResult = x.compareTo(t.element);

        if (compareResult < 0){
            t.left = remove(x, t.left);
        } else if (compareResult > 0){
            t.right = remove(x, t.right);
        } else if (t.left != null && t.right != null) {
            //有两个孩子
            t.element = findMin(t.right).element;
            t.right = remove(t.element, t.right);
        } else {
            t = (t.left != null) ? t.left : t.right;
        }
        return balance(t);
    }

    private AvlNode<T> findMin(AvlNode<T> t){
        if (t == null){
            return null;
        } else if (t.left == null){
            return t;
        }
        return findMin(t.left);
    }

    private AvlNode<T> findMax(AvlNode<T> t) {
        if (t != null){
            while (t.right != null) {
                t = t.right;
            }
        }
        return t;
    }
}
