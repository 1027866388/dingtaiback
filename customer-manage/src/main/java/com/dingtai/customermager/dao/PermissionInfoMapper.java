package com.dingtai.customermager.dao;

import com.dingtai.customermager.entity.request.GetPermissionListReq;
import com.dingtai.customermager.entity.response.GetPermissionTreeResp;
import com.dingtai.customermager.entity.response.ListPermissionResp;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 权限信息Mapper
 *
 * @author wangyanhui
 * @date 2018-03-19 20:15
 */
@Repository
public interface PermissionInfoMapper {
    /**
     * 获取权限信息列表
     *
     * @param request 请求实体
     * @return
     */
    Page<ListPermissionResp> listPermissionInfo(GetPermissionListReq request);

    /**
     * 获取所有权限
     *
     * @return 列表
     */
    List<Long> listAllPerms();


    /**
     * 根据上级权限id获取权限信息
     *
     * @param parentId 上级权限id
     * @return 列表
     */
    List<GetPermissionTreeResp> getPermissionInfoByParentId(Long parentId);


    /**
     * 获取权限标识列表
     *
     * @return 列表
     */
    List<ListPermissionResp> listPerms();

    /**
     * 查询非按钮的权限列表
     *
     * @return 权限列表
     */
    List<ListPermissionResp> queryNotButtonList();

    /**
     * 根据权限Id查询权限标识
     *
     * @param permissionId
     * @return
     */
    String getPermsByPermissionId(@Param(value = "permissionId") Long permissionId);

    /**
     * 根据权限标识查询权限信息
     *
     * @param perms
     * @return
     */
    List<ListPermissionResp> getPermissionInfoByPerms(@Param(value = "perms") String perms);

    /**
     * 获取所有的根节点
     *
     * @param ids
     * @return
     */
    List<Long> getRoot(@Param(value = "ids") String ids);

    /**
     * 获取一个节点的父节点
     *
     * @param ids
     * @return
     */
    List<Long> getParents(@Param(value = "ids") String ids);

    /**
     * 获取所有的权限标记
     *
     * @param ids
     * @return
     */
    List<String> getPermSign(@Param(value = "ids") String ids);

}