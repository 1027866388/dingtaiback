package com.dingtai.customermager.entity.response;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 *  TODO
 * 分页使用的对象
 *  
 *  @author qizhuzhu
 *  @date 2018-08-07 11:28
 *  
 */
@ApiModel("分页返回值")
public class PageResp<T> {
    @ApiModelProperty("总条数")
    long total;

    @ApiModelProperty("总页数")
    int pageNum;

    @ApiModelProperty("数据集合")
    List<T> data;

    @ApiModelProperty("表头数据")
    List<?> columns;

    public List<?> getColumns() {
        return columns;
    }

    public void setColumns(List<?> columns) {
        this.columns = columns;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
