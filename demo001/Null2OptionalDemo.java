package demo001;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @description:
 * @author: VzivZ
 * @date: 2020-03-05 15:25
 **/
public class Null2OptionalDemo {
    public static void main(String[] args) {
        Optional<List<String>> list = getNamesFromDB();
        list.ifPresent(names ->
        {
            for (String name : names) {
                System.out.println(name);
            }
        });
    }

    private static Optional<List<String>> getNamesFromDB() {
        String[] names = {"沉默王二", "一枚有趣的程序员", "微信搜索关注我"};
        return Optional.of(Arrays.asList(names));
    }
}
