package java.lang1;

/**
 * 错误: 在类 java.lang.String 中找不到 main 方法, 请将 main 方法定义为:
 *    public static void main(String[] args)
 * 否则 JavaFX 应用程序类必须扩展javafx.application.Application
 * 因为双亲委派机制保证了类的唯一性、防篡改
 */
public class String {
    public static void main(String[] args) {
        System.out.println("定义一个java.lang.String类");
    }
}
