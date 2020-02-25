package com.dingtai.customermager.service;

import com.dingtai.customermager.entity.response.ZtreeResp;
import com.dingtai.customermager.entity.Result;
import com.dingtai.customermager.entity.response.GetPermissionTreeResp;
import com.dingtai.customermager.entity.response.ListPermissionResp;

import java.util.List;

/**
 * 权限接口
 *
 * @author wangyanhui
 * @date 2018-04-13 14:25
 */
public interface PermissionService {


    /**
     * 获取权限标识列表
     *
     * @return 列表
     */
    List<ListPermissionResp> listPerms();

    /**
     * 获取权限树
     *
     * @return
     */
    Result<List<ZtreeResp>> treePerms();

    /**
     * 获取用户权限列表
     *
     * @return
     */
    List<GetPermissionTreeResp> getUserPermissionList();


    /**
     * 是否是超级管理员
     *
     * @param userId
     * @return
     */
    public boolean isSuperAdmin(Long userId);

    /**
     * 是不是经营绩效指标管理员
     *
     * @param userId
     * @return
     */
    public boolean idKpiAdmin(Long userId);

    /**
     * 是否有某个权限
     *
     * @param perm
     * @return
     */
    public boolean hasPerMission(Long perm);

    /**
     * 获取当前用户的所有根节点（菜单节点）
     *
     * @return
     */
    public List<Long> getRoots();

    /**
     * 获取当前用户的所有权限id（全树）
     *
     * @return
     */
    public List<Long> getCurrentUserAllPermIds();


    /**
     * 获取所有的权限
     *
     * @return
     */
    public List<String> getCurrentUserAllPerms();

}
