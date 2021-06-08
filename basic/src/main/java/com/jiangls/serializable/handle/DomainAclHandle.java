package com.jiangls.serializable.handle;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 业务数据域操作接口<br>
 */
public interface DomainAclHandle extends Serializable {

    /**
     * 取得业务数据域编码
     * 
     * @return 业务数据域编码
     */
    String getCode();

    /**
     * 取得业务数据域数据过滤器列表
     * 
     * @return 业务数据域数据过滤器列表
     */
    List<DomainFilterHandle> getDomainFilters();

    /**
     * 取得业务数据域授权目标列表
     * 
     * @return 业务数据域授权目标列表
     */
    List<DomainTargetHandle> getDomainTargets();

    /**
     * 取得业务数据域业务动作列表
     * 
     * @return 业务数据域业务动作列表
     */
    List<String> getDomainActions();

    /**
     * 存储数据实体授权目标清单
     * 
     * @param authorizeTarget
     *            数据实体授权目标清单。key：数据实体编号，value：授权目标清单
     * @throws RuntimeException
     */
    void doSaveAuthorizeTarget(Map<String, List<String>> authorizeTarget) throws RuntimeException;

    /**
     * 构建授权目标SQL，该SQL作为业务查询的子语句，以过滤数据访问者可见范围
     * 
     * @param visitorTargets
     *            数据访问者授权目标清单
     * @return 授权目标SQL
     */
    String buildVisitorTargetSQL(List<String> visitorTargets);

    /**
     * 根据编号列表，获取数据实体映射表
     * <br>
     * 注意：<br>
     * 1、本方法不允许抛出异常<br>
     * 2、不允许返回null值，只可以返回长度为0的Map对象
     *
     * @param ids
     *            编号列表
     * @return 数据实体映射表。key：数据实体编号，value：数据实体对象
     */
    Map<String, Object> getDataMap(List<String> ids);

    /**
     * 取得数据实体分页列表，该方法主要应用于定时刷新授权信息操作
     * <br>
     * 注意：<br>
     * 1、本方法不允许抛出异常<br>
     * 2、不允许返回null值，只可以返回长度为0的Map对象
     *
     * @param pageIndex
     *            页码。首页编码为0
     * @return 数据实体分页列表
     */
    Map<String, Object> getDataPagingMap(int pageIndex);
}
