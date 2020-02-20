package com.dingtai.customermager.dao;


import com.dingtai.customermager.entity.db.RolePermissionEntity;
import org.springframework.stereotype.Repository;

/**
 * GetConstructionCost
 *
 * @author zhurongyu
 * @date 2018-11-03 20:50
 */
@Repository
public interface RolePermissionEntityMapper {
    /**
     * 根据主键删除一条记录
     *
     * @param id 主键
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 写入一条记录
     *
     * @param record 实体对象
     * @return
     */
    int insert(RolePermissionEntity record);

    /**
     * 写入一条符合条件的记录
     *
     * @param record 实体对象
     * @return
     */
    int insertSelective(RolePermissionEntity record);

    /**
     * 根据主键查询一条记录
     *
     * @param id 主键
     * @return
     */
    RolePermissionEntity selectByPrimaryKey(Long id);

    /**
     * 根据主键更新一条符合条件的记录
     *
     * @param record 实体对象
     * @return
     */
    int updateByPrimaryKeySelective(RolePermissionEntity record);

    /**
     * 根据主键更新一条记录
     *
     * @param record 实体对象
     * @return
     */
    int updateByPrimaryKey(RolePermissionEntity record);
}