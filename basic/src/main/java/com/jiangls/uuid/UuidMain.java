package com.jiangls.uuid;

import java.util.UUID;

/**
 * @author Jiangls
 * @date 2022/5/5
 */
public class UuidMain {
    public static void main(String[] args) {
        // 生成uuid
        String strUuid = UUID.randomUUID().toString();
        System.out.println("before: " +strUuid);
        // 删除横杠的uuid
        String strUuidWithoutDash = strUuid.replace("-", "");
        System.out.println("after: " + strUuidWithoutDash);


    }
}
