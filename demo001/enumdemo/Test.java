package demo001.enumdemo;

public class Test {
    /*使用*/
    public static void main(String[] args) {
        System.out.println(Level.isValidateLevel(33));
        System.out.println("level: " + Level.Three.value());

        System.out.println(StateType.FORBIDDEN.code());
        System.out.println(StateType.BEOVERDUE.value());

        System.out.println(StateType.isValidateStateType("aaa","ccc"));
    }
}
