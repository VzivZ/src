package demo001.de;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: HeZhe
 * @date: 2020-04-24 16:50
 **/
public class RemoveDemo {
    public static void main(String[] args) {
        String[] arrays = {"1", "2", "3"};
        List<String> list = new ArrayList<>(Arrays.asList(arrays));
        list.removeIf("1"::equals);

        System.out.println(list.size());
//        for (String str : list) {
//            if (str.equals("2")) {
//                list.remove(str);
//            }
//        }
    }
}
