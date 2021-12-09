package leetcode.daily.no538;

import tree.TreeNode;

import java.util.Arrays;
import java.util.List;

/**
 * @description: 538. 把二叉搜索树转换为累加树
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 * 例如：
 * 输入: 原始二叉搜索树:
 * 5
 * /   \
 * 2     13
 * 输出: 转换为累加树:
 * 18
 * /   \
 * 20     13
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: VzivZ
 * @date: 2020-09-21 15:10
 **/
public class ToGreaterTree {
    private int num = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            //遍历右子树
            convertBST(root.right);
            //遍历顶点
            root.val = root.val + num;
            num = root.val;
            //遍历左子树
            convertBST(root.left);
            return root;
        }
        return null;
    }

    public static void main(String[] args) {
        //lamada表达式中foreach使用break
        List<String> c = Arrays.asList("6666", "7777", "8888", "9999");
        c.forEach(str -> {
            if ("8888".equals(str)) {
                return; //跳出当前循环,继续下一轮
            }
            System.out.println(str);

        });
    }
}
