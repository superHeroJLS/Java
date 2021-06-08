package com.jiangls.serializable.handle;

import java.util.List;
import java.util.Map;

/**
 * 业务数据域授权目标操作接口<br>
 */
public interface DomainTargetHandle {

    /**
     * 取得业务数据域授权目标编码
     * 
     * @return 业务数据域授权目标编码
     */
    String getCode();

    /**
     * 取得数据实体授权目标清单<br>
     * <br>
     * 注意：<br>
     * 1、本方法不允许抛出异常<br>
     * 2、不允许返回null值，只可以返回长度为0的Map对象
     * 
     * @param parameterValue
     *            授权目标运行参数值
     * @param dataMap
     *            数据实体映射表。key：数据实体编号，value：数据实体对象
     * @return 数据实体授权目标清单。key：数据实体编号，value：授权目标清单
     */
    Map<String, List<String>> getAuthorizeTarget(String parameterValue, Map<String, Object> dataMap);

    /**
     * 取得数据访问者授权目标清单 <br>
     * <br>
     * 注意：<br>
     * 1、本方法不允许抛出异常<br>
     * 2、不允许返回null值，只可以返回长度为0的List对象
     * 
     * @param parameterValue
     *            授权目标运行参数值
     * @param visitor
     *            数据访问者用户ID
     * @return 数据访问者授权目标清单
     */
    List<String> getVisitorTarget(String parameterValue, Long visitor);

    /**
     * 判断数据访问者是否属于数据实体授权目标清单范围<br>
     * <br>
     * 注意：<br>
     * 1、本方法不允许抛出异常<br>
     * 2、不允许返回null值，只可以返回长度为0的List对象
     *
     * @param parameterValue
     *            授权目标运行参数值
     * @param visitor
     *            数据访问者用户ID
     * @param dataMap
     *            数据实体映射表。key：数据实体编号，value：数据实体对象
     * @return 在范围内的数据实体编号列表
     */
    List<String> isUserInTarget(String parameterValue, Long visitor, Map<String, Object> dataMap);
}
