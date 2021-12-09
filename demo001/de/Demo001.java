package demo001.de;

import java.math.BigDecimal;

/**
 * @description:
 * @author: VzivZ
 * @date: 2020-07-10 11:40
 **/
public class Demo001 {
    public static void main(String[] args) {
        if (isDbEqualsInterFace(1, 1)) {
            System.out.println("噢噢噢噢");
        }
    }

    private static boolean isDbEqualsInterFace(Object dbVal, Object interfaceVal) {

        if (dbVal instanceof Double) {
            dbVal = new BigDecimal((Double) dbVal);
        }
        if (dbVal instanceof Integer) {
            dbVal = new BigDecimal((Integer) dbVal);
        }

        if (interfaceVal instanceof Double) {
            interfaceVal = new BigDecimal((Double) interfaceVal);
        }
        if (interfaceVal instanceof Integer) {
            interfaceVal = new BigDecimal((Integer) interfaceVal);
        }

        if (dbVal instanceof BigDecimal && interfaceVal instanceof BigDecimal) {
            return ((BigDecimal) dbVal).compareTo((BigDecimal) interfaceVal) == 0;
        } else {
            dbVal = String.valueOf(dbVal);
            interfaceVal = String.valueOf(interfaceVal);
            return dbVal.equals(interfaceVal);
        }
    }
}
