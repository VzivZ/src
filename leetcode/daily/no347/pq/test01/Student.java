package leetcode.daily.no347.pq.test01;

/**
 * @description:
 * @author: VzivZ
 * @date: 2020-09-07 15:19
 **/
public class Student {
    private String name;  //名字
    private int score;    //分数

    public Student(String name) {
        this.name = name;
    }


    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
