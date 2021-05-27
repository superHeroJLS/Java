package com.jiangls.exception;

public class TryCatch {

    public static void main(String[] args) {
        new TryCatch().testReachable();
    }

    protected void testReachable() throws RuntimeException{
        try {
            if (Boolean.TRUE) {
                throw new RuntimeException("runtime exception");
            }
        // 异常在catch块中被处理了例如printStackTrace或者不做任何处理，catch块后面的代码就可以继续执行。
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        //异常块在catch中没有被处理，而是直接抛出一个新的异常，catch块后面的代码就不会继续执行。
//        } catch (RuntimeException e) {
//            throw new RuntimeException(e);
//        }

        // finally块中的代码一定会执行
//        } catch (RuntimeException e) {
//            throw new RuntimeException(e);
//        } finally {
//            System.out.println("finally block");
//        }

        System.out.println("code block after catch block");
    }
}
