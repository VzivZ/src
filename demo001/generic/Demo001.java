package demo001.generic;

/**
 * @description:
 * @author: VzivZ
 * @date: 2020-04-10 14:29
 **/
public class Demo001 {
    private static <T extends Number & Comparable<? super T>> T min(T[] values) {
        if (values == null || values.length == 0) return null;
        T min = values[0];
        for (int i = 1; i < values.length; i++) {
            if (min.compareTo(values[i]) > 0) min = values[i];
        }
        return min;
    }

    public static void main(String[] args) {
//        int minInteger = min(new Integer[]{1, 2, 3});//result:1
//        System.out.println(minInteger);
//        double minDouble = min(new Double[]{1.2, 2.2, -1d});//result:-1d
//        System.out.println(minDouble);

        TreeDemo tree001 = new TreeDemo(1);
        TreeDemo tree002 = new TreeDemo(2);
        TreeDemo tree003 = new TreeDemo(3);
        tree001.left = tree002;
        tree001.right = tree003;
//        System.out.print(tree001.val + " ");
        ergodic(tree001);

    }

    private static void ergodic(TreeDemo treeDemo) {
        if (treeDemo == null) return;
        System.out.print(treeDemo.val + " ");
        ergodic(treeDemo.left);
        ergodic(treeDemo.right);
    }
}
