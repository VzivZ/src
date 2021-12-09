package demo001;

/**
 * @description: 找出最大的K个数
 * @author: HeZhe
 * @date: 2019-07-02 15:54
 **/
public class TopK {
    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 5, 7, 6, 2, 8, 9};
        //模拟需要排序的数组
        int k = 4;
        //模拟需要返回的前k个最大数字
        int[] res = cSAndRe(arr, k);
        for (int i : res) {
            System.out.println(i);
        }
    }

    private static int[] cSAndRe(int[] arr, int k) {
        chooseSort(arr, k);
        int[] res = new int[k];
        System.arraycopy(arr, 0, res, 0, k);
        return res;
    }

    private static void chooseSort(int[] arr, int k) {
        for (int i = 0; i < k; i++) {
            int index = i;
            for (int j = i; j < arr.length; j++)
                if (arr[index] > arr[j]) index = j;
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }
}
