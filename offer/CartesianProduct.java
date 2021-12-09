package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: �ѿ�����
 * @author: VzivZ
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
     * �ݹ���ݷ����
     *
     * @param dimValue ԭʼ���ݼ���
     * @param index    ��ǰִ�еļ�������
     * @param result   �������
     * @param curList  ��ǰ�ĵ��������
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

        // �ݹ�ʵ�ֵѿ�����
        CartesianProduct s = new CartesianProduct();
        List<List<String>> res = s.descartes(dimValue);
        System.out.println("�ݹ�ʵ�ֵѿ����˻�: �� " + res.size() + " �����");
        for (List<String> list : res) {
            for (String string : list) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }
}
