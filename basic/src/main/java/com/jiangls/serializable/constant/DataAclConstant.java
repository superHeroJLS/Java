package com.jiangls.serializable.constant;

public class DataAclConstant {

    /** 数据级授权服务消息通讯topic、type */
    public static final String FW_SECURITY_DATAACL_MSG_TOPIC = "FW_SECURITY_DATAACL_MSG_TOPIC";
    public static final String FW_SECURITY_DATAACL_MSG_TYPE_STARTUP = "FW_SECURITY_DATAACL_MSG_TYPE_STARTUP";

    /** 定时刷新数据级授权时间点的配置关键字（时：00~23） */
    public static final String REFRESH_HOUR_KEY = "framework.security.dataacl.refresh_hour";

    /** 数据级授权服务标准Filter、Target */
    public static final String FW_ALL_DATA_FILTER = "FW_ALL_DATA_FILTER";
    public static final String FW_CREATOR_TARGET = "FW_CREATOR_TARGET";
    public static final String FW_ORGANIZATION_TARGET = "FW_ORGANIZATION_TARGET";
    public static final String FW_USER_TARGET = "FW_USER_TARGET";
    public static final String FW_GROUP_TARGET = "FW_GROUP_TARGET";
    public static final String FW_ROLE_TARGET = "FW_ROLE_TARGET";

    public static final String LOG_TYPE_DATAACL = "FW_DATAACL_MODIFY";
}
