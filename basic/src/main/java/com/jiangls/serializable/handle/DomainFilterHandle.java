package com.jiangls.serializable.handle;

import java.util.Map;

/**
 * 业务数据域数据过滤器操作接口<br>
 */
public interface DomainFilterHandle {

    /**
     * 取得业务数据域数据过滤器编码
     * 
     * @return 业务数据域数据过滤器编码
     */
    String getCode();

    /**
     * 过滤数据实体 <br>
     * <br>
     * 注意：<br>
     * 1、本方法不允许抛出异常<br>
     * 2、不允许返回null值，只可以返回长度为0的Map对象
     * 
     * @param parameterValue
     *            数据过滤器运行参数值
     * @param dataMap
     *            原始数据实体映射表。key：数据实体编号，value：数据实体对象
     * @return 过滤后数据实体。key：数据实体编号，value：数据实体对象
     */
    Map<String, Object> filterData(String parameterValue, Map<String, Object> dataMap);
}
