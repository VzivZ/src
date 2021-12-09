package yjt;

/**
 * @Description:
 * @Author VzivZ
 * @Date 2021/11/3 18:23
 */
public class AAA {
    public void test() {
        System.out.println("aaaa");
    }
}

abstract class Image {
    protected AAA aaa;
}

class BMPImage extends Image {
    BMPImage bmpImage = new BMPImage();

    public void test() {
        aaa.test();
    }
}
