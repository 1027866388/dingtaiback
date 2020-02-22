package com.dingtai.customermager.dao;

import com.dingtai.customermager.entity.db.CustomerFollowEntity;

public interface CustomerFollowEntityMapper {
    /**
     *  根据主键删除一条记录
     *
     * @param id 主键
     * @return 
     */
    int deleteByPrimaryKey(Long id);

    /**
     *  写入一条记录
     *
     * @param record 实体对象
     * @return 
     */
    int insert(CustomerFollowEntity record);

    /**
     *  写入一条符合条件的记录
     *
     * @param record 实体对象
     * @return 
     */
    int insertSelective(CustomerFollowEntity record);

    /**
     *  根据主键查询一条记录
     *
     * @param id 主键
     * @return 
     */
    CustomerFollowEntity selectByPrimaryKey(Long id);

    /**
     *  根据主键更新一条符合条件的记录
     *
     * @param record 实体对象
     * @return 
     */
    int updateByPrimaryKeySelective(CustomerFollowEntity record);

    /**
     *  根据主键更新一条记录
     *
     * @param record 实体对象
     * @return 
     */
    int updateByPrimaryKey(CustomerFollowEntity record);
}