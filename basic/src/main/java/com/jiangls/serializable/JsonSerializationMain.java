package com.jiangls.serializable;

import com.jiangls.serializable.handle.Demo00DomainAclHandleImpl;
import com.jiangls.serializable.handle.DomainAclHandle;
import com.jiangls.serializable.json.JsonSerializeUtil;

public class JsonSerializationMain {
    /**
     * 1 Demo00DomainAclHandleImpl实例序列化JSON字节数组
     * 2 JSON字节数组反序列化为Demo00DomainAclHandleImpl实例
     * 3 注意Demo00DomainAclHandleImpl类在反序列化的时候一定要存在，否则无法发序列化成正确类型的实例
     * @param args
     */
    public static void main(String[] args) {
        Demo00DomainAclHandleImpl demoDomain = new Demo00DomainAclHandleImpl();

        // serialize
        byte[] demoDomainJsonArray = JsonSerializeUtil.serializeAsBytes(demoDomain);
        System.out.println("demoDomainJsonArray length: " + demoDomainJsonArray.length);

        // deserialize
        Object demoDomainDeserialized = JsonSerializeUtil.deserialize(demoDomainJsonArray, Object.class);
        System.out.println(demoDomainDeserialized);
    }
}
