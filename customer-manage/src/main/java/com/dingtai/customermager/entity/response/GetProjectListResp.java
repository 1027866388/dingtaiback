package com.dingtai.customermager.entity.response;

/**
 * 获取项目列表请求实体
 *
 * @author peng.lu
 * @date 2020/2/22
 */
public class GetProjectListResp {

    /**
     * 项目id
     */
    private Long id;

    /**
     * 项目名称
     */
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
