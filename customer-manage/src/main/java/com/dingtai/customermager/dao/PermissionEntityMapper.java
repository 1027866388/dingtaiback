package com.dingtai.customermager.dao;


import com.dingtai.customermager.entity.db.PermissionEntity;

/**
 * Auto Gernerated
 *
 * @author auto
 * @date 2019-03-06 09:50
 */
public interface PermissionEntityMapper {
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
    int insert(PermissionEntity record);

    /**
     * 写入一条符合条件的记录
     *
     * @param record 实体对象
     * @return
     */
    int insertSelective(PermissionEntity record);

    /**
     * 根据主键查询一条记录
     *
     * @param id 主键
     * @return
     */
    PermissionEntity selectByPrimaryKey(Long id);

    /**
     * 根据主键更新一条符合条件的记录
     *
     * @param record 实体对象
     * @return
     */
    int updateByPrimaryKeySelective(PermissionEntity record);

    /**
     * 根据主键更新一条记录
     *
     * @param record 实体对象
     * @return
     */
    int updateByPrimaryKey(PermissionEntity record);
}