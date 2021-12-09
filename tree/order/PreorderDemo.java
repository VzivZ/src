package tree.order;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description:
 * @author: VzivZ
 * @date: 2020-09-14 17:02
 **/
public class PreorderDemo {

    //中序
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                //前序就写在这
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }

    //后序，采用两个栈，第一个栈先左子节点，再放右子节点，然后每次弹出一个元素，放入到第二个栈中。最后第二个栈依次弹出每个元素。
    //后序遍历，非递归
    public static List<Integer> postOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        TreeNode p = null;//用来记录上一节点
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
//            后序遍历的过程中在遍历完左子树跟右子树cur都会回到根结点。所以当前不管是从左子树还是右子树回到根结点都不应该再操作了，应该退回上层。
//            如果是从右边再返回根结点，应该回到上层。
            //主要就是判断出来的是不是右子树，是的话就可以把根节点=加入到list了
            if (cur.right == null || cur.right == p) {
                list.add(cur.val);
                stack.pop();
                p = cur;
                cur = null;
            } else {
                cur = cur.right;
            }

        }
        return list;
    }

}
