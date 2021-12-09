package leetcode.daily.no039;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author: HeZhe
 * @date: 2020-09-11 19:47
 **/
public class NAryTree {
    private List<Integer> list = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if (root == null) return list;
        list.add(root.val);
        for (Node child : root.children) {
            preorder(child);
        }
        return list;
    }

    public static void main(String[] args) {
        NAryTree tree = new NAryTree();

        Node node5 = new Node(5,new ArrayList<>());
        Node node6 = new Node(6,new ArrayList<>());
        List<Node> node3Children = new LinkedList<>();
        node3Children.add(node5);
        node3Children.add(node6);
        Node node3 = new Node(3, node3Children);

        Node node2 = new Node(2,new ArrayList<>());
        Node node4 = new Node(4,new ArrayList<>());

        List<Node> rootChildren = new LinkedList<>();
        rootChildren.add(node3);
        rootChildren.add(node2);
        rootChildren.add(node4);
        Node root = new Node(1, rootChildren);
        System.out.println(tree.preorder(root));

    }

}


class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};