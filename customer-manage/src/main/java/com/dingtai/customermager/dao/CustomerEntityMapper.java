package com.dingtai.customermager.dao;

import com.dingtai.customermager.entity.db.CustomerEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerEntityMapper {
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
    int insert(CustomerEntity record);

    /**
     *  写入一条符合条件的记录
     *
     * @param record 实体对象
     * @return 
     */
    int insertSelective(CustomerEntity record);

    /**
     *  根据主键查询一条记录
     *
     * @param id 主键
     * @return 
     */
    CustomerEntity selectByPrimaryKey(Long id);

    /**
     *  根据主键更新一条符合条件的记录
     *
     * @param record 实体对象
     * @return 
     */
    int updateByPrimaryKeySelective(CustomerEntity record);

    /**
     *  根据主键更新一条记录
     *
     * @param record 实体对象
     * @return 
     */
    int updateByPrimaryKey(CustomerEntity record);
}