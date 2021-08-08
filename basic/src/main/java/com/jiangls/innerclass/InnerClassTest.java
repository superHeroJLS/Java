package com.jiangls.innerclass;

/**
 * <ol>
 *     <li>外部类实例变量能访问非static内部类实例变量和常量</li>
 *     <li>外部类static变量只能访问非static内部类常量</li>
 *     <li>外部类常量只能访问非static内部类常量</li>
 *
 *     <li>外部类实例方法能访问非static内部类实例变量和常量</li>
 *     <li>外部类静态方法只能访问非static内部类常量</li>
 * </ol>
 */
public class InnerClassTest {
    private String os;
    private static String oss = "ss";
    private static final String SFS = "ss";

    private String os2 = new InnerClass().is;
    private String os3 = InnerClass.ISFS;

    private static String oss2 = InnerClass.ISFS;

    private static final String SFS2 = InnerClass.ISFS;


    private void ma() {
        // 访问非static内部类实例变量和常量
        System.out.println(new InnerClass().is);
        System.out.println(InnerClassTest.InnerClass.ISFS);
    }

    private static void smb() {
        // 访问非static内部类常量
        System.out.println(InnerClassTest.InnerClass.ISFS);
    }

    /**
     * <ol>
     *     <li>非static内部类不能定义static变量和方法</li>
     *     <li>非static内部类可以定义常量</li>
     * </ol>
     *
     * <ol>
     *     <li>非static内部类的实例变量可以赋值为外部类所有变量</li>
     *     <li>非static内部类的static变量可以赋值为外部类static变量</li>
     *     <li>非static内部类的实例方法可以访问外部类所有变量和方法</li>
     * </ol>
     */
    class InnerClass {
        String is;
        private static final String ISFS = "isfs";

        String is2 = os;
        String is3 = SFS;
        private static final String ISFS2 = SFS;


        // Inner classes cannot have static declarations
//        private static String iss = "iss";

        private void im() {
            // 调用外部类实例变量和static变量
            System.out.println(os);
            System.out.println(oss);

            // 调用外部类实例方法和static方法
            ma();
            smb();
        }

        // Inner classes cannot have static declarations
//        private static void sim() {}
    }

    public static void main(String[] args) {
        // 创建外部类实例和非static内部类实例
        InnerClassTest outer = new InnerClassTest();
        InnerClass inner = outer.new InnerClass();
    }

}
