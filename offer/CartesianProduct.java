package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 笛卡儿积
 * @author: HeZhe
 * @date: 2020-04-20 17:45
 **/
public class CartesianProduct {
    public List<List<String>> descartes(List<List<String>> dimValue) {
        List<List<String>> res = new ArrayList<>();
        if (dimValue == null || dimValue.size() == 0)
            return res;
        backtrace(dimValue, 0, res, new ArrayList<>());
        return res;

    }

    /**
     * 递归回溯法求解
     *
     * @param dimValue 原始数据集合
     * @param index    当前执行的集合索引
     * @param result   结果集合
     * @param curList  当前的单个结果集
     */
    private void backtrace(List<List<String>> dimValue, int index,
                           List<List<String>> result, List<String> curList) {

        if (curList.size() == dimValue.size())
            result.add(new ArrayList<>(curList));
        else
            for (int j = 0; j < dimValue.get(index).size(); j++) {
                curList.add(dimValue.get(index).get(j));
                backtrace(dimValue, index + 1, result, curList);
                curList.remove(curList.size() - 1);
            }

    }

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        List<String> list2 = new ArrayList<>();
        list2.add("0");
        list2.add("1");
        list2.add("2");
        List<List<String>> dimValue = new ArrayList<>();
        dimValue.add(list1);
        dimValue.add(list2);

        // 递归实现笛卡尔积
        CartesianProduct s = new CartesianProduct();
        List<List<String>> res = s.descartes(dimValue);
        System.out.println("递归实现笛卡尔乘积: 共 " + res.size() + " 个结果");
        for (List<String> list : res) {
            for (String string : list) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }
}
