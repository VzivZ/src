package demo001;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 找出List中最大的5个
 * @author: VzivZ
 * @date: 2019-07-02 15:37
 **/
public class Top5 {
    private static List<Integer> max5(List<Integer> lst) {
        if (lst.size() <= 5)
            return lst;
        int a = lst.remove(lst.size() - 1);

        List<Integer> b = max5(lst);
        for (int i = 0; i < b.size(); i++) {
            int t = b.get(i);
            if (a > t) {
                lst.set(i, a);
                a = t;
            }
        }
        return b;
    }

    public static void main(String[] args) {
        List<Integer> lst = new ArrayList<>(
                Arrays.asList(12, 127, 85, 66, 27, 34, 15, 344, 156, 344, 29, 47));
        System.out.println(max5(lst));
    }
}
