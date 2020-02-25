package com.dingtai.customermager.entity.request;

import com.dingtai.customermager.constants.PaginationConstant;
import io.swagger.annotations.ApiModelProperty;

/**
 * 分页基类
 *
 * @author wangyanhui
 * @date 2018-03-19 19:31
 */
public class BasePageReq {
    /**
     * 当前页
     */
    @ApiModelProperty(value = "当前页", name = "pageCurrent", allowEmptyValue = true)
    private Integer pageCurrent;

    /**
     * 每页数量
     */
    @ApiModelProperty(value = "每页数量", name = "pageSize", allowEmptyValue = true)
    private Integer pageSize;

    /**
     * 排序字段
     */
    @ApiModelProperty(value = "排序字段", name = "orderBy", allowEmptyValue = true)
    private String orderBy = "id";

    /**
     * 升序或降序
     */
    @ApiModelProperty(value = "升序或降序", name = "descOrAsc", allowEmptyValue = true)
    private String descOrAsc;

    /**
     * 当页首记录下标.
     */
    private Integer pageBegin;

    public Integer getPageCurrent() {
        if (pageCurrent == null || pageCurrent == 0) {
            return PaginationConstant.DEFAULT_PAGE_NUM;
        } else {
            return pageCurrent;
        }
    }

    public void setPageCurrent(Integer pageCurrent) {
        this.pageCurrent = pageCurrent;
    }

    public Integer getPageSize() {
        if (pageSize == null || pageSize == 0) {
            return PaginationConstant.DEFAULT_PAGE_SIZE;
        } else {
            return pageSize;
        }
    }

    /**
     * 返回当前页首条记录下标（内部参数）.
     *
     * @return 当前页首条记录的下标
     */
    public int getPageBegin() {
        if (null == pageCurrent || 0 >= pageCurrent) {
            this.pageBegin = 0;
        } else {
            this.pageBegin = (pageCurrent - 1) * pageSize;
        }
        return pageBegin;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getDescOrAsc() {
        return descOrAsc;
    }

    public void setDescOrAsc(String descOrAsc) {
        this.descOrAsc = descOrAsc;
    }

    @Override
    public String toString() {
        return "BasePageReq{" + "pageCurrent=" + pageCurrent + ", pageSize=" + pageSize + ", orderBy='" + orderBy + '\'' + ", descOrAsc='" + descOrAsc + '\'' + '}';
    }
}
