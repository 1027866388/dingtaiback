package com.dingtai.customermager.entity.db;

public class ProjectEntity {
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