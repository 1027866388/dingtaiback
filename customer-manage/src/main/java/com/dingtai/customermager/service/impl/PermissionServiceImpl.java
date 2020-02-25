package com.dingtai.customermager.service.impl;

import com.dingtai.customermager.constants.PermissionConstant;
import com.dingtai.customermager.dao.*;
import com.dingtai.customermager.entity.response.GetUserListResp;
import com.dingtai.customermager.entity.response.ZtreeResp;
import com.dingtai.customermager.service.PermissionService;
import com.dingtai.customermager.entity.Result;
import com.dingtai.customermager.entity.db.RoleEntity;
import com.dingtai.customermager.entity.response.GetPermissionTreeResp;
import com.dingtai.customermager.entity.response.ListPermissionResp;
import com.dingtai.customermager.service.UserService;
import com.dingtai.customermager.utils.ShiroUtils;
import com.dingtai.customermager.utils.StringUtil;
import com.google.common.base.Joiner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 权限接口实现
 *
 * @author wangyanhui
 * @date 2018-04-13 14:55
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    /**
     * 权限信息Mapper
     */
    @Autowired
    private PermissionInfoMapper permissionInfoMapper;

    @Autowired
    private PermissionEntityMapper permissionEntityMapper;

    /**
     * 角色权限Mapper
     */
    @Autowired
    private RolePermissionInfoMapper rolePermissionInfoMapper;

    /**
     * 用户Mapper
     */
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleEntityMapper roleEntityMapper;

    /**
     * 获取权限列表信息
     *
     * @return 权限列表
     */
    @Override
    public List<ListPermissionResp> listPerms() {
        return permissionInfoMapper.listPerms();
    }

    /**
     * 获取权限树
     *
     * @return
     */
    @Override
    public Result<List<ZtreeResp>> treePerms() {
        Result result;
        List<ListPermissionResp> permissionList = permissionInfoMapper.listPerms();
        List<ZtreeResp> zTreeBeans = new ArrayList<>();
        if (permissionList != null && !permissionList.isEmpty()) {
            for (ListPermissionResp permissionResp : permissionList) {
                ZtreeResp tree = new ZtreeResp();
                tree.setpId(permissionResp.getParentId());
                tree.setName(permissionResp.getName());
                tree.setOpen(false);
                tree.setChkDisabled(false);
                tree.setId(permissionResp.getId());
                zTreeBeans.add(tree);
            }
        }
        return new Result<>(zTreeBeans);
    }

    /**
     * 获取用户权限
     *
     * @return
     */
    @Override
    public List<GetPermissionTreeResp> getUserPermissionList() {

        Long currentUserId = ShiroUtils.getUserId();
        //系统管理员，拥有最高权限
        if (PermissionConstant.SUPER_ADMIN_USER_ID.equals(currentUserId)) {
            return getAllPermissionList(null);
        }
        //用户菜单列表
        List<Long> menuIdList = getCurrentUserAllPermIds();
        return getAllPermissionList(menuIdList);
    }

    /**
     * 获取所有菜单列表
     */
    private List<GetPermissionTreeResp> getAllPermissionList(List<Long> menuIdList) {
        //查询根菜单列表
        List<GetPermissionTreeResp> menuList = queryListParentId(0L, menuIdList);
        //设置图标
        for (GetPermissionTreeResp tree : menuList) {
            tree.setPicName(tree.getPicName());
        }
        //递归获取子菜单
        getPermissionTreeList(menuList, menuIdList);
        return menuList;
    }

    /**
     * 递归
     */
    private List<GetPermissionTreeResp> getPermissionTreeList(List<GetPermissionTreeResp> menuList, List<Long> menuIdList) {
        List<GetPermissionTreeResp> subMenuList = new ArrayList<GetPermissionTreeResp>();
        for (GetPermissionTreeResp entity : menuList) {
            List<GetPermissionTreeResp> children = getPermissionTreeList(queryListParentId(entity.getPermissionId(), menuIdList), menuIdList);
            entity.setChildren(children);
            subMenuList.add(entity);
        }
        return subMenuList;
    }

    public List<GetPermissionTreeResp> queryListParentId(Long parentId, List<Long> permissionIdList) {
        List<GetPermissionTreeResp> permList = permissionInfoMapper.getPermissionInfoByParentId(parentId);
        if (permissionIdList == null) {
            return permList;
        }
        List<GetPermissionTreeResp> userPermissionList = new ArrayList<>();
        for (GetPermissionTreeResp permission : permList) {
            if (permissionIdList.contains(permission.getPermissionId())) {
                userPermissionList.add(permission);
            }
        }
        return userPermissionList;
    }

    /**
     * 是不是超级管理员
     *
     * @param userId
     * @return
     */
    @Override
    public boolean isSuperAdmin(Long userId) {
        boolean result = false;
        Result<GetUserListResp> userInfo = userService.getUserByUserId(userId);
        String roleIs = null;
        if (userInfo != null && userInfo.getData() != null) {
            roleIs = userInfo.getData().getRoleId();
            String[] roleIds = roleIs.split(",");
            for (String roleId : roleIds) {
                Long id = Long.valueOf(roleId);
                if (id.equals(PermissionConstant.SUPER_ADMIN_ROLE_ID)) {
                    result = true;
                }
            }
        }
        return result;
    }

    /**
     * 是不是经营绩效指标管理员
     *
     * @param userId
     * @return
     */
    @Override
    public boolean idKpiAdmin(Long userId) {
        boolean result = false;
        Result<GetUserListResp> userInfo = userService.getUserByUserId(userId);
        String roleIs = null;
        if (userInfo != null && userInfo.getData() != null) {
            roleIs = userInfo.getData().getRoleId();
            String[] roleIds = roleIs.split(",");
            for (String roleId : roleIds) {
                Long id = Long.valueOf(roleId);
                RoleEntity roleEntity = roleEntityMapper.selectByPrimaryKey(id);
                if (roleEntity != null && roleEntity.getRoleName() != null && PermissionConstant.KPI_ADMIN_ROLE_NAME.equals(roleEntity.getRoleName())) {
                    result = true;
                }
            }
        }
        return result;
    }

    /**
     * 是否有某个权限
     *
     * @param perm
     * @return
     */
    @Override
    public boolean hasPerMission(Long perm) {

        List<Long> permissionIds = getCurrentUserAllPermIds();
        if (permissionIds != null && permissionIds.size() > 0) {
            for (Long item : permissionIds) {
                if (perm.equals(item)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 获取当前用户的全部根权限Id
     *
     * @return
     */
    @Override
    public List<Long> getRoots() {
        List<Long> allPermIds = getCurrentUserAllPermIds();
        String result = Joiner.on(",").join(allPermIds);
        List<Long> roots = permissionInfoMapper.getRoot(result);
        return roots;
    }

    @Override
    public List<String> getCurrentUserAllPerms() {
        List<Long> ids = getCurrentUserAllPermIds();
        String result = Joiner.on(",").join(ids);
        return permissionInfoMapper.getPermSign(result);
    }

    /**
     * 获取当前用户的所有权限Id
     *
     * @return
     */
    @Override
    public List<Long> getCurrentUserAllPermIds() {
        Long currentUserId = ShiroUtils.getUserId();
        List<Long> permissionIds = new ArrayList<>();
        //超级管理员，获取全部权限
        if (currentUserId.equals(PermissionConstant.SUPER_ADMIN_USER_ID)) {
            permissionIds = permissionInfoMapper.listAllPerms();
        } else {
            String roleIds = "";
            GetUserListResp userInfo = userInfoMapper.getUserByUserId(currentUserId);
            if (userInfo != null) {
                roleIds = userInfo.getRoleId();
                String[] roleList = roleIds.split(",");
                //获取所有角色的所有权限
                for (String roleId : roleList) {
                    List<Long> leafPermissionIds = rolePermissionInfoMapper.selectPermissionIdByRoleId(Long.parseLong(roleId));
                    permissionIds.addAll(getAllPermsIdsByLeafNode(leafPermissionIds));
                }
            }

        }
        //去重
        HashSet h = new HashSet(permissionIds);
        permissionIds.clear();
        permissionIds.addAll(h);
        return permissionIds;
    }

    /**
     * 根据叶节点获取所有的权限
     *
     * @param leafNodes
     * @return
     */
    private List<Long> getAllPermsIdsByLeafNode(List<Long> leafNodes) {
        List<Long> allPermission = new ArrayList<>();
        allPermission.addAll(leafNodes);
        getParent(allPermission, leafNodes);
        return allPermission;
    }

    /**
     * 获取 一个节点的所有父节点
     *
     * @param currentList
     * @param currentNodes
     * @return
     */
    private void getParent(List<Long> currentList, List<Long> currentNodes) {
        String result = Joiner.on(",").join(currentNodes);
        currentNodes = new ArrayList<>();
        if (!StringUtil.isEmpty(result)) {
            List<Long> parents = permissionInfoMapper.getParents(result);
            for (Long parent : parents) {
                if (!parent.equals(0L)) {
                    currentNodes.add(parent);
                }
                currentList.add(parent);
            }
        }
        if (currentNodes != null && currentNodes.size() > 0) {
            getParent(currentList, currentNodes);
        }
    }
}
