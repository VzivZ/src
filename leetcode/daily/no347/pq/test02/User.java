package leetcode.daily.no347.pq.test02;

/**
 * @description:
 * @author: VzivZ
 * @date: 2020-09-07 20:06
 **/
public class User {
    public final String name;
    public final String number;

    public User(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String toString() {
        return name + "/" + number;
    }
}
