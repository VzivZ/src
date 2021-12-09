package demo001;


/**
 * @description: 按天超时流程量趋势
 * @author: VzivZ
 * @date: 2019-12-11 14:54
 **/
public class OvertimeDaysModel implements Cloneable{
    private String days;
    private Integer blockCount = 0;

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public Integer getBlockCount() {
        return blockCount;
    }

    public void setBlockCount(Integer blockCount) {
        this.blockCount = blockCount;
    }
}
