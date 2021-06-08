package com.jiangls.serializable.handle;

import com.jiangls.serializable.annotation.DomainFilters;
import com.jiangls.serializable.annotation.DomainTargets;
import com.jiangls.serializable.constant.DataAclConstant;
import com.jiangls.serializable.constant.DataAclDemoConstant;
import com.jiangls.serializable.constant.DomainStandardAction;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo00DomainAclHandleImpl implements DomainAclHandle {

    private static final long serialVersionUID = 1071215333497522340L;

    @DomainFilters({DataAclConstant.FW_ALL_DATA_FILTER})
    private List<DomainFilterHandle> filterHandles;

    @DomainTargets({DataAclConstant.FW_ORGANIZATION_TARGET, DataAclConstant.FW_USER_TARGET, DataAclConstant.FW_ROLE_TARGET,
            DataAclConstant.FW_GROUP_TARGET, DataAclConstant.FW_CREATOR_TARGET})
    private List<DomainTargetHandle> targetHandles;


    @Override
    public String getCode() {
        return DataAclDemoConstant.DOMAIN_CODE_00;
    }

    @Override
    public List<DomainFilterHandle> getDomainFilters() {
        return filterHandles;
    }

    @Override
    public List<DomainTargetHandle> getDomainTargets() {
        return targetHandles;
    }

    @Override
    public List<String> getDomainActions() {
        List<String> actions = new ArrayList<>();
        actions.add(DomainStandardAction.WRITE.toString());
        actions.add(DomainStandardAction.DELETE.toString());
        return actions;
    }

    @Override
    public void doSaveAuthorizeTarget(Map<String, List<String>> authorizeTarget) throws RuntimeException {
        for (String key : authorizeTarget.keySet()) {
            System.out.println("key: " + key);
        }
    }

    @Override
    public String buildVisitorTargetSQL(List<String> visitorTargets) {
        StringBuffer whereSQL = new StringBuffer();
        for (String visitorTarget : visitorTargets) {
            if (StringUtils.isNotBlank(visitorTarget)) {
                if (whereSQL.length() > 0) {
                    whereSQL.append(" or ");
                }
                whereSQL.append("A.TARGET_DATA='" + visitorTarget + "'");
            }
        }
        return whereSQL.toString();
    }

    @Override
    public Map<String, Object> getDataMap(List<String> ids) {
        HashMap<String, Object> dataPagingMap = new HashMap<>();
        dataPagingMap.put("temp", new Object());
        return dataPagingMap;
    }

    @Override
    public Map<String, Object> getDataPagingMap(int pageIndex) {
        Map<String, Object> dataPagingMap = new HashMap<>();
        dataPagingMap.put("temp", new Object());
        // 进行分页
        return dataPagingMap;
    }
}
