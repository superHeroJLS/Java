package com.jiangls.innerclass;

/**
 * <ol>
 *     <li>外部类实例变量、static变量和常量能访问static内部类实例变量、static变量和常量</li>
 *
 *     <li>外部类实例方法、static方法能访问static内部类实例变量、static变量和常量</li>
 * </ol>
 */
public class StaticInnerClassTest {
    private String os;
    private static String oss = "ss";
    private static final String OSFS = "ss";

    private String os2 = new StaticInnerClass().is;
    private String os3 = StaticInnerClass.iss;
    private String os4 = StaticInnerClass.ISFS;

    private static String oss2 = new StaticInnerClass().is;
    private static String oss3 = StaticInnerClass.iss;
    private static String oss4 = StaticInnerClass.ISFS;

    private static final String OSFS2 = new StaticInnerClass().is;
    private static final String OSFS3 = StaticInnerClass.iss;
    private static final String OSFS4 = StaticInnerClass.ISFS;



    private void ma() {
        // 调用static内部类实例变量和实例方法
        System.out.println(new StaticInnerClass().is);
        new StaticInnerClass().im();


        // 调用static内部类static变量、常量和static方法
        System.out.println(StaticInnerClass.iss);
        System.out.println(StaticInnerClass.ISFS);
        StaticInnerClass.sim();
    }

    private static void smb() {
        // 调用static内部类实例变量和实例方法
        System.out.println(new StaticInnerClass().is);
        new StaticInnerClass().im();


        // 调用static内部类static变量、常量和static方法
        System.out.println(StaticInnerClass.iss);
        System.out.println(StaticInnerClass.ISFS);
        StaticInnerClass.sim();
    }

    /**
     * <ol>
     *     <li>static内部类可以定义实例变量、static变量、常量、实例方法、static方法</li>
     *     <li>static内部类变量可以访问外部类静态变量和常量</li>
     *     <li>stati内部类方法可以访问外部类静态变量、常量、静态方法</li>
     * </ol>
     */
    static class StaticInnerClass {
        String is;
        static String iss = "ss";
        private static final String ISFS = "isfs";

        String is2 = oss;
        String is3 = OSFS;

        static String iss2 = oss;
        static String iss3 = OSFS;

        static final String ISFS2 = oss;
        static final String ISFS3 = OSFS;


        protected void im() {
            // 调用外部类static变量和static方法
            System.out.println(oss);
            System.out.println(OSFS);
            smb();

            // 调用自身的实例变量、static变量和常量
            System.out.println(is);
            System.out.println(iss);
            System.out.println(ISFS);

            // 不能调用外部类实例变量和实例方法
//            ma();
//            System.out.println(s);
        }

        protected static void sim() {
            // 调用外部类static变量和static方法
            System.out.println(iss);
            System.out.println(OSFS);
            smb();

            // 调用自身的static变量和常量
            System.out.println(iss);
            System.out.println(ISFS);

        }
    }

    public static void main(String[] args) {
        StaticInnerClassTest outer = new StaticInnerClassTest();
        StaticInnerClass staticInner = new StaticInnerClass();
    }
}
